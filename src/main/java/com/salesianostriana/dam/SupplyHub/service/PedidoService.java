package com.salesianostriana.dam.SupplyHub.service;

import com.salesianostriana.dam.SupplyHub.dto.AddProductoToPedidoRequest;
import com.salesianostriana.dam.SupplyHub.dto.CreatePedidoRequest;
import com.salesianostriana.dam.SupplyHub.model.*;
import com.salesianostriana.dam.SupplyHub.repository.OfertaProveedorRepository;
import com.salesianostriana.dam.SupplyHub.repository.PedidoRepository;
import com.salesianostriana.dam.SupplyHub.repository.ProductoRepository;
import com.salesianostriana.dam.SupplyHub.repository.ProveedorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PedidoService {


    private final ProveedorRepository proveedorRepository;
    private final PedidoRepository pedidoRepository;
    private final ProductoRepository productoRepository;
    private final OfertaProveedorRepository ofertaProveedorRepository;



    public Pedido crearPedido(CreatePedidoRequest dto){
        Proveedor p = proveedorRepository.findById(dto.idProveedor()).orElseThrow(() -> new EntityNotFoundException("No existe ningún proveedor con esa id"));

        Pedido pedido = Pedido.builder()
                .fecha(dto.fecha())
                .estado(Estado.CREADO)
                .proveedor(p)
                .build();

        return pedidoRepository.save(pedido);
    }

    public Pedido agregarProducto(AddProductoToPedidoRequest dto){
        Pedido pedido = pedidoRepository.findById(dto.idPedido()).orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado"));
        Producto producto = productoRepository.findById(dto.idProducto()).orElseThrow(() -> new EntityNotFoundException("Producto no encontrado"));

        if(!ofertaProveedorRepository.findByProductoAndProveedor(producto, pedido.getProveedor()).isEmpty()){
            return pedido;
        } else {
            throw new EntityNotFoundException("No existe relacion entre el proveedor y el producto seleccionado");
        }

    }

    public Pedido confirmarPedido(Long idPedido) throws BadRequestException {
        Pedido pedido = pedidoRepository.findById(idPedido).orElseThrow(() -> new EntityNotFoundException("Pedido no encontrado"));
        List<OfertaProveedor> ofertaProveedor = ofertaProveedorRepository.findByProveedor(pedido.getProveedor());

        if(!ofertaProveedor.isEmpty()){
            pedido.setEstado(Estado.CONFIRMADO);
        } else {
            throw new BadRequestException("No se puede confimar un pedido sin productos");
        }

        return pedidoRepository.save(pedido);

    }



}
