package ar.com.lauramon.entidadesTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
 
import ar.com.lauramon.model.Persona;
import ar.com.lauramon.administracion.AdministracionPersona;

/*
 * clase usada para testear el funcionamiento de los servicios hibernate
 */
public class PersonaTest {

	@Test
	public void agregarPersona() { 

		Persona persona = new Persona();
		persona.setDni(new Long(25185949));
		persona.setNombre("Laura");
		persona.setApellido("Mon");
		persona.setEdad(new Integer(41));

		AdministracionPersona.guardar(persona);

		assertEquals("Mon", AdministracionPersona.obtener(new Long(25185949)).getApellido());
	}
	
	@Test
	public void obtenerPersonas() {
        Persona persona = new Persona();
        persona.setDni(new Long(25185949));
        persona.setNombre("Laura");
        persona.setApellido("Mon");
        persona.setEdad(new Integer(41));
        AdministracionPersona.guardar(persona);
 
        Persona persona2 = new Persona();
        persona2.setDni(new Long(25185555));
        persona2.setNombre("Lorena");
        persona2.setApellido("Perez");
        persona2.setEdad(new Integer(35));
        AdministracionPersona.guardar(persona2);
        
        Persona persona3 = new Persona();
        persona3.setDni(new Long(25666949));
        persona3.setNombre("Rogerio");
        persona3.setApellido("Olivera");
        persona3.setEdad(new Integer(42));
        AdministracionPersona.guardar(persona3);
        
        List<Persona> personas = AdministracionPersona.obtenerTodos();
        
        assertEquals(3, personas.size());
	    
	    
	}
}
