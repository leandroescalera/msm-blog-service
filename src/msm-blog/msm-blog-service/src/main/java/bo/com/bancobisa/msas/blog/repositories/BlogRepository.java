package bo.com.bancobisa.msas.blog.repositories;

import bo.com.bancobisa.msas.blog.entities.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author leandro.escalera
 */
@Repository
public interface BlogRepository extends JpaRepository<BlogEntity,Long> {

  @Query("select b from BlogEntity b where b.id = :id")
  BlogEntity findBlogById(@Param("id") Long id);

  @Query("select b from BlogEntity b where b.authorId.id = :id ")
  List<BlogEntity> findAllBlogsByAuthorId(@Param("id") Long id);
}
