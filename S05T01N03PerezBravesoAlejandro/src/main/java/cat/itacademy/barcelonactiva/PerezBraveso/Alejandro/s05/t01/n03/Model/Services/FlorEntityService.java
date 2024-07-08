package cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n03.Model.Services;

import cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n03.Model.DTO.FlorEntityDTO;

import java.util.List;

public interface FlorEntityService {
    FlorEntityDTO save(FlorEntityDTO florEntityDTO);
    FlorEntityDTO update(int id, FlorEntityDTO florEntityDTO);
    String deleteById(int id);
    FlorEntityDTO findById(int id);
    List<FlorEntityDTO> findAll();
}
