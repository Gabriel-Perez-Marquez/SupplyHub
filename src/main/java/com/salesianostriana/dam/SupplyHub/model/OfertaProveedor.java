package com.salesianostriana.dam.SupplyHub.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OfertaProveedor {


    @ManyToOne
    @MapsId("proveedorId")
    private Proveedor proveedor;

    @ManyToOne
    @MapsId("productoId")
    private Producto producto;

    @EmbeddedId
    private ProveedorProductoId id;

    private double precioAcordado;
    private int plazoEntregaDias;
    private String skuProveedor;



}
