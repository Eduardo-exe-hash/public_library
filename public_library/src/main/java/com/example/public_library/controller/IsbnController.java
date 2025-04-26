package com.example.public_library.controller;

import com.seu.pacote.dto.IsbnDTO;
import com.seu.pacote.dto.IsbnLowDTO;
import com.seu.pacote.dto.MessageDTO;
import com.seu.pacote.service.IsbnService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/isbn")
public class IsbnController {
    private final IsbnService service;

    public IsbnController(IsbnService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<IsbnDTO> cadIsbn(@RequestBody IsbnDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<IsbnLowDTO>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<IsbnDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IsbnDTO> edit(@PathVariable Long id, @RequestBody IsbnDTO dto) {
        return ResponseEntity.ok(service.edit(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(new MessageDTO("ISBN deleted successfully"));
    }
}
