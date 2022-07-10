package com.myara.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myara.demo.entities.CadastroProfissional;

public interface ProfissionalRepository  extends JpaRepository<CadastroProfissional, Long>{

}
