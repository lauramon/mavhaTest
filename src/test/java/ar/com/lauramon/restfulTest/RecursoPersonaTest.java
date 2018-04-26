package ar.com.lauramon.restfulTest;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;

import ar.com.lauramon.administracion.AdministracionPersona;
import ar.com.lauramon.model.Persona;
import ar.com.lauramon.resources.PersonasResource;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

/*
 * clase que futuramente puede ser el test de los recursos REST. FALTA IMPLEMENTAR
 */
public class RecursoPersonaTest extends JerseyTest {


    @Override
    public Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        return new ResourceConfig(PersonasResource.class);
    }
        
    public void obtenerTodosTest() {
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

        Response output = target("/personas").request().get();
        assertEquals("should return status 200", 200, output.getStatus());
        assertNotNull("Should return list", output.getEntity());
    }

}
