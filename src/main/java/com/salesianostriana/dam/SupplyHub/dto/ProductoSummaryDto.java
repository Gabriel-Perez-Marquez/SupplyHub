package com.salesianostriana.dam.SupplyHub.dto;

import com.salesianostriana.dam.SupplyHub.model.Producto;

public record ProductoSummaryDto(Long id, String nombre, Double precio, int stockActual) {
    static ProductoSummaryDto of(Producto p){
        return new ProductoSummaryDto(
                p.getId(),
                p.getNombre(),
                p.getPrecio(),
                p.getStockActual()
        );
    }
}
