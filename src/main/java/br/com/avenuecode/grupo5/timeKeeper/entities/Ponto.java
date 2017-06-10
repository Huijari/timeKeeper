package br.com.avenuecode.grupo5.timeKeeper.entities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Ponto {
    @Id
    @GeneratedValue
    private long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar entrada;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar saida;

    public Ponto() {
    }

    public Ponto(long id, Calendar entrada, Calendar saida) {
        this.id = id;
        this.entrada = entrada;
        this.saida = saida;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Calendar getEntrada() {
        return entrada;
    }

    public void setEntrada(Calendar entrada) {
        this.entrada = entrada;
    }

    public Calendar getSaida() {
        return saida;
    }

    public void setSaida(Calendar saida) {
        this.saida = saida;
    }
}
