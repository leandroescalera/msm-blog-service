package bo.com.bancobisa.msas.blog.repositories;

import bo.com.bancobisa.msas.blog.entities.BlogHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author leandro.escalera
 */

@Repository
public interface BlogHistoryRepository extends JpaRepository<BlogHistoryEntity,Long> {
}
