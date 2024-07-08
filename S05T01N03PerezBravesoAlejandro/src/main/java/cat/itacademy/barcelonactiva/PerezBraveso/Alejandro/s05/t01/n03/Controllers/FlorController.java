package cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n03.Controllers;

import cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n03.Model.DTO.FlorEntityDTO;
import cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n03.Model.Services.FlorEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flor")

public class FlorController {
    @Autowired
    FlorEntityService service;

    @PostMapping("/clientFlorsAdd")
    public ResponseEntity<FlorEntityDTO> addFlor (@RequestBody FlorEntityDTO florDTO){
        FlorEntityDTO florEntityDTO;

        try {
            florEntityDTO = service.save(florDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(florEntityDTO);
        } catch (RuntimeException rte) {
            System.out.println(rte.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/clientFlorsUpdate/{id}")
    public ResponseEntity<FlorEntityDTO> updateFlor (@RequestBody FlorEntityDTO florDTO){
        FlorEntityDTO florEntityDTO;

        try {
            florEntityDTO = service.update(florDTO);
            return ResponseEntity.ok(florEntityDTO);
        } catch (RuntimeException rte) {
            System.out.println(rte.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/clientFlorsDelete/{id}")
    public ResponseEntity<String> deleteFlor (@PathVariable int id){
        String mensaje;

        try {
            mensaje = service.deleteById(id);
            return ResponseEntity.ok(mensaje);
        } catch (RuntimeException rte) {
            System.out.println(rte.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/clientFlorsGetOne/{id}")
    public ResponseEntity<FlorEntityDTO> getOneFlor(@PathVariable int id){
        FlorEntityDTO florEntityDTO;

        try {
            florEntityDTO = service.findById(id);
            return ResponseEntity.ok(florEntityDTO);
        } catch (RuntimeException rte) {
            System.out.println(rte.getMessage());
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/clientFlorsAll")
    public ResponseEntity<List<FlorEntityDTO>> getAllFlor(){
        List<FlorEntityDTO> flores;

        try {
            flores = service.findAll();
            return ResponseEntity.ok(flores);
        } catch (RuntimeException rte) {
            System.out.println(rte.getMessage());
            return ResponseEntity.notFound().build();
        }
    }
}

