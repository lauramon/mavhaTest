package ar.com.lauramon.app;

import org.glassfish.jersey.server.ResourceConfig;

public class PersonasApplication extends ResourceConfig {
    public PersonasApplication() {
        // Define el package donde estan todos los recursos REST
        packages("ar.com.lauramon.resources");
    }
}