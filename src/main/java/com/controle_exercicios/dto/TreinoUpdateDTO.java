package com.controle_exercicios.dto;

import com.controle_exercicios.entity.enums.Intensidade;
import com.controle_exercicios.entity.enums.Tipo;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreinoUpdateDTO {
    private Tipo tipo;
    @Positive
    private Integer duracao;
    @PastOrPresent
    private LocalDate data;
    private Intensidade intensidade;
}
