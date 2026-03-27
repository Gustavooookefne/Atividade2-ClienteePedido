package com.Weg.ClienteePedido.controller;

import com.Weg.ClienteePedido.dto.PedidoDto.PedidoRequestDto;
import com.Weg.ClienteePedido.dto.PedidoDto.PedidoResponseDto;
import com.Weg.ClienteePedido.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService service;

    @PutMapping
    public PedidoResponseDto salvar (@RequestBody PedidoRequestDto requestDto) {
        return service.salvar(requestDto);
    }

    @GetMapping
    public List<PedidoResponseDto> listarTodos () {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public PedidoResponseDto listarPorId (@PathVariable UUID id) {
        return service.listarPorId(id);
    }

    @PostMapping("/{id}")
    public PedidoResponseDto atualizar (@RequestBody PedidoRequestDto requestDto,@PathVariable UUID id)  {
        return service.atualizar(requestDto , id);
    }

    @DeleteMapping("/{id}")
    public void deletar (UUID id) {
        service.delete(id);
    }


}
