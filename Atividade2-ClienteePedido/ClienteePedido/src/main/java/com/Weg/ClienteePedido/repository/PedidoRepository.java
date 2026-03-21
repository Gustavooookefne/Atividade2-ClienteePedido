package com.Weg.ClienteePedido.repository;

import com.Weg.ClienteePedido.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido , UUID> {

}
