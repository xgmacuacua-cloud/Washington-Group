package com.example.washington.service;

import com.example.washington.model.Avaliacao;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataService {
    private final String FILE_PATH = "dados.json";
    private final ObjectMapper mapper;

    public DataService() {
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
    }

    public List<Avaliacao> listarTodos() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();
        try {
            return mapper.readValue(file, new TypeReference<List<Avaliacao>>() {});
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    public void salvar(Avaliacao avaliacao) {
        List<Avaliacao> lista = listarTodos();
        lista.add(avaliacao);
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(FILE_PATH), lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
