package com.example.public_library.controller;

import com.example.public_library.dto.IsbnDTO;
import com.example.public_library.service.IsbnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/isbns")
public class IsbnController {

    @Autowired
    private IsbnService service;

    @PostMapping
    public ResponseEntity<IsbnDTO> createIsbn(@RequestBody IsbnDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IsbnDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<IsbnDTO>> findByNumber(@RequestParam String number) {
        return ResponseEntity.ok(service.findByNumber(number));
    }

    @GetMapping
    public ResponseEntity<List<IsbnDTO>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<IsbnDTO> updateIsbn(@PathVariable Long id, @RequestBody IsbnDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIsbn(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
