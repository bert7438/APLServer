package ru.bert7438.aplserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bert7438.aplserver.models.Users;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    List<Users> findAll();
    Users save(Users user);
}
