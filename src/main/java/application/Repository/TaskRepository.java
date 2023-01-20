package application.Repository;

import application.Domain.Entities.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends CrudRepository<Task, UUID> {
    Task save(Task task);
    void deleteById(final UUID id);
    Task getById(final UUID id);
    Iterable<Task> findAll();
}

