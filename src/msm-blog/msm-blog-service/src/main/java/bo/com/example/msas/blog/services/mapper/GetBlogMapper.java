package bo.com.example.msas.blog.services.mapper;

import bo.com.example.msm.blog.api.*;
import bo.com.example.msas.blog.entities.AuthorEntity;
import bo.com.example.msas.blog.entities.BlogEntity;
import bo.com.example.msas.blog.entities.CommentEntity;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author leandro.escalera
 */
public final class GetBlogMapper {

  public static Blog mapperToBlog(BlogEntity from) {
    Blog to = new Blog();
    BeanUtils.copyProperties(from, to);
    to.setAuthorId(from.getAuthorId().getId());
    return to;
  }

  public static List<Blog> mapperToBlog(List<BlogEntity> from) {
    List<Blog> to = from.stream().map(GetBlogMapper::mapperToBlog).collect(Collectors.toList());
    return to;
  }

  public static void mapperToBlog(List<BlogEntity> from, GetBlogResponse to) {
    to.setBlogList(mapperToBlog(from));
  }
  public static GetBlogResponse mapperToGetBlogResponse(List<BlogEntity> from) {
    GetBlogResponse to = new GetBlogResponse();
    mapperToBlog(from, to);
    return to;
  }

  public static Author mapperToAuthor(AuthorEntity from) {
    Author to = new Author();
    BeanUtils.copyProperties(from, to);
    return to;
  }

  public static Comment mapperToComment(CommentEntity from) {
    Comment to = new Comment();
    BeanUtils.copyProperties(from, to);
    to.setBlogId(from.getBlogId().getId());
    to.setScore(String.valueOf(from.getScore()));
    return to;
  }

  public static List<Comment> mapperToComment(List<CommentEntity> from) {
    List<Comment> to = from.stream().map(GetBlogMapper::mapperToComment).collect(Collectors.toList());
    return to;
  }


}
