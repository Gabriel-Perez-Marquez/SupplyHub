package com.salesianostriana.dam.SupplyHub.dto;

import com.salesianostriana.dam.SupplyHub.model.Estado;
import com.salesianostriana.dam.SupplyHub.model.Pedido;


import java.time.LocalDateTime;

public record PedidoDto(Long id, LocalDateTime fecha,
                        Estado estado, String nombreProveedor) {

    public static PedidoDto of(Pedido p){
        return new PedidoDto(
                p.getId(),
                p.getFecha(),
                p.getEstado(),
                p.getProveedor().getNombre()
        );
    }
}
