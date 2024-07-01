package com.cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n02.Model.Services;
import com.cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n02.Model.Domain.FlorEntity;
import com.cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n02.Model.DTO.FlorEntityDTO;
import com.cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n02.Model.Repository.FlorEntityRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlorEntityServiceImpl implements FlorEntityService{
    @Autowired
    FlorEntityRepository repository;

    private FlorEntityDTO toDTO(FlorEntity florEntity){
        return new FlorEntityDTO(florEntity.getPk_FlorID(), florEntity.getNomFlor(), florEntity.getPaisflor());
    }
    private FlorEntity toEntity(FlorEntityDTO florEntityDTO){
        FlorEntity florEntity = new FlorEntity();
        florEntity.setPk_FlorID(florEntityDTO.getPk_FlorID());
        florEntity.setNomFlor(florEntityDTO.getNomFlor());
        florEntity.setPaisflor(florEntityDTO.getPaisFlor());
        return florEntity;
    }

    @Override
    public FlorEntityDTO save(FlorEntityDTO florEntityDTO){
        FlorEntity florEntity = toEntity(florEntityDTO);
        repository.save(florEntity);
        return florEntityDTO;
    }

    @Override
    public FlorEntityDTO update(FlorEntityDTO florEntityDTO){
        Optional<FlorEntity> optionalFlorEntity = repository.findById(florEntityDTO.getPk_FlorID());
        if (optionalFlorEntity.isPresent()) {
            FlorEntity florEntity = toEntity(florEntityDTO);
            florEntity = repository.save(florEntity);
            return toDTO(florEntity);
        } else {
            throw new RuntimeException("Flor no encontrada con ID: " + florEntityDTO.getPk_FlorID());
        }
    }

    @Override
    public String deleteById(int id) {
        Optional<FlorEntity> optionalFlorEntity = repository.findById(id);
        if (optionalFlorEntity.isPresent()) {
            repository.deleteById(id);
            return "Se ha eliminado la flor correctamente";
        }else{
            throw new EntityNotFoundException("No se ha encontrado la flor a eliminar");
        }
    }

    @Override
    public FlorEntityDTO findById(int id) {
        Optional<FlorEntity> optionalFlorEntity = repository.findById(id);
        if(optionalFlorEntity.isEmpty()){
            throw new EntityNotFoundException("No se ha encontrado la flor");
        }else{
            FlorEntity florEntity =optionalFlorEntity.get();
            return toDTO(florEntity);
        }
    }

    @Override
    public List<FlorEntityDTO> findAll() {
        List<FlorEntity> florEntities = repository.findAll();
        return florEntities.stream().map(this::toDTO).collect(Collectors.toList());
    }



}
