package com.salesianostriana.dam.SupplyHub.dto;

import com.salesianostriana.dam.SupplyHub.model.Estado;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record CreatePedidoRequest(@NotNull LocalDateTime fecha,@NotNull Long idProveedor) {
}
