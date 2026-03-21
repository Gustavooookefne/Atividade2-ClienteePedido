package com.Weg.ClienteePedido.dto.PedidoDto;

import java.time.LocalDate;
import java.util.UUID;

public record PedidoResponseDto (
        UUID id,
        LocalDate dataDeEntrega,
        String descricao
){

}
