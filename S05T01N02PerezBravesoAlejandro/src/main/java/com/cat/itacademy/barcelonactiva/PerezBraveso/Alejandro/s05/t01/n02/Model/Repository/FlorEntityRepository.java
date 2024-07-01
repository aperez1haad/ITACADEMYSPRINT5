package com.cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n02.Model.Repository;

import com.cat.itacademy.barcelonactiva.PerezBraveso.Alejandro.s05.t01.n02.Model.Domain.FlorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlorEntityRepository extends JpaRepository<FlorEntity,Integer> {
}
