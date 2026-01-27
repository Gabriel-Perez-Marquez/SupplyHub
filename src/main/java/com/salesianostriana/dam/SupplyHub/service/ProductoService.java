package com.salesianostriana.dam.SupplyHub.service;


import com.salesianostriana.dam.SupplyHub.model.Producto;
import com.salesianostriana.dam.SupplyHub.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.PredicateSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sound.sampled.Port;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;


    public Page<Producto> getProductos(Pageable pageable, @RequestParam String nombre,
                                       @RequestParam Double precioMin, @RequestParam Double precioMax,
                                       @RequestParam Integer stockMin){
        return productoRepository.findAll(pageable);
    }


    static class ProductoSpecifications {
        static PredicateSpecification<Producto> containsName(String nombre){
            return nombre.isEmpty() ? null : (from, criteriaBuilder) ->
                    criteriaBuilder.like(criteriaBuilder.lower(from.get("nombre")), "%" + nombre + "%");
        }

        static PredicateSpecification<Producto>  betweenPrecioBase (Double precioMin, Double precioMax){
            Double realPrecioMin = precioMin != null ? precioMin : Double.NEGATIVE_INFINITY;
            Double realPrecioMax = precioMax != null ? precioMax : Double.POSITIVE_INFINITY;

            return (from, criteriaBuilder) -> criteriaBuilder.between(from.get("precio"), realPrecioMin, realPrecioMax);
        }

        static PredicateSpecification<Producto> greaterThanStockActual(Integer stockMin){
            return stockMin == null ? null : (from, criteriaBuilder) -> criteriaBuilder.greaterThan(from.get("stockActual"), stockMin);
        }



    }


}
