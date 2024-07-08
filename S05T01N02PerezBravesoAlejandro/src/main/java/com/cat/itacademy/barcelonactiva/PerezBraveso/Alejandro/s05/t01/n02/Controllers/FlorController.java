package com.cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n02.Controllers;


import com.cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n02.Model.DTO.FlorEntityDTO;
import com.cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n02.Model.Services.FlorEntityService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind .annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flor")
public class FlorController {
    @Autowired
    FlorEntityService service;
    @PostMapping("/add")
    public ResponseEntity<FlorEntityDTO> addFlor (@RequestBody FlorEntityDTO florEntityDTO){
        FlorEntityDTO florEntityDTO1 =service.save(florEntityDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(florEntityDTO1);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<FlorEntityDTO> updateFlor(@RequestBody FlorEntityDTO florEntityDTO){
        try{
            FlorEntityDTO florEntityDTO1 = service.update(florEntityDTO);
            return ResponseEntity.ok(florEntityDTO1);
        }catch(EntityNotFoundException x){
            x.getMessage();
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFlor(@PathVariable int id){
        try {
            String mensaje = service.deleteById(id);
            return ResponseEntity.ok(mensaje);
        } catch (EntityNotFoundException enfe){
            enfe.getMessage();
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<FlorEntityDTO> getOneFlor(@PathVariable int id){
        try{
            FlorEntityDTO florEntityDTO = service.findById(id);
            return ResponseEntity.ok(florEntityDTO);
        }catch (EntityNotFoundException x){
            x.getMessage();
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<FlorEntityDTO>> getAllFlor(){
        List<FlorEntityDTO> flores = service.findAll();
        if (flores.isEmpty()){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(flores);
        }
    }
}
