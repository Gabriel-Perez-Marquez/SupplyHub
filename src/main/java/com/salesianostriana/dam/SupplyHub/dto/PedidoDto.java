package com.salesianostriana.dam.SupplyHub.dto;

import com.salesianostriana.dam.SupplyHub.model.Estado;
import com.salesianostriana.dam.SupplyHub.model.Pedido;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;


import java.time.LocalDateTime;

public record PedidoDto(@NotNull Long id, @NotNull LocalDateTime fecha,
                        @NotNull Estado estado, @NotBlank String nombreProveedor) {

    public static PedidoDto of(Pedido p){
        return new PedidoDto(
                p.getId(),
                p.getFecha(),
                p.getEstado(),
                p.getProveedor().getNombre()
        );
    }
}
