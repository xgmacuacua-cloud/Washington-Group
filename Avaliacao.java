package com.example.washington.model;

import java.time.LocalDateTime;
import java.util.List;

public class Avaliacao {
    private String nome;
    private LocalDateTime dataHora;
    private List<Integer> respostas;
    private String resultado;

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
    
    public List<Integer> getRespostas() { return respostas; }
    public void setRespostas(List<Integer> respostas) { this.respostas = respostas; }
    
    public String getResultado() { return resultado; }
    public void setResultado(String resultado) { this.resultado = resultado; }
}
