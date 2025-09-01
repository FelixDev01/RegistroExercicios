package com.controle_exercicios.entity;

import com.controle_exercicios.entity.enums.Intensidade;
import com.controle_exercicios.entity.enums.Tipo;

import java.time.LocalDate;

public class Treino {
    private Long id;
    private Tipo tipo;
    private String duracao;
    private LocalDate data;
    private Intensidade intensidade;

}
