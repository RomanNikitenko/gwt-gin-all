package com.codenvy.gwtginapp.server.service;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;


public class UserApp extends Application{
	@Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> cls = new HashSet<Class<?>>(1);
        cls.add(UserService.class);
        return cls;
    }
}
