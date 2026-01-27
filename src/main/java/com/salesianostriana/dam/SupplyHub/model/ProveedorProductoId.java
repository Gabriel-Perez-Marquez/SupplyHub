package com.salesianostriana.dam.SupplyHub.model;

import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProveedorProductoId implements Serializable {

    private Long proveedorId;
    private Long productoId;

}
