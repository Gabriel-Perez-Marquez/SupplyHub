package com.salesianostriana.dam.SupplyHub.controller;

import com.salesianostriana.dam.SupplyHub.dto.ProductoSummaryDto;
import com.salesianostriana.dam.SupplyHub.model.Producto;
import com.salesianostriana.dam.SupplyHub.repository.ProductoRepository;
import com.salesianostriana.dam.SupplyHub.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductoController {


    private final ProductoService productoService;




}
