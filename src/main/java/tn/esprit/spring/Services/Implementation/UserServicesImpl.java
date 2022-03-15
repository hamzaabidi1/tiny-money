package tn.esprit.spring.Services.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Services.Interfaces.UserServices;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Repository.UserRepository;


	@Service
	public class UserServicesImpl implements UserServices {
		@Autowired
		UserRepository userrep;

		@Override
		public List<User> retrieveAllUsers() {
			List<User> users=(List<User>) (userrep.findAll());
		
			return users;
		}

		@Override
		public User addUser(User user) {
			userrep.save(user);
			return user;
	
			
		}

		@Override
		public void deleteUser(Long id) {
			userrep.deleteById(id);
	
			
		}

		@Override
		public User updateUser(User user) {
	
			userrep.save(user);
			return user;
		}

		@Override
		public User retrieveUser(Long id) {
			
	
			return userrep.findById(id).get();
		}

}
