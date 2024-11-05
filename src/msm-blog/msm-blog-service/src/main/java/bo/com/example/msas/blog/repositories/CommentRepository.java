package bo.com.example.msas.blog.repositories;

import bo.com.example.msas.blog.entities.CommentEntity;
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

  @Query("SELECT MAX(c.score) FROM CommentEntity c WHERE c.blogId.id = :blogId")
  Double findMaxScoreByBlogId(@Param("blogId") Long blogId);

  @Query("SELECT MIN(c.score) FROM CommentEntity c WHERE c.blogId.id = :blogId")
  Double findMinScoreByBlogId(@Param("blogId") Long blogId);

  @Query("SELECT AVG(c.score) FROM CommentEntity c WHERE c.blogId.id = :blogId")
  Double findAvgScoreByBlogId(@Param("blogId") Long blogId);


}
