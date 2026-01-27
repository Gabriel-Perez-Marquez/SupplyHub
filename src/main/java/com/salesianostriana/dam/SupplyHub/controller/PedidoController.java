package com.salesianostriana.dam.SupplyHub.controller;


import com.salesianostriana.dam.SupplyHub.dto.AddProductoToPedidoRequest;
import com.salesianostriana.dam.SupplyHub.dto.CreatePedidoRequest;
import com.salesianostriana.dam.SupplyHub.dto.PedidoDto;
import com.salesianostriana.dam.SupplyHub.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping("")
    public ResponseEntity<PedidoDto> crearPedido (CreatePedidoRequest dto){
        return ResponseEntity.ok(PedidoDto.of(pedidoService.crearPedido(dto)));
    }


    @PutMapping("/{id}/confirmar")
    public ResponseEntity<PedidoDto> confirmarPedido (@PathVariable(name = "id") Long idPedido) throws BadRequestException {
        return ResponseEntity.ok(PedidoDto.of(pedidoService.confirmarPedido(idPedido)));
    }

    @PostMapping("/{id}/productos")
    public ResponseEntity<PedidoDto> agregarProductoAlPedido (AddProductoToPedidoRequest dto) {
        return ResponseEntity.ok(PedidoDto.of(pedidoService.agregarProducto(dto)));
    }





}
