package com.Weg.ClienteePedido.service;

import com.Weg.ClienteePedido.dto.PedidoDto.PedidoRequestDto;
import com.Weg.ClienteePedido.dto.PedidoDto.PedidoResponseDto;
import com.Weg.ClienteePedido.mapper.PedidoMapper;
import com.Weg.ClienteePedido.model.Pedido;
import com.Weg.ClienteePedido.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final PedidoMapper mapper;

    public PedidoResponseDto salvar (PedidoRequestDto requestDto) {

        Pedido pedido = new Pedido();

        return mapper.paraDto(repository.save(pedido));
    }
}
