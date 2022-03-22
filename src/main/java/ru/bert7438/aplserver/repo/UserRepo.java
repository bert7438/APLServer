package ru.bert7438.aplserver.repo;

import org.springframework.stereotype.Repository;
import ru.bert7438.aplserver.models.Users;

@Repository
public interface UserRepo {
    Iterable<Users> findAll();
    Users save(Users user);
}
