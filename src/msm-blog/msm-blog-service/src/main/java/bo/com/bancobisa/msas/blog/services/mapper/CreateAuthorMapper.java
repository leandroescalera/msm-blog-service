package bo.com.bancobisa.msas.blog.services.mapper;

import bo.com.bancobisa.msas.blog.entities.AuthorEntity;
import bo.com.bancobisa.msm.blog.api.CreateAuthorRequest;
import org.springframework.beans.BeanUtils;

/**
 * @author leandro.escalera
 */
public final class CreateAuthorMapper {

  public static AuthorEntity mapperToAuthorEntity(CreateAuthorRequest from) {
    AuthorEntity to = new AuthorEntity();
    BeanUtils.copyProperties(from, to);
    return to;
  }
}
