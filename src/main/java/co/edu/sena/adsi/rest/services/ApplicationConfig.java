package co.edu.sena.adsi.rest.services;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;




/**
 *
 * @author adsi1261718
 */
@ApplicationPath("api")
public class ApplicationConfig extends ResourceConfig{
    public ApplicationConfig(){
        packages("co.edu.sena.adsi.rest.services","co.edu.sena.adsi.rest.auth");
        register(RolesAllowedDynamicFeature.class);
    }
    
}