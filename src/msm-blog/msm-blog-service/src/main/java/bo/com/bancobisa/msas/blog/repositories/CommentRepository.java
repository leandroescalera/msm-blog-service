package bo.com.bancobisa.msas.blog.repositories;

import bo.com.bancobisa.msas.blog.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author leandro.escalera
 */
@Repository
public interface CommentRepository  extends JpaRepository<CommentEntity,Long> {
}
