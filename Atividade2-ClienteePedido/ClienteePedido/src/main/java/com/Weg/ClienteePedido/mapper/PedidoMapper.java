package com.Weg.ClienteePedido.mapper;

import com.Weg.ClienteePedido.dto.PedidoDto.PedidoRequestDto;
import com.Weg.ClienteePedido.dto.PedidoDto.PedidoResponseDto;
import com.Weg.ClienteePedido.model.Pedido;

public class PedidoMapper {

    public Pedido paraEntidade(PedidoRequestDto requestDto){
        return new Pedido(
                requestDto.nome(),
                requestDto.dataDeEntrega(),
                requestDto.descricao()
        );
    }

    public PedidoResponseDto paraDto(Pedido pedido){
        return new PedidoResponseDto(
                pedido.getId(),
                pedido.getDataDeEntrega(),
                pedido.getDescricao()
        );
    }
}
