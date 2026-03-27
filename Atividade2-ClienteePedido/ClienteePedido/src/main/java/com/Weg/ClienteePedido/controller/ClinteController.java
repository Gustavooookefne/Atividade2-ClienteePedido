package com.Weg.ClienteePedido.controller;

import com.Weg.ClienteePedido.dto.ClienteDto.ClienteRequestDto;
import com.Weg.ClienteePedido.dto.ClienteDto.ClienteResponseDto;
import com.Weg.ClienteePedido.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClinteController {

    private final ClienteService service;

    @PutMapping
    public ClienteResponseDto salvar (@RequestBody ClienteRequestDto requestDto) {
        return service.salvar(requestDto);
    }

    @GetMapping
    public List<ClienteResponseDto> listarTodos () {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ClienteResponseDto listarPorId (@PathVariable Long id) {
        return service.listarPorId(id);
    }

    @PostMapping("/{id}")
    public ClienteResponseDto atualizar (@RequestBody ClienteRequestDto requestDto , @PathVariable Long id) {
        return service.atualizar(requestDto , id);
    }

    @DeleteMapping("/{id}")
    public void deletar (Long id) {
        service.deletar(id);
    }
}
