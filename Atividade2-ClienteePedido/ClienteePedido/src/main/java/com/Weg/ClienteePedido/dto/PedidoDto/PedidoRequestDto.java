package com.Weg.ClienteePedido.dto.PedidoDto;

import java.time.LocalDate;

public record PedidoRequestDto (
        String nome,
        LocalDate dataDeEntrega,
        String descricao
){

}
