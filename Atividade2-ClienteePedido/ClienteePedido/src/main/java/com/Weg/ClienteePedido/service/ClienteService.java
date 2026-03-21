package com.Weg.ClienteePedido.service;

import com.Weg.ClienteePedido.dto.ClienteDto.ClienteRequestDto;
import com.Weg.ClienteePedido.dto.ClienteDto.ClienteResponseDto;
import com.Weg.ClienteePedido.mapper.ClienteMapper;
import com.Weg.ClienteePedido.model.Cliente;
import com.Weg.ClienteePedido.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;

    public ClienteResponseDto salvar (ClienteRequestDto requestDto) {

        Cliente cliente = new Cliente();

        return mapper.paraDto(repository.save(cliente));
    }

    public List<ClienteResponseDto> listarTodos () {
        return repository.findAll()
                .stream()
                .map(mapper::paraDto)
                .toList();
    }

    public ClienteResponseDto listarPorId (Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lista não encontrada"));

        return mapper.paraDto(cliente);
    }

    public ClienteResponseDto atualizar (ClienteRequestDto requestDto , Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setNome(requestDto.nome());
        cliente.setCpf(requestDto.cpf());

        return mapper.paraDto(cliente);
    }

    public void deletar (Long id) {
        repository.deleteById(id);
    }
}
