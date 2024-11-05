package bo.com.example.msas.blog.services.mapper;

import bo.com.example.msas.blog.entities.AuthorEntity;
import bo.com.example.msm.blog.api.CreateAuthorRequest;
import bo.com.example.msm.blog.api.CreateAuthorResponse;
import org.springframework.beans.BeanUtils;

import java.sql.Date;

/**
 * @author leandro.escalera
 */
public final class CreateAuthorMapper {

  public static AuthorEntity mapperToAuthorEntity(CreateAuthorRequest from) {
    AuthorEntity to = new AuthorEntity();
    BeanUtils.copyProperties(from, to);
    to.setBirthDate(Date.valueOf(from.getBirthDate()));
    return to;
  }

  public static CreateAuthorResponse mapperToCreateAuthorResponse(AuthorEntity from) {
    CreateAuthorResponse to = new CreateAuthorResponse();
    BeanUtils.copyProperties(from, to);
    to.setBirthDate(from.getBirthDate());
    return to;
  }
}
