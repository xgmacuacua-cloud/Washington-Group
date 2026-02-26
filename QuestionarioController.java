package com.example.washington.controller;

import com.example.washington.model.Avaliacao;
import com.example.washington.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class QuestionarioController {

    @Autowired
    private DataService dataService;

    @GetMapping("/")
    public String index() {
        return "redirect:/questionario";
    }

    @GetMapping("/questionario")
    public String exibirFormulario() {
        return "questionario";
    }

    @PostMapping("/processar")
    public String processar(@RequestParam String nome, @RequestParam List<Integer> respostas, Model model) {
        // Critério Washington Group
        boolean temDeficiencia = respostas.stream().anyMatch(r -> r == 3 || r == 4);
        String resultado = temDeficiencia ? "Com deficiência" : "Sem deficiência";

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setNome(nome);
        avaliacao.setRespostas(respostas);
        avaliacao.setResultado(resultado);
        avaliacao.setDataHora(LocalDateTime.now());

        dataService.salvar(avaliacao);
        
        model.addAttribute("avaliacao", avaliacao);
        return "resultado";
    }

    @GetMapping("/pessoas-identificadas")
    public String listar(Model model) {
        model.addAttribute("avaliacoes", dataService.listarTodos());
        return "listagem";
    }
}
