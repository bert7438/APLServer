package ru.bert7438.aplserver.repo;

import org.springframework.stereotype.Repository;
import ru.bert7438.aplserver.models.Progress;

import java.util.Optional;

@Repository
public interface ProgressRepo {
    Iterable<Progress> findAll();
    Optional<Progress> findById(int id);
}
