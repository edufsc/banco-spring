package app.test.spring.demo.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.test.spring.demo.model.Gestor;

// indicamos que es un repositorio
// funcionalidades asociadas a base de datos de una @Entity o modelo
// es una interfaz y extiende a CrusRepository, que nos da los métodos.
// Spring se encarga de implementar los métodos para Gestor,
// usando un Long para la clave primaria (el tipo del id de Gestor)
@Repository
public interface GestorRepository extends CrudRepository<Gestor, Long> {

	public Optional<Gestor> findByEmail(String email);

	public Optional<Gestor> findOneByEmailAndPassword(String email, String password);

}
