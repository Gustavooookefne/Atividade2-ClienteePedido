package com.Weg.ClienteePedido.controller;

import com.Weg.ClienteePedido.dto.PedidoDto.PedidoRequestDto;
import com.Weg.ClienteePedido.dto.PedidoDto.PedidoResponseDto;
import com.Weg.ClienteePedido.service.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService service;

    @PutMapping
    public ResponseEntity<PedidoResponseDto> salvar (@RequestBody PedidoRequestDto requestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.salvar(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDto>> listarTodos () {
            List<PedidoResponseDto> responseDtos = service.listarTodos();

        return ResponseEntity.ok().body(responseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> listarPorId (@PathVariable UUID id) {
            PedidoResponseDto responseDto = service.listarPorId(id);
        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/{id}")
    public ResponseEntity<PedidoResponseDto> atualizar (@RequestBody PedidoRequestDto requestDto,@PathVariable UUID id)  {
            PedidoResponseDto responseDto = service.atualizar(requestDto , id);

            return ResponseEntity.ok().body(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (UUID id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }


}
