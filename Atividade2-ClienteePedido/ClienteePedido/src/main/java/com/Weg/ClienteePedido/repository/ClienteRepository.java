package com.Weg.ClienteePedido.repository;

import com.Weg.ClienteePedido.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente , Long> {
}
