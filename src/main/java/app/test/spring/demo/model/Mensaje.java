package app.test.spring.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "mensaje")
public class Mensaje {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "origen_id", nullable = false)
	private Gestor origen;

	@ManyToOne
	@JoinColumn(name = "destino_id", nullable = false)
	private Gestor destino;

	@CreationTimestamp
	private Date fecha;

	private String texto;

	public Mensaje() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Gestor getOrigen() {
		return origen;
	}

	public void setOrigen(Gestor origen) {
		this.origen = origen;
	}

	public Gestor getDestino() {
		return destino;
	}

	public void setDestino(Gestor destino) {
		this.destino = destino;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
