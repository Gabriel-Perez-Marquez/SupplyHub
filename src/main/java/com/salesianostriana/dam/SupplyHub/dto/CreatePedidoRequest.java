package com.salesianostriana.dam.SupplyHub.dto;

import com.salesianostriana.dam.SupplyHub.model.Estado;

import java.time.LocalDateTime;

public record CreatePedidoRequest(LocalDateTime fecha, Long idProveedor) {
}
