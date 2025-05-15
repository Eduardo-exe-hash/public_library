package com.example.public_library.controller;

import com.example.public_library.dto.MessageDTO;
import com.example.public_library.dto.PublisherDTO;
import com.example.public_library.service.PublisherService;
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
@RequestMapping("/api/publishers")
public class PublisherController {

    @Autowired
    private PublisherService service;

    @Operation(summary = "Register a new Publisher", tags = "Publisher")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Publisher registered successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @PostMapping
    public ResponseEntity<PublisherDTO> createPublisher(@RequestBody PublisherDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }
    @Operation(summary = "Find Publisher by ID", tags = "Publisher")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Publisher found"),
            @ApiResponse(responseCode = "404", description = "Publisher not found",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<PublisherDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
    @Operation(summary = "Find Publisher(s) by name", tags = "Publisher")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Publisher(s) found"),
            @ApiResponse(responseCode = "404", description = "No Publishers match the number",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @GetMapping("/buscar")
    public ResponseEntity<List<PublisherDTO>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(service.findByName(name));
    }
    @Operation(summary = "List all Publishers", tags = "Publisher")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of Publishers returned")
    })
    @GetMapping
    public ResponseEntity<List<PublisherDTO>> listAll() {
        return ResponseEntity.ok(service.listAll());
    }

    @Operation(summary = "Update Publisher data", tags = "Publisher")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Publisher updated successfully"),
            @ApiResponse(responseCode = "404", description = "Publisher not found",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @PutMapping("/{id}")
    public ResponseEntity<PublisherDTO> updatePublisher(@PathVariable Long id, @RequestBody PublisherDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Operation(summary = "Delete Publisher by ID", tags = "Publisher")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Publisher deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Publisher not found",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
