package com.example.public_library;

import br.edu.unichristus.domain.dto.IsbnDTO;
import br.edu.unichristus.domain.dto.IsbnLowDTO;
import br.edu.unichristus.domain.dto.IsbnRolesDTO;
import br.edu.unichristus.domain.model.Isbn;
import br.edu.unichristus.exception.CommonsException;
import br.edu.unichristus.repositoryIsbnRepository;
import br.edu.unichristus.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IsbnService {
    private final IsbnRepository repository;

    public IsbnService(IsbnRepository repository) {
        this.repository = repository;
    }

    public IsbnDTO criar(IsbnDTO dto) {
        Isbn isbn = Isbn.builder()
                .number(dto.getNumber())
                .edition(dto.getEdition())
                .yearPublication(dto.getYearPublication())
                .build();
        repository.save(isbn);
        return toDTO(isbn);
    }

    public List<IsbnLowDTO> listAll() {
        return repository.findAll().stream()
                .map(this::toLowDTO)
                .collect(Collectors.toList());
    }

    public IsbnDTO getById(Long id) {
        Isbn isbn = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ISBN not found"));
        return toDTO(isbn);
    }

    public IsbnDTO edit(Long id, IsbnDTO dto) {
        Isbn isbn = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ISBN not found"));
        isbn.setNumber(dto.getNumber());
        isbn.setEdition(dto.getEdition());
        isbn.setYearPublication(dto.getYearPublication());
        repository.save(isbn);
        return toDTO(isbn);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private IsbnDTO toDTO(Isbn isbn) {
        IsbnDTO dto = new IsbnDTO();
        dto.setNumber(isbn.getNumber());
        dto.setEdition(isbn.getEdition());
        dto.setYearPublication(isbn.getYearPublication());
        return dto;
    }

    private IsbnLowDTO toLowDTO(Isbn isbn) {
        IsbnLowDTO dto = new IsbnLowDTO();
        dto.setId(isbn.getId());
        dto.setNumber(isbn.getNumber());
        return dto;
    }
}
