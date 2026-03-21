package com.Weg.ClienteePedido.mapper;

import com.Weg.ClienteePedido.dto.ClienteDto.ClienteRequestDto;
import com.Weg.ClienteePedido.dto.ClienteDto.ClienteResponseDto;
import com.Weg.ClienteePedido.model.Cliente;

public class ClienteMapper {

    public Cliente paraEntidade (ClienteRequestDto requestDto) {
        return new Cliente(
                requestDto.nome(),
                requestDto.cpf()
        );
    }

    public ClienteResponseDto paraDto (Cliente cliente){
        return new ClienteResponseDto(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf()
        );
    }
}
