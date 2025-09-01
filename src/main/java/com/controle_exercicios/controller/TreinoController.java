package com.controle_exercicios.controller;

import com.controle_exercicios.dto.TreinoCreateDTO;
import com.controle_exercicios.dto.TreinoResponseDTO;
import com.controle_exercicios.dto.TreinoUpdateDTO;
import com.controle_exercicios.entity.enums.Intensidade;
import com.controle_exercicios.entity.enums.Tipo;
import com.controle_exercicios.service.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/treinos")
public class TreinoController {

    @Autowired
    private TreinoService service;

    @PostMapping
    public ResponseEntity<TreinoResponseDTO> criar (@RequestBody TreinoCreateDTO dto){
        TreinoResponseDTO response = service.criarTreino(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<TreinoResponseDTO>> listar(
            @RequestParam(required = false) Tipo tipo,
            @RequestParam(required = false) Intensidade intensidade){
        List <TreinoResponseDTO> response = service.listar(tipo, intensidade);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreinoResponseDTO> encontrarPorId(@PathVariable Long id){
        TreinoResponseDTO response = service.BuscarPorID(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(response);  //TESTE "FOUND" TROCAR PRA "OK"
    }

    @PutMapping("/{id}")
    public ResponseEntity<TreinoResponseDTO> atualizar(@PathVariable Long id, @RequestBody TreinoUpdateDTO dto){
        TreinoResponseDTO response = service.atualizarTreino(dto, id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletarTreino(id);
        return ResponseEntity.noContent().build();
    }
}
