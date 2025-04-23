package com.example.public_library;

import br.edu.unichristus.domain.dto.UserDTO;
import br.edu.unichristus.domain.dto.UserLowDTO;
import br.edu.unichristus.domain.dto.UserRolesDTO;
import br.edu.unichristus.domain.model.User;
import br.edu.unichristus.exception.CommonsException;
import br.edu.unichristus.repository.UserRepository;
import br.edu.unichristus.utils.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public AutorDTO criar(AutorDTO dto) {
        Autor autor = Autor.builder()
                .nome(dto.getNome())
                .nacionalidade(dto.getNacionalidade())
                .biografia(dto.getBiografia())
                .email(dto.getEmail())
                .build();
        return toDTO(repository.save(autor));
    }

    public List<AutorDTO> listarTodos() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public AutorDTO buscarPorId(Long id) {
        Autor autor = repository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        return toDTO(autor);
    }

    public AutorDTO editar(Long id, AutorDTO dto) {
        Autor autor = repository.findById(id).orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        autor.setNome(dto.getNome());
        autor.setNacionalidade(dto.getNacionalidade());
        autor.setBiografia(dto.getBiografia());
        autor.setEmail(dto.getEmail());
        return toDTO(repository.save(autor));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    private AutorDTO toDTO(Autor autor) {
        AutorDTO dto = new AutorDTO();
        dto.setNome(autor.getNome());
        dto.setNacionalidade(autor.getNacionalidade());
        dto.setBiografia(autor.getBiografia());
        dto.setEmail(autor.getEmail());
        return dto;
    }
}