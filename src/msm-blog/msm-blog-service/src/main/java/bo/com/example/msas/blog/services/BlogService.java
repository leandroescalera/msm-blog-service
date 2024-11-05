package bo.com.example.msas.blog.services;

import bo.com.example.msm.blog.api.*;
import bo.com.example.msas.blog.entities.AuthorEntity;
import bo.com.example.msas.blog.entities.BlogEntity;
import bo.com.example.msas.blog.entities.BlogHistoryEntity;
import bo.com.example.msas.blog.entities.CommentEntity;
import bo.com.example.msas.blog.repositories.AuthorRepository;
import bo.com.example.msas.blog.repositories.BlogHistoryRepository;
import bo.com.example.msas.blog.repositories.BlogRepository;
import bo.com.example.msas.blog.repositories.CommentRepository;
import bo.com.example.msas.blog.services.mapper.CreateAuthorMapper;
import bo.com.example.msas.blog.services.mapper.CreateBlogMapper;
import bo.com.example.msas.blog.services.mapper.CreateCommentMapper;
import bo.com.example.msas.blog.services.mapper.GetBlogMapper;
import bo.com.example.msas.blog.services.mapper.UpdateBlogMapper;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

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
    BlogEntity blogEntity = blogRepository.findBlogById(request.getBlogId());
    if (blogEntity == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El Blog no fue encontrado.");
    }
    if (blogEntity.getAllowComments() != true) {
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
    BlogEntity blogEntity = blogRepository.findBlogById(request.getId());
    if (blogEntity == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe el blog.");
    }
    AuthorEntity authorEntity = authorRepository.findAuthorById(blogEntity.getAuthorId().getId());
    blogEntity = UpdateBlogMapper.mapperToBlogEntity(request, authorEntity);
    BlogHistoryEntity blogHistoryEntity = UpdateBlogMapper.mapperToBlogHistoryEntity(blogEntity, authorEntity);
    blogHistoryRepository.save(blogHistoryEntity);
    blogRepository.save(blogEntity);
    UpdateBlogResponse response = UpdateBlogMapper.mapperToCreateCommentResponse(blogEntity);
    return ok(new BaseResponse().setResult(response));
  }

  @Override
  public ResponseEntity<BaseResponse<GetBlogResponse>> getBlog(GetBlogRequest request) throws CustomException {
    if (request.getId() != 0) {
      GetBlogResponse response = new GetBlogResponse();
      BlogEntity blogEntity = blogRepository.findBlogById(request.getId());
      if (blogEntity == null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No existe el blog.");
      }
      AuthorEntity authorEntity = authorRepository.findAuthorById(blogEntity.getAuthorId().getId());
      Author author = GetBlogMapper.mapperToAuthor(authorEntity);
      Blog blog = GetBlogMapper.mapperToBlog(blogEntity);
      blog.setAuthorId(blogEntity.getAuthorId().getId());
      List<Blog> blogs = new ArrayList<>();
      List<CommentEntity> commentEntities = commentRepository.findAllCommentsByBlogId(blogEntity.getId());
      List<Comment> commentList = GetBlogMapper.mapperToComment(commentEntities);
      Comment comment = commentList.stream().findFirst().orElse(null);
      Double max = commentRepository.findMaxScoreByBlogId(comment.getBlogId());
      Double min = commentRepository.findMinScoreByBlogId(comment.getBlogId());
      Double avg = commentRepository.findAvgScoreByBlogId(comment.getBlogId());
      blogs.add(blog.setCommentList(commentList).setMax(max).setMin(min).setAverage(avg));
      response.setAuthor(author);
      response.setBlogList(blogs);
      return ok(new BaseResponse().setResult(response));
    } else {
      ListGetBlogResponse response = new ListGetBlogResponse();
      List<GetBlogResponse> responses = new ArrayList<>();
      List<AuthorEntity> authorEntities = authorRepository.findAllAuthor();
      for (AuthorEntity authorEntity : authorEntities) {
        List<BlogEntity> blogEntities = blogRepository.findAllBlogsByAuthorId(authorEntity.getId());
        Author author = GetBlogMapper.mapperToAuthor(authorEntity);
        GetBlogResponse object = GetBlogMapper.mapperToGetBlogResponse(blogEntities);
        List<Blog> list = new ArrayList<>();
        for (Blog blog : object.getBlogList()) {
          List<CommentEntity> commentEntities = commentRepository.findAllCommentsByBlogId(blog.getId());
          List<Comment> commentList = GetBlogMapper.mapperToComment(commentEntities);
          Double max = 0d;
          Double min = 0d;
          Double avg = 0d;

          for (Comment comment : commentList) {
            max = commentRepository.findMaxScoreByBlogId(comment.getBlogId());
            min = commentRepository.findMinScoreByBlogId(comment.getBlogId());
            avg = commentRepository.findAvgScoreByBlogId(comment.getBlogId());
          }
          blog.setCommentList(commentList);
          blog.setMax(max).setMin(min).setAverage(avg);
          list.add(blog);
        }
        object.setAuthor(author);
        object.setBlogList(list);
        responses.add(object);
      }
      response.setGetBlogResponseList(responses);
      return ok(new BaseResponse().setResult(response));
    }
  }
}
