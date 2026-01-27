package com.salesianostriana.dam.SupplyHub.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private boolean activo;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Pedido> pedidos;





}
