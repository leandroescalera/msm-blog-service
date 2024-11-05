package bo.com.example.msas.blog.services.mapper;

import bo.com.example.msas.blog.entities.BlogEntity;
import bo.com.example.msm.blog.api.CreateBlogRequest;
import bo.com.example.msm.blog.api.CreateBlogResponse;
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
