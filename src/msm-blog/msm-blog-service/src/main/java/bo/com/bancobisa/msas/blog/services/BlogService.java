package bo.com.bancobisa.msas.blog.services;

import bo.com.bancobisa.msas.blog.entities.AuthorEntity;
import bo.com.bancobisa.msas.blog.entities.BlogEntity;
import bo.com.bancobisa.msas.blog.entities.CommentEntity;
import bo.com.bancobisa.msas.blog.repositories.AuthorRepository;
import bo.com.bancobisa.msas.blog.repositories.BlogRepository;
import bo.com.bancobisa.msas.blog.repositories.CommentRepository;
import bo.com.bancobisa.msas.blog.services.mapper.CreateAuthorMapper;
import bo.com.bancobisa.msas.blog.services.mapper.CreateBlogMapper;
import bo.com.bancobisa.msas.blog.services.mapper.CreateCommentMapper;
import bo.com.bancobisa.msm.blog.api.*;
import bo.com.bancofie.msas.common.config.CustomException;
import bo.com.bancofie.msas.common.data.BaseResponse;
import bo.com.bancofie.msas.common.rest.CommonResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author leandro.escalera
 */

@Log
@Service
public class BlogService implements IBlogApi, CommonResponse {

  @Autowired
  private AuthorRepository authorRepository;

  @Autowired
  private BlogRepository blogRepository;

  @Autowired
  private CommentRepository commentRepository;

  @Override
  public ResponseEntity<BaseResponse<CreateAuthorResponse>> createAuthor(CreateAuthorRequest request) throws CustomException {
    AuthorEntity authorEntity = CreateAuthorMapper.mapperToAuthorEntity(request);
    authorEntity = authorRepository.save(authorEntity);
    CreateAuthorResponse response = CreateAuthorMapper.mapperToCreateAuthorResponse(authorEntity);
    return ok(new BaseResponse().setResult(response));
  }

  @Override
  public ResponseEntity<BaseResponse<CreateBlogResponse>> createBlog(CreateBlogRequest request) throws CustomException {
    BlogEntity blogEntity = CreateBlogMapper.mapperToBlogEntity(request);
    AuthorEntity authorEntity = authorRepository.findAuthorById(request.getAuthorId());
    if (authorEntity == null) {
      throw new CustomException("El autor no fue encontrado. ", HttpStatus.BAD_REQUEST);
    }
    blogEntity.setAuthorId(authorEntity);
    blogEntity = blogRepository.save(blogEntity);
    CreateBlogResponse response = CreateBlogMapper.mapperToCreateBlogResponse(blogEntity);
    response.setAuthorId(authorEntity.getId());
    return ok(new BaseResponse().setResult(response));
  }

  @Override
  public ResponseEntity<BaseResponse<CreateCommentResponse>> createComment(CreateCommentRequest request) throws CustomException {
    CommentEntity commentEntity = CreateCommentMapper.mapperToCommentEntity(request);
    BlogEntity blogEntity =  blogRepository.findBlogById(request.getBlogId());
    if (blogEntity==null){
      throw new CustomException("El Blog no fue encontrado. ", HttpStatus.BAD_REQUEST);
    }
    if (blogEntity.getAllowComments()!=true){
      throw new CustomException("No se puede comentar, el autor puso en privado el blog. ", HttpStatus.BAD_REQUEST);
    }
    commentEntity.setBlogId(blogEntity);
    commentEntity = commentRepository.save(commentEntity);
    CreateCommentResponse response = CreateCommentMapper.mapperToCreateCommentResponse(commentEntity);
    response.setBlogId(blogEntity.getId());
    return ok(new BaseResponse().setResult(response));
  }
}
