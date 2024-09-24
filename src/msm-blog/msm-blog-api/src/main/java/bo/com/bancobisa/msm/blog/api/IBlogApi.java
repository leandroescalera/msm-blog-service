package bo.com.bancobisa.msm.blog.api;

import org.springframework.http.ResponseEntity;

/**
 * @author leandro.escalera
 */public interface IBlogApi {

  /**
   * Let create a new author
   *
   * @param request CreateAuthorRequest
   * @return CreateAuthorResponse
   * @throws CustomException on any Exception
   */
  ResponseEntity<BaseResponse<CreateAuthorResponse>> createAuthor(CreateAuthorRequest request) throws CustomException;

  /**
   * Let create a new blog
   *
   * @param request CreateBlogRequest
   * @return CreateBlogResponse
   * @throws CustomException on any Exception
   */
  ResponseEntity<BaseResponse<CreateBlogResponse>> createBlog(CreateBlogRequest request) throws CustomException;

  /**
   * Let create a new comment
   *
   * @param request CreateCommentRequest
   * @return CreateCommentResponse
   * @throws CustomException on any Exception
   */
  ResponseEntity<BaseResponse<CreateCommentResponse>> createComment(CreateCommentRequest request) throws CustomException;

  /**
   * Let create a new comment
   *
   * @param request UpdateBlogRequest
   * @return UpdateBlogResponse
   * @throws CustomException on any Exception
   */
  ResponseEntity<BaseResponse<UpdateBlogResponse>> updateBlog(UpdateBlogRequest request) throws CustomException;

  /**
   * Let create a new comment
   *
   * @param request GetBlogRequest
   * @return GetBlogResponse
   * @throws CustomException on any Exception
   */
  ResponseEntity<BaseResponse<GetBlogResponse>> getBlog(GetBlogRequest request) throws CustomException;
}
