package application.Repository;

import application.Domain.Entities.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends CrudRepository<Task, UUID> {
    @Async
    Task save(Task task);

    @Async
    void deleteById(final UUID id);

    @Async
    Task getById(final UUID id);

    @Async
    Iterable<Task> findAll();
}

