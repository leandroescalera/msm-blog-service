package bo.com.bancobisa.msas.blog.services.mapper;

import bo.com.bancobisa.msas.blog.entities.CommentEntity;
import bo.com.bancobisa.msm.blog.api.CreateCommentRequest;
import bo.com.bancobisa.msm.blog.api.CreateCommentResponse;
import org.springframework.beans.BeanUtils;

import java.sql.Date;

/**
 * @author leandro.escalera
 */
public final class CreateCommentMapper {

  public static CommentEntity mapperToCommentEntity(CreateCommentRequest from) {
    CommentEntity to = new CommentEntity();
    BeanUtils.copyProperties(from, to);
    to.setCreationDate(Date.valueOf(from.getCreationDate()));
    to.setScore(Integer.valueOf(from.getScore()));
    return to;
  }

  public static CreateCommentResponse mapperToCreateCommentResponse(CommentEntity from) {
    CreateCommentResponse to = new CreateCommentResponse();
    BeanUtils.copyProperties(from, to);
    return to;
  }
}
