package app.test.spring.demo.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.test.spring.demo.model.Gestor;
import app.test.spring.demo.service.GestorService;

// indica que controla las conexiones de API REST
@RestController
// indicamos la ruta de nuestra API de Gestor.
// se accederá en host:puerto/gestor
@RequestMapping("/gestor")
public class GestorController {

	@Autowired
	GestorService gestorService;

	// indica que recibirá una petición GET en "/gestor"
	@GetMapping()
	public ArrayList<Gestor> obtenerGestores() {
		return this.gestorService.leerGestores();
	}

	// indica que recibirá una petición GET en "/gestor/{id}"
	// donde {id} es una variable que contiene el id de gestor
	@GetMapping(path = "/{id}")
	public Optional<Gestor> obtenerGestor(@PathVariable("id") Long id) {
		return this.gestorService.leerGestor(id);
	}

	// indica que recibirá una petición POST en "/gestor"
	// recibirá el gestor en el body de la petición (@RequestBody)
	@PostMapping()
	public Gestor guardarGestor(@RequestBody Gestor gestor) {
		return this.gestorService.guardarGestor(gestor);
	}

	// indica que recibirá una petición DELETE en "/gestor/{id}"
	// donde {id} es una variable que contiene el id de gestor
	@DeleteMapping(path = "/{id}")
	public boolean borrarGestor(@PathVariable("id") Long id) {
		return this.gestorService.borrarGestor(id);
	}

	// buscar por correo
	@GetMapping(path = "/correo/{correo}")
	public Optional<Gestor> obtenerConCorreo(@PathVariable("correo") String correo) {
		return this.gestorService.obtenerConCorreo(correo);
	}

	// buscar por login
	@GetMapping(path = "/login")
	public Optional<Gestor> obtenerPorLogin(@RequestParam("correo") String correo, @RequestParam("pass") String pass) {
		return this.gestorService.obtenerPorLogin(correo, pass);
	}

}
