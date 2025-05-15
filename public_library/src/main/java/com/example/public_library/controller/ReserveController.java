package com.example.public_library.controller;

import com.example.public_library.dto.*;
import com.example.public_library.model.Reserve;
import com.example.public_library.service.ReserveService;
import com.example.public_library.service.SendMailService;
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
@RequestMapping("/api/reservar")
public class ReserveController {
    @Autowired
    private ReserveService service;
    @Autowired
    private SendMailService sendMail;

    @Operation(summary = "Make a Reserve", tags = "Reserve")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Reserve registered successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @PostMapping
    public ResponseEntity<Reserve> makeReserve(@RequestBody ReserveDTO reserveDTO){
        Reserve reserve = new Reserve();
        reserve.setEmail(reserveDTO.getEmail());
        reserve.setNameBook(reserveDTO.getNameBook());
        reserve.setReserveDate(reserveDTO.getReserveDate());
        reserve.setStatus(reserveDTO.getStatus());

        Reserve newreserve = service.save(reserve);

        new Thread(()->{
            try{
                Thread.sleep(3000);
                sendMail.sendReserve(reserve.getEmail(), reserve.getNameBook());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }).start();

        return ResponseEntity.status(HttpStatus.CREATED).body(newreserve);
    }
    @Operation(summary = "Find Reserve by ID", tags = "Reserve")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reserve found"),
            @ApiResponse(responseCode = "404", description = "Reserve not found",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Reserve> findById(@PathVariable Long id){
        Reserve reserve = service.findById(id);
        if (reserve != null){
            return ResponseEntity.ok(reserve);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "Find Reserves by name's Book", tags = "Reserve")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reserve Book found"),
            @ApiResponse(responseCode = "404", description = "No Reserve match the name",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @GetMapping("/buscar-livro")
    public ResponseEntity <Reserve> findByBook(@RequestParam String nameBook){
        Reserve reserve = service.findByNameBook(nameBook);
        if (reserve != null){
            return ResponseEntity.ok(reserve);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @Operation(summary = "List all Reserves", tags = "Reserve")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "List of Reserves returned")
    })
    @GetMapping
    public List<Reserve> listAll(){
        return service.listAll();
    }
    @Operation(summary = "Update Reserve data", tags = "Reserve")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reserve updated successfully"),
            @ApiResponse(responseCode = "404", description = "Reserve not found",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @PutMapping("/{id}")
    public ReserveLowDTO update(@RequestBody ReserveDTO reserve){
        return service.update(reserve);
    }
    @Operation(summary = "Delete Reserve by ID", tags = "Reserve")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Reserve deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Reserve not found",
                    content = @Content(schema = @Schema(implementation = MessageDTO.class)))
    })
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}

