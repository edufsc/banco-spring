package app.test.spring.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.test.spring.demo.model.Gestor;
import app.test.spring.demo.repository.GestorRepository;

// indicamos que es un servicio, aquí va la lógica, las operaciones
@Service
public class GestorService {

	// @Autowired gestiona las dependencias para que podamos usar los métodos
	// directamente
	@Autowired
	GestorRepository gestorRepository;

	// obtener todos los gestores
	public ArrayList<Gestor> leerGestores() {
		return (ArrayList<Gestor>) this.gestorRepository.findAll();
	}

	// obtener un gestor por id o null si no existe (Optional)
	public Optional<Gestor> leerGestor(Long id) {
		return this.gestorRepository.findById(id);
	}

	// guarda (crea y actualiza) un gestor y lo devuelve con id
	public Gestor guardarGestor(Gestor gestor) {
		return this.gestorRepository.save(gestor);
	}

	// intenta borrar un gestor por id, si lo consigue devuelve true, si no, false
	public boolean borrarGestor(Long id) {
		try {
			this.gestorRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
