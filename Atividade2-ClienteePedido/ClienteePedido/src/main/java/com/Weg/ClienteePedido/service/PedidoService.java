package com.Weg.ClienteePedido.service;

import com.Weg.ClienteePedido.dto.PedidoDto.PedidoRequestDto;
import com.Weg.ClienteePedido.dto.PedidoDto.PedidoResponseDto;
import com.Weg.ClienteePedido.mapper.PedidoMapper;
import com.Weg.ClienteePedido.model.Pedido;
import com.Weg.ClienteePedido.repository.PedidoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PedidoService {

    private final PedidoRepository repository;
    private final PedidoMapper mapper;

    public PedidoResponseDto salvar (PedidoRequestDto requestDto) {

        Pedido pedido = new Pedido();

        return mapper.paraDto(repository.save(pedido));
    }

    public List<PedidoResponseDto> listarTodos(){
        return repository.findAll()
                .stream()
                .map(mapper::paraDto)
                .toList();
    }

    public PedidoResponseDto listarPorId (UUID id) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada"));

        return mapper.paraDto(pedido);
    }

    public PedidoResponseDto atualizar (PedidoRequestDto requestDto, UUID id) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        pedido.setDescricao(requestDto.descricao());
        pedido.setDataDeEntrega(requestDto.dataDeEntrega());

        return mapper.paraDto(pedido);
    }

    public void delete (UUID id) {
        repository.deleteById(id);
    }
}
