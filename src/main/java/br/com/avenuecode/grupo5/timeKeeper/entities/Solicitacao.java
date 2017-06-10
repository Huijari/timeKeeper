/**
 * Created by xa0 on 10/06/17.
 */
package br.com.avenuecode.grupo5.timeKeeper.entities;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Solicitacao {
    public enum Status{
        DEFERIDO, INDEFERIDO, EM_ANALISE
    }

    public enum Tipo{
        FERIAS, ATESTADO, FALTA;
    }

    @Id
    @GeneratedValue
    private long id;

    private String mensagem;
    private Status status;
    private Tipo tipo;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar inicio;

    @Temporal(TemporalType.TIMESTAMP)
    private Calendar fim;

    @ManyToOne
    private Usuario solicitante;

    public Solicitacao(){ }

    public Solicitacao(long id, Calendar inicio, Calendar fim, String mensagem, Tipo tipo, Usuario solicitante){
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.mensagem = mensagem;
        this.tipo = tipo;
        this.status = Status.EM_ANALISE;
        this.solicitante = solicitante;
    }

    public long getId(){
        return this.id;
    }

    public String getMensagem(){
        return this.mensagem;
    }

    public Calendar getInicio(){
        return this.inicio;
    }

    public Calendar getFim(){
        return this.fim;
    }

    public Tipo getTipo(){
        return this.tipo;
    }

    public Status getStatus(){
        return this.status;
    }

    public Usuario getSolicitante(){
        return this.solicitante;
    }

    public void setStatus(Status status){
        this.status = status;
    }
}
