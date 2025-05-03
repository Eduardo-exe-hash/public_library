package com.example.public_library.service;

import com.example.public_library.dto.PublisherDTO;
import com.example.public_library.model.Publisher;
import com.example.public_library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    @Autowired
    private PublisherRepository repository;

    public PublisherDTO save(PublisherDTO dto) {
        Publisher publisher = convertToEntity(dto);
        return convertToDTO(repository.save(publisher));
    }

    public PublisherDTO findById(Long id) {
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Editora não encontrada"));
    }

    public List<PublisherDTO> findByName(String name) {
        return repository.findByNameContainingIgnoreCase(name)
                .stream().map(this::convertToDTO).toList();
    }

    public List<PublisherDTO> listAll() {
        return repository.findAll().stream().map(this::convertToDTO).toList();
    }

    public PublisherDTO update(Long id, PublisherDTO dto) {
        Publisher existingPublisher = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Editora não encontrada"));

        existingPublisher.setName(dto.getName());
        existingPublisher.setCity(dto.getCity());
        existingPublisher.setCountry(dto.getCountry());
        existingPublisher.setEmail(dto.getEmail());

        return convertToDTO(repository.save(existingPublisher));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Editora não encontrada para deletar");
        }
        repository.deleteById(id);
    }

    private PublisherDTO convertToDTO(Publisher publisher) {
        return new PublisherDTO(
                publisher.getId(),
                publisher.getName(),
                publisher.getCity(),
                publisher.getCountry(),
                publisher.getEmail()
        );
    }

    private Publisher convertToEntity(PublisherDTO dto) {
        return new Publisher(
                dto.getId(),
                dto.getName(),
                dto.getCity(),
                dto.getCountry(),
                dto.getEmail()
        );
    }
}
