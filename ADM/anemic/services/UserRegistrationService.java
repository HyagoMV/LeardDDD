package anemic.services;
import anemic.exceptions.UserAlreadyExistsException;
import anemic.exceptions.UserNameTooLongException;
import anemic.exceptions.WrongEmailDomainException;
import anemic.model.User;
import anemic.repository.UserRepository;

/*
  Serviço responsável pelo cadastro do usuário. 
  De acordo com os requisitos acima, precisamos validar o comprimento do nome de usuário e o endereço de e-mail.
*/
public class UserRegistrationService {

    private static final String MAIL_DOMAIN = "gmail.com";

    private final UserRepository userRepository;

    public UserRegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(User user) {
        if (userRepository.getById(user.getUserId()).isPresent()) {
            throw new UserAlreadyExistsException();
        }

        validateUserEmailDomain(user.getEmail());
        validateUserName(user.getName());
        user.setActive(false);
        user.setBlocked(false);
        userRepository.save(user);
    }

    private void validateUserEmailDomain(String email) {
        if (!email.endsWith(MAIL_DOMAIN)) {
            throw new WrongEmailDomainException(email);
        }
    }

    private void validateUserName(String name) {
        if (name.length() > 100) {
            throw new UserNameTooLongException(name);
        }
    }
}