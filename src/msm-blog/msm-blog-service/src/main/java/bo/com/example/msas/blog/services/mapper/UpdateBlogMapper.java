package bo.com.example.msas.blog.services.mapper;

import bo.com.example.msas.blog.entities.AuthorEntity;
import bo.com.example.msas.blog.entities.BlogEntity;
import bo.com.example.msas.blog.entities.BlogHistoryEntity;
import bo.com.example.msm.blog.api.UpdateBlogRequest;
import bo.com.example.msm.blog.api.UpdateBlogResponse;
import org.springframework.beans.BeanUtils;

import java.sql.Date;
import java.time.LocalDate;

/**
 * @author leandro.escalera
 */
public final class UpdateBlogMapper {
  public static UpdateBlogResponse mapperToCreateCommentResponse(BlogEntity from) {
    UpdateBlogResponse to = new UpdateBlogResponse();
    BeanUtils.copyProperties(from, to);
    return to;
  }

  public static void mapperToBlogEntity(UpdateBlogRequest from, BlogEntity to, AuthorEntity entity) {
    to.setId(from.getId());
    to.setTitle(from.getTitle());
    to.setTheme(from.getTheme());
    to.setContent(from.getContent());
    to.setPeriodicity(from.getPeriodicity());
    to.setAllowComments(from.getAllowComments());
    to.setCreationDate(Date.valueOf(from.getCreationDate()));
    to.setUpdateDate(Date.valueOf(from.getUpdateDate()));
    to.setAuthorId(entity);
  }

  public static BlogEntity mapperToBlogEntity(UpdateBlogRequest from, AuthorEntity entity) {
    BlogEntity to = new BlogEntity();
    mapperToBlogEntity(from, to, entity);
    return to;
  }


  public static void mapperToBlogHistoryEntity(BlogEntity from, BlogHistoryEntity to, AuthorEntity authorEntity) {
    to.setContentAbove(from.getContent());
    to.setUpdateDate(Date.valueOf(LocalDate.now()));
    to.setAllowComments(from.getAllowComments());
    to.setAuthorId(authorEntity);
    to.setBlogId(from);
  }

  public static BlogHistoryEntity mapperToBlogHistoryEntity(BlogEntity from, AuthorEntity authorEntity) {
    BlogHistoryEntity to = new BlogHistoryEntity();
    mapperToBlogHistoryEntity(from, to, authorEntity);
    return to;
  }

}
