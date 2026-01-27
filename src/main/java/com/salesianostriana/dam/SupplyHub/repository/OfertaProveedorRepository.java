package com.salesianostriana.dam.SupplyHub.repository;

import com.salesianostriana.dam.SupplyHub.model.OfertaProveedor;
import com.salesianostriana.dam.SupplyHub.model.Producto;
import com.salesianostriana.dam.SupplyHub.model.Proveedor;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OfertaProveedorRepository extends JpaRepository<OfertaProveedor, Long> {


    List<OfertaProveedor> findByProductoAndProveedor(Producto producto, Proveedor proveedor);

    @EntityGraph(attributePaths = {"proveedor", "producto"})
    @Query("select o from OfertaProveedor o where o.proveedor = ?1")
    List<OfertaProveedor> findByProveedor(Proveedor proveedor);


}
