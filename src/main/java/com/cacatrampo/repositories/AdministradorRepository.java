package com.cacatrampo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cacatrampo.entities.AdministradorEntity;

public interface AdministradorRepository extends JpaRepository<AdministradorEntity, Long> {

}
