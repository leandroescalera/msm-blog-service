package bo.com.bancobisa.msm.blog.api;

import bo.com.bancofie.msas.common.config.CustomException;
import bo.com.bancofie.msas.common.data.BaseResponse;
import org.springframework.http.ResponseEntity;

/**
 * @author leandro.escalera
 */public interface IBlogApi {

  /**
   * Obtain a token of access
   *
   * @param request CreateAuthorRequest
   * @return CreateAuthorResponse
   * @throws CustomException on any Exception
   */
  ResponseEntity<BaseResponse<CreateAuthorResponse>> createAuthor(CreateAuthorRequest request) throws CustomException;
}
