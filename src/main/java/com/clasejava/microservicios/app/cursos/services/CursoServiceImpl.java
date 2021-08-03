package com.clasejava.microservicios.app.cursos.services;

import org.springframework.stereotype.Service;

import com.clasejava.microservicios.app.commons.service.CommonServiceImpl;
import com.clasejava.microservicios.app.cursos.mdoels.repository.CursoRepository;
import com.clasejava.microservicios.app.cursos.models.entity.Curso;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CursoService {



}
