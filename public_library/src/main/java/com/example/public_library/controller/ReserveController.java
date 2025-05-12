package com.example.public_library.controller;

import com.example.public_library.dto.ReserveDTO;
import com.example.public_library.dto.UserDTO;
import com.example.public_library.dto.UserLowDTO;
import com.example.public_library.model.Reserve;
import com.example.public_library.service.ReserveService;
import com.example.public_library.service.SendMailService;
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

    @GetMapping("/{id}")
    public ResponseEntity<Reserve> findById(@PathVariable Long id){
        Reserve reserve = service.findById(id);
        if (reserve != null){
            return ResponseEntity.ok(reserve);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/test-email-password")
    public ResponseEntity<String> testEmailPassword() {
        String password = System.getenv("EMAIL_PASSWORD");
        return ResponseEntity.ok("EMAIL_PASSWORD: " + (password != null ? "Carregada com sucesso" : "Não encontrada"));
    }

    @GetMapping("/buscar-livro")
    public ResponseEntity <Reserve> findByBook(@RequestParam String nameBook){
        Reserve reserve = service.findByNameBook(nameBook);
        if (reserve != null){
            return ResponseEntity.ok(reserve);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public List<Reserve> listAll(){
        return service.listAll();
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        service.deleteById(id);
    }
}

