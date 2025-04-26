package com.example.public_library;

import br.edu.unichristus.domain.dto.PublisherDTO;
import br.edu.unichristus.domain.dto.PublisherLowDTO;
import br.edu.unichristus.domain.dto.PublisherRolesDTO;
import br.edu.unichristus.domain.model.Publisher;
import br.edu.unichristus.exception.CommonsException;
import br.edu.unichristus.repository.PublisherRepository;
import br.edu.unichristus.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository repository;

    public EditoraService(PublisherRepository repository) {
        this.repository = repository;
    }

    public PublisherDTO criar(PublisherDTO dto) {
        Publisher publisher = Publisher.builder()
                .name(dto.getName())
                .city(dto.getCity())
                .country(dto.getCountry())
                .email(dto.getEmail())
                .build();
        return toDTO(repository.save(publisher));
    }

    public List<PublisherDTO> listAll() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public PublisherDTO getById(Long id) {
        Publisher publisher = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));
        return toDTO(editora);
    }

    public PublisherDTO edit(Long id, PublisherDTO dto) {
        Publisher publisher = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found"));

        publisher.setName(dto.getName());
        publisher.setCity(dto.getCity());
        publisher.setCountry(dto.getCountry());
        publisher.setEmail(dto.getEmail());

        return toDTO(repository.save(publisher));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private PublisherDTO toDTO(Publisher publisher) {
        return new PublisherDTO(
                publisher.getName(),
                publisher.getCity(),
                publisher.getCountry(),
                publisher.getEmail()
        );
    }
}
