package com.controle_exercicios.service;

import com.controle_exercicios.dto.TreinoCreateDTO;
import com.controle_exercicios.dto.TreinoResponseDTO;
import com.controle_exercicios.dto.TreinoUpdateDTO;
import com.controle_exercicios.entity.Treino;
import com.controle_exercicios.entity.enums.Intensidade;
import com.controle_exercicios.entity.enums.Tipo;
import com.controle_exercicios.repository.TreinoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository repository;

    //CREATE
    public TreinoResponseDTO criarTreino (TreinoCreateDTO dto){
        Treino treino = new Treino();
        treino.setTipo(dto.getTipo());
        treino.setDuracao(dto.getDuracao());
        treino.setData(dto.getData());
        treino.setIntensidade(dto.getIntensidade());

        Treino save = repository.save(treino);
        return new TreinoResponseDTO(save);
    }
    //LIST
    public List<TreinoResponseDTO> listar(Tipo tipo, Intensidade intensidade){
        List<Treino> treinos;
        if (tipo != null){
            treinos = repository.findByTipo(tipo);
        } else if (intensidade != null) {
            treinos = repository.findByIntensidade(intensidade);
        }else {
            treinos = repository.findAll();
        }
        return treinos.stream().map(TreinoResponseDTO::new).collect(Collectors.toList());
    }
    //FIND BY ID
    public TreinoResponseDTO BuscarPorID(Long id){
        Treino treino = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Treino não encontrado"));
        return new TreinoResponseDTO(treino);
    }
    //UPDATE
    public TreinoResponseDTO atualizarTreino(TreinoUpdateDTO dto, Long id){
        Treino treino = repository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Treino não encontrado"));
        if (dto.getTipo() != null) treino.setTipo(dto.getTipo());
        if (dto.getDuracao() != null) treino.setDuracao(dto.getDuracao());
        if (dto.getData() != null) treino.setData(dto.getData());
        if (dto.getIntensidade() != null) treino.setIntensidade(dto.getIntensidade());

        Treino atualizado = repository.save(treino);
        return new TreinoResponseDTO(atualizado);
    }

    //DELETE
    public void deletarTreino(Long id){
        if(!repository.existsById(id)){
            throw new EntityNotFoundException("Treino não encontrado");
        }
        repository.deleteById(id);
    }
}
