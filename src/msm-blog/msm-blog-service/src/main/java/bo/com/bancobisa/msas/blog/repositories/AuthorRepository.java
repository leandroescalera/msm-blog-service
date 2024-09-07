package bo.com.bancobisa.msas.blog.repositories;

import bo.com.bancobisa.msas.blog.entities.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author leandro.escalera
 */
@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {

  @Query("select a from AuthorEntity a where a.id = :id")
  AuthorEntity findAuthorById(@Param("id") Long id);

  @Query("select a from AuthorEntity a ")
  List<AuthorEntity> findAllAuthor();
}
