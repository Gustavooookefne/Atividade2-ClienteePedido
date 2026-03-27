package com.Weg.ClienteePedido.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "data_entrega" , nullable = false)
    private LocalDate dataDeEntrega;

    @Column(name = "descricao" , nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;


    public Pedido(String nome, LocalDate dataDeEntrega, String descricao) {
    }
}
