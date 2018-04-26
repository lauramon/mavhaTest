package ar.com.lauramon.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ar.com.lauramon.administracion.AdministracionPersona;
import ar.com.lauramon.model.Persona;

import javax.ws.rs.Path;

/*
 * Recurso persona, donde estan implementados todos los servicios para el recurso 
 * persona 
 *
 */
@Path("/personas")
public class PersonasResource {

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Persona> obtenerTodos() {
		    return (AdministracionPersona.obtenerTodos());
		} 
		
		@POST
		@Consumes(MediaType.TEXT_PLAIN)
		@Produces(MediaType.APPLICATION_JSON)
		public Persona crearPersona(String id_persona) {
		    AdministracionPersona.guardar(new Persona(new Long(id_persona)));
		    Persona persona = AdministracionPersona.obtener(new Long(id_persona));
		    
		    return persona;
		}
		
}