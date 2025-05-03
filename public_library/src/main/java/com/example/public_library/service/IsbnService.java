package com.example.public_library.service;

import com.example.public_library.dto.IsbnDTO;
import com.example.public_library.model.Isbn;
import com.example.public_library.repository.IsbnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IsbnService {

    @Autowired
    private IsbnRepository repository;

    public IsbnDTO save(IsbnDTO dto) {
        Isbn isbn = convertToEntity(dto);
        return convertToDTO(repository.save(isbn));
    }

    public IsbnDTO findById(Long id) {
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("ISBN não encontrado"));
    }

    public List<IsbnDTO> findByNumber(String number) {
        return repository.findByNumberContainingIgnoreCase(number)
                .stream().map(this::convertToDTO).toList();
    }

    public List<IsbnDTO> listAll() {
        return repository.findAll().stream().map(this::convertToDTO).toList();
    }

    public IsbnDTO update(Long id, IsbnDTO dto) {
        Isbn existingIsbn = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ISBN não encontrado"));

        existingIsbn.setNumber(dto.getNumber());
        existingIsbn.setEdition(dto.getEdition());
        existingIsbn.setYearPublication(dto.getYearPublication());
        
        return convertToDTO(repository.save(existingIsbn));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("ISBN não encontrado para deletar");
        }
        repository.deleteById(id);
    }

    private IsbnDTO convertToDTO(Isbn isbn) {
        return new IsbnDTO(
                isbn.getId(),
                isbn.getNumber(),
                isbn.getEdition(),
                isbn.getYearPublication(),
                isbn.getPublisher() != null ? isbn.getPublisher().getId() : null
        );
    }

    private Isbn convertToEntity(IsbnDTO dto) {
        Isbn isbn = new Isbn();
        isbn.setId(dto.getId());
        isbn.setNumber(dto.getNumber());
        isbn.setEdition(dto.getEdition());
        isbn.setYearPublication(dto.getYearPublication());
        return isbn;
    }
}
