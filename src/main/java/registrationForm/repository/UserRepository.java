package registrationForm.repository;

import registrationForm.exception.UserNotFoundException;
import registrationForm.model.User;

public interface UserRepository {


	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public User getUserById(String UserId);
	public boolean validateUser(String userName, String password) throws UserNotFoundException;
	public boolean deleteUser(String UserId);

}