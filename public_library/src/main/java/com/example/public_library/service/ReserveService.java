package com.example.public_library.service;

import com.example.public_library.dto.ReserveDTO;
import com.example.public_library.dto.ReserveLowDTO;
import com.example.public_library.dto.UserDTO;
import com.example.public_library.dto.UserLowDTO;
import com.example.public_library.model.Reserve;
import com.example.public_library.model.User;
import com.example.public_library.repository.ReserveRepository;
import com.example.public_library.util.MapperUtil;
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
    public ReserveLowDTO update(ReserveDTO reserveDTO){
        Reserve reserve = repository.findById(reserveDTO.getId()).orElseThrow(()-> new RuntimeException("User Not Found"));
        reserve.setNameBook(reserveDTO.getNameBook());
        reserve.setEmail(reserveDTO.getEmail());
        Reserve updated = repository.save(reserve);
        return MapperUtil.parseObject(updated,ReserveLowDTO.class);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
