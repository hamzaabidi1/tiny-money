package tn.esprit.spring.Services.Interfaces;

import java.util.List;


import tn.esprit.spring.entities.User;

public interface UserServices {
	List<User> retrieveAllUsers();
	public User addUser(User user);
	public void deleteUser(Long id);
	public User updateUser(User user);
	public User  retrieveUser(Long id); 

}
