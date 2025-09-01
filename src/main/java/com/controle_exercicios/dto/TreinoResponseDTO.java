package com.controle_exercicios.dto;

import com.controle_exercicios.entity.Treino;
import com.controle_exercicios.entity.enums.Intensidade;
import com.controle_exercicios.entity.enums.Tipo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class TreinoResponseDTO {
    private Long id;
    private Tipo tipo;
    private Integer duracao;
    private LocalDate data;
    private Intensidade intensidade;

    public TreinoResponseDTO(Treino treino){
        this.id = treino.getId();
        this.tipo = treino.getTipo();
        this.duracao = treino.getDuracao();
        this.data = treino.getData();
        this.intensidade = treino.getIntensidade();
    }
}
