package com.Weg.ClienteePedido.controller;

import com.Weg.ClienteePedido.dto.ClienteDto.ClienteRequestDto;
import com.Weg.ClienteePedido.dto.ClienteDto.ClienteResponseDto;
import com.Weg.ClienteePedido.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClinteController {

    private final ClienteService service;

    @PutMapping
    public ResponseEntity<ClienteResponseDto> salvar (@RequestBody ClienteRequestDto requestDto) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(service.salvar(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDto>> listarTodos () {
            List<ClienteResponseDto> responseDtos = service.listarTodos();

        return ResponseEntity.ok().body(responseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> listarPorId (@PathVariable Long id) {
            ClienteResponseDto responseDto = service.listarPorId(id);

        return ResponseEntity.ok().body(responseDto);
    }

    @PostMapping("/{id}")
    public ResponseEntity<ClienteResponseDto> atualizar (@RequestBody ClienteRequestDto requestDto , @PathVariable Long id) {
            ClienteResponseDto responseDto = service.atualizar(requestDto , id);
        return ResponseEntity.ok().body(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (Long id) {
        service.deletar(id);

        return ResponseEntity.noContent().build();
    }
}
