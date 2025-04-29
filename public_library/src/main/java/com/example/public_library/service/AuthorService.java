package com.example.public_library;

import br.edu.unichristus.domain.dto.AuthorDTO;
import br.edu.unichristus.domain.dto.AuthorLowDTO;
import br.edu.unichristus.domain.dto.AuthorRolesDTO;
import br.edu.unichristus.domain.model.Author;
import br.edu.unichristus.exception.CommonsException;
import br.edu.unichristus.repository.AuthorRepository;
import br.edu.unichristus.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public AutorDTO create(AuthorDTO dto) {
        Author author = Author.builder()
                .name(dto.getName())
                .nationality(dto.getNationality())
                .biography(dto.getBiography())
                .email(dto.getEmail())
                .build();
        return toDTO(repository.save(author));
    }

    public List<AuthorDTO> listAll() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public AuthorDTO getById(Long id) {
        Author author = repository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        return toDTO(author);
    }

    public AuthorDTO edit(Long id, AuthorDTO dto) {
        Autor author = repository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        autor.setName(dto.getName());
        autor.setNationality(dto.getNationality());
        autor.setBiography(dto.getBiography());
        autor.setEmail(dto.getEmail());
        return toDTO(repository.save(author));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private AuthorDTO toDTO(Author author) {
        AuthorDTO dto = new AuthorDTO();
        dto.setName(autor.getName());
        dto.setNationality(autor.getNationality());
        dto.setBiography(autor.getBiography());
        dto.setEmail(autor.getEmail());
        return dto;
    }
}
