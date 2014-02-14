package com.codenvy.gwtginapp.client.user;

import java.util.ArrayList;
import java.util.List;

public class UserCreator {

	private static String[] surname = { "Ivanov", "Petrov", "Vasilev" };
	private static String[] name = { "Ivan", "Petr", "Vasil" };
	private static List<User> listUser;

	public static List<User> createListUser() {

		if (listUser == null) {
			listUser = new ArrayList<User>();
		}
		
		if (listUser.isEmpty()) {
			for (int i = 0; i < surname.length; i++) {
				listUser.add(new User(surname[i], name[i]));
			}
		}
		return listUser;
	}
	
	public static User createUser(String userData){
		String [] newUser = userData.split(" ");
		User user = new User(newUser[0], newUser[1]);
		return user;
	}
	
	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		UserCreator.listUser = listUser;
	}
	
	public static User getUser(String userSurname) {
		User user = null;
		for (int i = 0; i < listUser.size(); i++) {
			if (userSurname.equals(listUser.get(i).getSurname())) {
				user = listUser.get(i);
			}
		}
		return user;
	}

}
