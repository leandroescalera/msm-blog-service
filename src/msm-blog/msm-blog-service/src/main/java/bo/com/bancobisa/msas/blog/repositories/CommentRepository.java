package bo.com.bancobisa.msas.blog.repositories;

import bo.com.bancobisa.msas.blog.entities.BlogEntity;
import bo.com.bancobisa.msas.blog.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author leandro.escalera
 */
@Repository
public interface CommentRepository  extends JpaRepository<CommentEntity,Long> {
  @Query("select c from CommentEntity c WHERE c.blogId.id = :id ")
  List<CommentEntity> findAllCommentsByBlogId(@Param("id") Long id);

}
