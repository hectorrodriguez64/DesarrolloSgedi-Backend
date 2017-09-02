/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.EmailApp;
import co.edu.sena.adsi.jpa.entities.Users;
import static co.edu.sena.adsi.jpa.entities.Users_.password;
import co.edu.sena.adsi.jpa.sessions.EmailAppFacade;
import co.edu.sena.adsi.jpa.sessions.UsersFacade;
import co.edu.sena.adsi.rest.auth.DigestUtil;
import co.edu.sena.adsi.rest.util.SendEmail;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author adsi1261718
 */
@Path("users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsersREST {
    @EJB
    private UsersFacade usersEJB;
     @EJB
    private EmailAppFacade emailEJB;


    @GET
    //@RolesAllowed({"ADMIN"})
    

    
    
    public List<Users> findAll(@QueryParam("idUsers") Integer idUsers,
            @QueryParam("sex") String sex,
            @QueryParam("activo") Boolean activo,
            @QueryParam("numDocument") String numDocument,
            @QueryParam("email") String email,
            @QueryParam("idCities") Integer idCities,
            @QueryParam("idDepartament") Integer idDepartament,
            @QueryParam("idDocumentType") Integer idDocumentType) {
        return usersEJB.findUsers(idUsers, sex, activo, numDocument,
                email, idCities, idDepartament, idDocumentType);
    }

    @GET
    @Path("{id}")
    public Users findBye(
            @PathParam("id") Integer name) {
        return usersEJB.find(name);
    }

    @POST
    public Response create(Users users) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String pass = users.getPassword();

        try {

            if (usersEJB.findUsersByEmail(users.getEmail()) == null) {
                if (usersEJB.findUsersByNumDocument(users.getNumDocument()) == null) {
                    users.setPassword(DigestUtil.cifrarPassword(users.getPassword()));
                    usersEJB.create(users);
                       try {

                        //Uso configuración de email para Registro
                        EmailApp emailApp = emailEJB.findConfigEmail("REGISTRO");
                        if (emailApp == null) {
                            emailApp = emailEJB.findConfigEmail("GENERAL");
                        }
                        //Envio de email
                        SendEmail enviarEmailUser = new SendEmail();
                        enviarEmailUser.sendEmailRegistroUsuario(emailApp, users, pass);
                        
                    } catch (Exception e) {
                        System.out.println("ERROR ENVIO DE EMAIL: " + e);
                        return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("No fue posible el envio del email")).build();
                    }
                    return Response.status(Response.Status.CREATED)
                            .entity(gson.toJson("El usuario se registro correctamente"))
                            .build();
                } else {
                    return Response.status(Response.Status.BAD_REQUEST)
                            .entity(gson.toJson("El numero de documento ya existe"))
                            .build();
                }
            } else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity(gson.toJson("El Email ya exite ya existe"))
                        .build();
            }
        } catch (Exception e) {
            System.out.println("Err" + e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al registrar el usuario"))
                    .build();
        }

    }

    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Integer id, Users users) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            usersEJB.edit(users);
            return Response.status(Response.Status.CREATED)
                    .entity(gson.toJson("El usuario se Actualizo correctamente"))
                    .build();
        } catch (Exception e) {
            System.out.println("Err" + e);
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(gson.toJson("Error al Actualizar el usuario"))
                    .build();
        }
    }
}
