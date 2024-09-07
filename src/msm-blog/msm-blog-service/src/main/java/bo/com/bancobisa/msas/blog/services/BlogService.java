package bo.com.bancobisa.msas.blog.services;

import bo.com.bancobisa.msas.blog.entities.AuthorEntity;
import bo.com.bancobisa.msas.blog.entities.BlogEntity;
import bo.com.bancobisa.msas.blog.entities.BlogHistoryEntity;
import bo.com.bancobisa.msas.blog.entities.CommentEntity;
import bo.com.bancobisa.msas.blog.repositories.AuthorRepository;
import bo.com.bancobisa.msas.blog.repositories.BlogHistoryRepository;
import bo.com.bancobisa.msas.blog.repositories.BlogRepository;
import bo.com.bancobisa.msas.blog.repositories.CommentRepository;
import bo.com.bancobisa.msas.blog.services.mapper.CreateAuthorMapper;
import bo.com.bancobisa.msas.blog.services.mapper.CreateBlogMapper;
import bo.com.bancobisa.msas.blog.services.mapper.CreateCommentMapper;
import bo.com.bancobisa.msas.blog.services.mapper.UpdateBlogMapper;
import bo.com.bancobisa.msm.blog.api.*;
import bo.com.bancofie.msas.common.config.CustomException;
import bo.com.bancofie.msas.common.data.BaseResponse;
import bo.com.bancofie.msas.common.rest.CommonResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Date;
import java.time.LocalDate;

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

  @Autowired
  private BlogHistoryRepository blogHistoryRepository;

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
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El autor no fue encontrado.");
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
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El Blog no fue encontrado.");
    }
    if (blogEntity.getAllowComments()!=true){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se puede comentar, el autor puso en privado el blog.");
    }
    commentEntity.setBlogId(blogEntity);
    commentEntity = commentRepository.save(commentEntity);
    CreateCommentResponse response = CreateCommentMapper.mapperToCreateCommentResponse(commentEntity);
    response.setBlogId(blogEntity.getId());
    return ok(new BaseResponse().setResult(response));
  }

  @Override
  public ResponseEntity<BaseResponse<UpdateBlogResponse>> updateBlog(UpdateBlogRequest request) throws CustomException {
    BlogEntity blogEntity =  blogRepository.findBlogById(request.getId());
    if (blogEntity==null){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe el blog.");
    }
    AuthorEntity authorEntity = authorRepository.findAuthorById(blogEntity.getAuthorId().getId());
    blogEntity = UpdateBlogMapper.mapperToBlogEntity(request,authorEntity);
    BlogHistoryEntity blogHistoryEntity = UpdateBlogMapper.mapperToBlogHistoryEntity(blogEntity,authorEntity);
    blogHistoryRepository.save(blogHistoryEntity);
    blogRepository.save(blogEntity);
    UpdateBlogResponse response = UpdateBlogMapper.mapperToCreateCommentResponse(blogEntity);
    return ok(new BaseResponse().setResult(response));
  }


}
