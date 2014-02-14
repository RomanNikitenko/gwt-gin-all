package com.codenvy.gwtginapp.server.service;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;

import com.codenvy.gwtginapp.client.user.User;
import com.codenvy.gwtginapp.client.user.UserCreator;

@Path("users")
public class UserService {

	@Path("/{userSurname}")
	@GET 
	@Produces("application/json")
    public User getUser(@PathParam("userSurname") String userSurname){
        User user = UserCreator.getUser(userSurname);
        return user;
    }
	
}
