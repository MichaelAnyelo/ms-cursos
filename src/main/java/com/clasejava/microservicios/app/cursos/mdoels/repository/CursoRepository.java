package com.clasejava.microservicios.app.cursos.mdoels.repository;

import org.springframework.data.repository.CrudRepository;

import com.clasejava.microservicios.app.cursos.models.entity.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long> {

}
