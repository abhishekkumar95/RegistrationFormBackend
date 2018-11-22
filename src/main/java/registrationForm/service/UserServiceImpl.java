package registrationForm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import registrationForm.exception.UserAlreadyExistException;
import registrationForm.exception.UserNotFoundException;
import registrationForm.model.User;
import registrationForm.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService {



	/*

	 * Autowiring should be implemented for the userDAO. (Use Constructor-based

	 * autowiring) Please note that we should not create any object using the new

	 * keyword.

	 */

	@Autowired

	private UserRepository userRepository;

	

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	public boolean registerUser(User user) throws UserAlreadyExistException {
		if(userRepository.registerUser(user)) 
			return true;
		else 
			throw new UserAlreadyExistException("UserAlreadyExistException");

	}

	public User updateUser(User user, String userId) throws Exception {

		userRepository.updateUser(user);

		User newUser = getUserById(userId);

		if(newUser==null)

			throw new Exception();

		else 

			return user;

}


	public User getUserById(String UserId) throws UserNotFoundException {
		User user = userRepository.getUserById(UserId);
		if(user==null)
			throw new UserNotFoundException("UserNotFoundException");
		else
			return user;
		}

	
	
	
	public boolean validateUser(String userId, String password) throws UserNotFoundException {
		
		boolean validUser = userRepository.validateUser(userId, password);
		if(!validUser)
			throw new UserNotFoundException("UserNotFoundException");
		else 
			return true;
	}

	public boolean deleteUser(String UserId) {

		boolean deleteUser = userRepository.deleteUser(UserId);

			if(!deleteUser) {

				return false;

			}else {

				return true;

			}		



	}
	}