package com.controle_exercicios.repository;

import com.controle_exercicios.entity.Treino;
import com.controle_exercicios.entity.enums.Intensidade;
import com.controle_exercicios.entity.enums.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreinoRepository extends JpaRepository <Treino, Long>{
   
    List<Treino> findByTipo(Tipo tipo);

    List<Treino> findByIntensidade(Intensidade intensidade);
}
