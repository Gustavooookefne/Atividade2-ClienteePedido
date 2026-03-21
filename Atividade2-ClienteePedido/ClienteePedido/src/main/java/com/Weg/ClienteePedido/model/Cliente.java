package com.Weg.ClienteePedido.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "nome_Cliete" , nullable = false)
    public String nome;

    @Column(name = "cpf_Cliente" , nullable = false)
    public String cpf;


}
