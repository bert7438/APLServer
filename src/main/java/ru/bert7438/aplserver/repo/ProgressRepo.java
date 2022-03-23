package ru.bert7438.aplserver.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.bert7438.aplserver.models.Progress;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProgressRepo extends JpaRepository<Progress, Integer> {
    List<Progress> findAll();
    Optional<Progress> findById(int id);
}
