package com.salesianostriana.dam.SupplyHub.repository;

import com.salesianostriana.dam.SupplyHub.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {


    List<Proveedor> findByActivo(boolean activo);
}
