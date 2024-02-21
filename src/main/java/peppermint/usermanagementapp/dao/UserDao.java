package peppermint.usermanagementapp.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import peppermint.usermanagementapp.entities.User;

import java.util.Optional;

public interface UserDao extends MongoRepository<User, Long> {
    Optional<User> findById(String id);
}
