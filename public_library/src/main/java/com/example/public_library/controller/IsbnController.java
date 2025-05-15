package com.example.public_library.controller;

import com.example.public_library.dto.IsbnDTO;
import com.example.public_library.dto.MessageDTO;
import com.example.public_library.service.IsbnService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Register a new ISBN", tags = "ISBN")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "ISBN registered successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @PostMapping
    public ResponseEntity<IsbnDTO> createIsbn(@RequestBody IsbnDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }
    @Operation(summary = "Find ISBN by ID", tags = "ISBN")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ISBN found"),
            @ApiResponse(responseCode = "404", description = "ISBN not found",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<IsbnDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @Operation(summary = "Find ISBN(s) by number", tags = "ISBN")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ISBN(s) found"),
            @ApiResponse(responseCode = "404", description = "No ISBNs match the number",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @GetMapping("/buscar")
    public ResponseEntity<List<IsbnDTO>> findByNumber(@RequestParam String number) {
        return ResponseEntity.ok(service.findByNumber(number));
    }
    @Operation(summary = "List all ISBNs", tags = "ISBN")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of ISBNs returned")
    })
    @GetMapping
    public ResponseEntity<List<IsbnDTO>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }
    @Operation(summary = "Update ISBN data", tags = "ISBN")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "ISBN updated successfully"),
            @ApiResponse(responseCode = "404", description = "ISBN not found",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<IsbnDTO> updateIsbn(@PathVariable Long id, @RequestBody IsbnDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }
    @Operation(summary = "Delete ISBN by ID", tags = "ISBN")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "ISBN deleted successfully"),
            @ApiResponse(responseCode = "404", description = "ISBN not found",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIsbn(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
