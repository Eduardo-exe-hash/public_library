package com.example.public_library.service;

import com.example.public_library.dto.AuthorDTO;
import com.example.public_library.model.Author;
import com.example.public_library.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    public AuthorDTO save(AuthorDTO dto) {
        Author author = convertToEntity(dto);
        return convertToDTO(repository.save(author));
    }

    public AuthorDTO findById(Long id) {
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
    }

    public List<AuthorDTO> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name)
                .stream().map(this::convertToDTO).toList();
    }

    public List<AuthorDTO> listAll() {
        return repository.findAll().stream().map(this::convertToDTO).toList();
    }

    public AuthorDTO update(Long id, AuthorDTO dto) {
        Author existingAuthor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));

        existingAuthor.setName(dto.getName());
        existingAuthor.setNationality(dto.getNationality());
        existingAuthor.setBiography(dto.getBiography());
        existingAuthor.setEmail(dto.getEmail());

        return convertToDTO(repository.save(existingAuthor));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Autor não encontrado para deletar");
        }
        repository.deleteById(id);
    }

    private AuthorDTO convertToDTO(Author author) {
        return new AuthorDTO(
                author.getId(),
                author.getName(),
                author.getNationality(),
                author.getBiography(),
                author.getEmail()
        );
    }

    private Author convertToEntity(AuthorDTO dto) {
        return new Author(
                dto.getId(),
                dto.getName(),
                dto.getNationality(),
                dto.getBiography(),
                dto.getEmail()
        );
    }
}
