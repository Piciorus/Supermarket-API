package application.Repository;

import application.Domain.Entities.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    Task save(Task task);
    void deleteById(final Long id);
    Task getById(final Long id);
    Iterable<Task> findAll();
}

