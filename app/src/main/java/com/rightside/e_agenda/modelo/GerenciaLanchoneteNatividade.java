package com.rightside.e_agenda.modelo;

import java.io.Serializable;

public class GerenciaLanchoneteNatividade implements Serializable {

    private String lanchoneteId;
    private String lanchoneteNome;
    private String lanchoneteLocal;
    private String lanchoneteTelefone;
    private String lanchoneteWhats;
    private String lanchoneteHorario;
    private String lanchoneteEmail;

    public GerenciaLanchoneteNatividade() {
    }

    public GerenciaLanchoneteNatividade(String lanchoneteId, String lanchoneteNome, String lanchoneteLocal, String lanchoneteTelefone, String lanchoneteWhats, String lanchoneteHorario) {
        this.lanchoneteId = lanchoneteId;
        this.lanchoneteNome = lanchoneteNome;
        this.lanchoneteLocal = lanchoneteLocal;
        this.lanchoneteTelefone = lanchoneteTelefone;
        this.lanchoneteWhats = lanchoneteWhats;
        this.lanchoneteHorario = lanchoneteHorario;
        this.lanchoneteEmail = lanchoneteEmail;
    }

    public String getLanchoneteId() {
        return lanchoneteId;
    }

    public void setLanchoneteId(String lanchoneteId) {
        this.lanchoneteId = lanchoneteId;
    }

    public String getLanchoneteNome() {
        return lanchoneteNome;
    }

    public void setLanchoneteNome(String lanchoneteNome) {
        this.lanchoneteNome = lanchoneteNome;
    }

    public String getLanchoneteLocal() {
        return lanchoneteLocal;
    }

    public void setLanchoneteLocal(String lanchoneteLocal) {
        this.lanchoneteLocal = lanchoneteLocal;
    }

    public String getLanchoneteTelefone() {
        return lanchoneteTelefone;
    }

    public void setLanchoneteTelefone(String lanchoneteTelefone) {
        this.lanchoneteTelefone = lanchoneteTelefone;
    }

    public String getLanchoneteWhats() {
        return lanchoneteWhats;
    }

    public void setLanchoneteWhats(String lanchoneteWhats) {
        this.lanchoneteWhats = lanchoneteWhats;
    }

    public String getLanchoneteHorario() {
        return lanchoneteHorario;
    }

    public void setLanchoneteHorario(String lanchoneteHorario) {
        this.lanchoneteHorario = lanchoneteHorario;
    }

    public String getLanchoneteEmail() {
        return lanchoneteEmail;
    }

    public void setLanchoneteEmail(String lanchoneteEmail) {
        this.lanchoneteEmail = lanchoneteEmail;
    }
}
