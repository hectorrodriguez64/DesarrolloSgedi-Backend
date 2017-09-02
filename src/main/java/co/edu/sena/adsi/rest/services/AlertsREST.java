/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Alerts;
import co.edu.sena.adsi.jpa.sessions.AlertsFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adsi1261718
 */
@Path("alerts")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AlertsREST {
     @EJB
    private AlertsFacade alertsEJB;
    
    @GET
    public List<Alerts> findAll(){
        return alertsEJB.findAll();
    }
    @GET
    @Path("{id}")
    public Alerts findBye(
    @PathParam("nombre")String nombre){
        return alertsEJB.find(nombre);
    
}
    @POST
    public void create(Alerts alerts){
        alertsEJB.create(alerts);
    }
}
