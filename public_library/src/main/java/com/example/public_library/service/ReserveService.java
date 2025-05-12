package com.example.public_library.service;

import com.example.public_library.model.Reserve;
import com.example.public_library.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveService {
    @Autowired
    private ReserveRepository repository;

    public Reserve save(Reserve reserve){
        return repository.save(reserve);
    }
    public Reserve findById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public Reserve findByNameBook(String nameBook) {
        return repository.findByNameBook(nameBook).orElse(null);
    }
    public List<Reserve> listAll(){
        return repository.findAll();
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
