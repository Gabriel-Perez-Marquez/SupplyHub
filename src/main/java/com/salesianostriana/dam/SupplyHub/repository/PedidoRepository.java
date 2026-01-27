package com.salesianostriana.dam.SupplyHub.repository;

import com.salesianostriana.dam.SupplyHub.model.Estado;
import com.salesianostriana.dam.SupplyHub.model.Pedido;
import com.salesianostriana.dam.SupplyHub.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {


    List<Pedido> findByProveedorAndEstado(Proveedor proveedor, Estado estado);
}
