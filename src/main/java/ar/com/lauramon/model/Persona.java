package ar.com.lauramon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name="PERSONA")
@XmlRootElement
public class Persona {
    
	@Id
	@Column(name = "DNI")
	Long dni;

	@Column(name = "NOMBRE", length = 50)
	String nombre;

	@Column(name = "APELLIDO", length = 50)
	String apellido;

	@Column(name = "EDAD")
	Integer edad;

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Persona(Long dni) {
        super();
        this.dni = dni;
    }

    public Persona() {
        super();
    }

    
}