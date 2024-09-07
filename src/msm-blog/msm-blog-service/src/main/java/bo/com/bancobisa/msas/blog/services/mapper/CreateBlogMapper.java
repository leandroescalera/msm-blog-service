package bo.com.bancobisa.msas.blog.services.mapper;

import bo.com.bancobisa.msas.blog.entities.AuthorEntity;
import bo.com.bancobisa.msas.blog.entities.BlogEntity;
import bo.com.bancobisa.msm.blog.api.CreateAuthorRequest;
import bo.com.bancobisa.msm.blog.api.CreateAuthorResponse;
import bo.com.bancobisa.msm.blog.api.CreateBlogRequest;
import bo.com.bancobisa.msm.blog.api.CreateBlogResponse;
import org.springframework.beans.BeanUtils;

import java.sql.Date;

/**
 * @author leandro.escalera
 */
public final class CreateBlogMapper {
  public static BlogEntity mapperToBlogEntity(CreateBlogRequest from) {
    BlogEntity to = new BlogEntity();
    BeanUtils.copyProperties(from, to);
    to.setCreationDate(Date.valueOf(from.getCreationDate()));
    to.setUpdateDate(Date.valueOf(from.getUpdateDate()));
    return to;
  }

  public static CreateBlogResponse mapperToCreateBlogResponse(BlogEntity from) {
    CreateBlogResponse to = new CreateBlogResponse();
    BeanUtils.copyProperties(from, to);
    return to;
  }
}
