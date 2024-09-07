package bo.com.bancobisa.msas.blog.services;

import bo.com.bancobisa.msas.blog.entities.AuthorEntity;
import bo.com.bancobisa.msas.blog.repositories.AuthorRepository;
import bo.com.bancobisa.msas.blog.services.mapper.CreateAuthorMapper;
import bo.com.bancobisa.msm.blog.api.CreateAuthorRequest;
import bo.com.bancobisa.msm.blog.api.CreateAuthorResponse;
import bo.com.bancobisa.msm.blog.api.IBlogApi;
import bo.com.bancofie.msas.common.config.CustomException;
import bo.com.bancofie.msas.common.data.BaseResponse;
import bo.com.bancofie.msas.common.rest.CommonResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Override
  public ResponseEntity<BaseResponse<CreateAuthorResponse>> createAuthor(CreateAuthorRequest request) throws CustomException {
    AuthorEntity authorEntity = CreateAuthorMapper.mapperToAuthorEntity(request);

    return ok(new BaseResponse().setResult(null));
  }
}
