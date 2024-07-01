package com.cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n02.Model.Services;

import com.cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n02.Model.DTO.FlorEntityDTO;
import java.util.List;

public interface FlorEntityService {

    FlorEntityDTO save(FlorEntityDTO florEntityDTO);
    FlorEntityDTO update(FlorEntityDTO florEntityDTO);
    String deleteById(int id);
    FlorEntityDTO findById(int id);
    List<FlorEntityDTO> findAll();
}
