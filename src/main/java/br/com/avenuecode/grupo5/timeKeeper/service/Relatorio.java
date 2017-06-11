package br.com.avenuecode.grupo5.timeKeeper.service;

import br.com.avenuecode.grupo5.timeKeeper.entities.Ponto;
import br.com.avenuecode.grupo5.timeKeeper.entities.Solicitacao;
import br.com.avenuecode.grupo5.timeKeeper.entities.Usuario;

import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Created by xa0 on 10/06/17.
 */
public class Relatorio {

    private String usuario;
    private int horasDeTrabalho;
    private double mediaDeHoras;
    private long solicitacoesFalta;
    private long solicitacoesFerias;
    private long solicitacoesAtestado;
    private long totalSolicitacoes;

    public Relatorio(){ }

    public Relatorio(Usuario usuario){
        this.usuario = usuario.getLogin();
        this.horasDeTrabalho = usuario.getJornadaDiaria();
        this.mediaDeHoras = calcularMediaHoras(usuario.getPontos());
        this.solicitacoesFalta = usuario.getSolicitacoes().stream().filter(s -> s.getTipo() == Solicitacao.Tipo.FALTA).count();
        this.solicitacoesAtestado = usuario.getSolicitacoes().stream().filter(s -> s.getTipo() == Solicitacao.Tipo.ATESTADO).count();
        this.solicitacoesFerias = usuario.getSolicitacoes().stream().filter(s -> s.getTipo() == Solicitacao.Tipo.FERIAS).count();
        this.totalSolicitacoes = this.solicitacoesAtestado + this.solicitacoesFerias + this.solicitacoesFalta;
    }

    private double calcularMediaHoras(List<Ponto> pontos){
        double media = pontos.stream().mapToLong(
                ponto -> ChronoUnit.SECONDS.between(ponto.getEntrada().toInstant(), ponto.getSaida().toInstant())
        ).sum() / pontos.size();

        media = media / 3600;

        return media;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getHorasDeTrabalho() {
        return horasDeTrabalho;
    }

    public void setHorasDeTrabalho(int horasDeTrabalho) {
        this.horasDeTrabalho = horasDeTrabalho;
    }

    public double getMediaDeHoras() {
        return mediaDeHoras;
    }

    public void setMediaDeHoras(double mediaDeHoras) {
        this.mediaDeHoras = mediaDeHoras;
    }

    public long getSolicitacoesFalta() {
        return solicitacoesFalta;
    }

    public void setSolicitacoesFalta(long solicitacoesFalta) {
        this.solicitacoesFalta = solicitacoesFalta;
    }

    public long getSolicitacoesFerias() {
        return solicitacoesFerias;
    }

    public void setSolicitacoesFerias(long solicitacoesFerias) {
        this.solicitacoesFerias = solicitacoesFerias;
    }

    public long getSolicitacoesAtestado() {
        return solicitacoesAtestado;
    }

    public void setSolicitacoesAtestado(long solicitacoesAtestado) {
        this.solicitacoesAtestado = solicitacoesAtestado;
    }

    public long getTotalSolicitacoes() {
        return totalSolicitacoes;
    }

    public void setTotalSolicitacoes(long totalSolicitacoes) {
        this.totalSolicitacoes = totalSolicitacoes;
    }
}
