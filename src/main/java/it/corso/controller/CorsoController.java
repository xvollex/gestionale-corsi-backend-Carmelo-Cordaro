package it.corso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.corso.dto.AddCourdeDTO;
import it.corso.dto.CorsoDTO;
import it.corso.jwt.JWTTokenNeeded;
import it.corso.jwt.Secured;
import it.corso.service.CorsoService;
//import jakarta.validation.constraints.Pattern; //non questo ma import java.util.regex.Pattern; o non funziona il matches
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/corso")
public class CorsoController 
{
	@Autowired
	private CorsoService corsoService;

	@GET
	@Path("/corsi")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCourses() 
	{
		try 
		{
			List<CorsoDTO> listaCorsi = corsoService.getCourses();
			
			return Response.status(Response.Status.OK).entity(listaCorsi).build();
		} 
		catch (Exception e) 
		{
			return Response.status(Response.Status.BAD_REQUEST).entity("Errore caricamento utenti").build();
		}
	}
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCourse(AddCourdeDTO course) 
	{
		try 
		{
			corsoService.addCourse(course);
			
			return Response.status(Response.Status.OK).build();
		} 
		catch (Exception e) 
		{
			return Response.status(Response.Status.BAD_REQUEST).entity("Errore caricamento utenti").build();
		}
	}
	
	@DELETE
	@Path("/delete/{id}")
	public Response deleteCourse(@PathParam("id") int id) 
	{
		try 
		{
			corsoService.deleteCourseById(id);
			
			return Response.status(Response.Status.OK).build();
		} 
		catch (Exception e) 
		{
			return Response.status(Response.Status.BAD_REQUEST).entity("Errore caricamento utenti").build();
		}
	}

}
