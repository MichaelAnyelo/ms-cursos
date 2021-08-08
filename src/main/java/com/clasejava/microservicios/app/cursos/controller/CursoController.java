package com.clasejava.microservicios.app.cursos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clasejava.microservicios.app.commons.alumnos.models.entity.Alumno;
import com.clasejava.microservicios.app.commons.controller.CommonController;
import com.clasejava.microservicios.app.cursos.models.entity.Curso;
import com.clasejava.microservicios.app.cursos.services.CursoService;

@RestController
public class CursoController extends CommonController<Curso, CursoService> {

	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id) {

		Optional<Curso> o = this.service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();

		}
		Curso dbCurso = o.get();
		dbCurso.setNombre(curso.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));

	}

	@PutMapping("/{id}/asignar-alumnos")
	public ResponseEntity<?> asignarAlumnos(@RequestBody List<Alumno> alumnos, @PathVariable Long id) {
		Optional<Curso> o = this.service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();

		}
		Curso dbCurso = o.get();

		alumnos.forEach(a -> {
			dbCurso.addAlumno(a);
		});

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable Long id) {
		Optional<Curso> o = this.service.findById(id);
		if (o.isEmpty()) {
			return ResponseEntity.notFound().build();

		}
		Curso dbCurso = o.get();

		dbCurso.removeAlumno(alumno);

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(dbCurso));
	}
	
	@GetMapping("/alumno/{id}")
	public ResponseEntity<?> buscarPorAlumno(@PathVariable(name = "id") Long id) {
		Curso curso = service.findCrusoByAlumnoId(id);

		return ResponseEntity.ok(curso);
	}
	
	

}
