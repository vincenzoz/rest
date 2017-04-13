package org.vinrest.logic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

@Path("/login")
public class loginService {

	@Path("/{userName}/{password}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String checkLogin(@PathParam("userName") String username, @PathParam("password") String password) {
		System.out.println("login: " + username + " - " + password);
		
		
		return "Login successful " + username + " !!";
	}
	
	@Path("/register/{userName}/{password}/{email}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String register(@PathParam("userName") String username, @PathParam("password") String password) {
		System.out.println("login: " + username + " - " + password);
		return "OK PARAM - Ciao " + username + " !!";
	}

	@Path("/register")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public String register(String el) {
		
		System.out.println("json: " + el);
		
		
		
		return "OK";
	}
	
	@Path("/1")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getMsg() {
		System.out.println("/message/1");
		return "No params";
	}


	@Path("/ph")
	@GET
	@Produces("image/png")
	public BufferedImage getImage() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("C:\\Users\\vincenzo\\Desktop\\IMG.JPG"));

		} catch (IOException e) {
		}

		return img;

	}

}
