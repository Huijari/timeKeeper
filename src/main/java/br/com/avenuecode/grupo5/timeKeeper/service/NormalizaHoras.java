package br.com.avenuecode.grupo5.timeKeeper.service;

import br.com.avenuecode.grupo5.timeKeeper.entities.Ponto;
import br.com.avenuecode.grupo5.timeKeeper.entities.Usuario;

import java.util.Calendar;
import java.util.List;
import java.time.temporal.ChronoUnit;

import static br.com.avenuecode.grupo5.timeKeeper.entities.Usuario.Cargo;

public class NormalizaHoras {

    public static long somaDiaSimples (List<Ponto> pontos){
        long agregado = pontos.stream().mapToLong(
                ponto -> ChronoUnit.SECONDS.between(ponto.getEntrada().toInstant(), ponto.getSaida().toInstant())
        ).sum();
        return agregado;
    }

    public static long somaDiaNormalizada(List<Ponto> pontos, Usuario usuario){
        long soma = somaDiaSimples(pontos);
        long horarioBaseSegundos = usuario.getJornadaDiaria() * 3600;
        long diferenca = soma - horarioBaseSegundos;
        long resultado = soma;
        if(diferenca > 0){
            double multiplicador;
            switch(usuario.getCargo()){
                case GERENTE:
                    multiplicador = 0.6;
                    break;
                case DIRETOR:
                    multiplicador = 0.7;
                    break;
                default:
                    multiplicador = 0.5;
            }
            resultado += (long) (diferenca * multiplicador);
        }

        return resultado;
    }



}
