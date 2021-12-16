package anemic.repository;
import java.util.Optional;
import java.util.UUID;

import anemic.model.User;

public interface UserRepository {

    Optional<User> getById(UUID userId);

    void save(User user);
    
}
