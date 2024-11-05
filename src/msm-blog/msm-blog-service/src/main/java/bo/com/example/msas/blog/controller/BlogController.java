package bo.com.example.msas.blog.controller;

import bo.com.example.msm.blog.api.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author leandro.escalera
 */
@Log
@RestController
@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
public class BlogController {

  @Autowired
  private IBlogApi api;

  @PostMapping("/createAuthor")
  @Operation(summary = "Crea autores.", description = "Este endpoint permite crear autores.", tags = {"Autor"})
  public ResponseEntity<BaseResponse<CreateAuthorResponse>> createAuthor(@RequestBody @Valid CreateAuthorRequest request) throws CustomException {
    return api.createAuthor(request);
  }

  @PostMapping("/createBlog")
  @Operation(summary = "Crea blogs.", description = "Este endpoint permite crear blogs.", tags = {"Blog"})
  public ResponseEntity<BaseResponse<CreateBlogResponse>> createBlog(@RequestBody @Valid CreateBlogRequest request) throws CustomException {
    return api.createBlog(request);
  }

  @PostMapping("/createComment")
  @Operation(summary = "Crea comentario.", description = "Este endpoint permite crear comentarios a publicaciones de autores.", tags = {"Blog"})
  public ResponseEntity<BaseResponse<CreateCommentResponse>> createComment(@RequestBody @Valid CreateCommentRequest request) throws CustomException {
    return api.createComment(request);
  }

  @PutMapping("/updateBlog")
  @Operation(summary = "Actualizar blogs.", description = "Este endpoint permite actualizar blogs.", tags = {"Blog"})
  public ResponseEntity<BaseResponse<UpdateBlogResponse>> updateBlog(@RequestBody @Valid UpdateBlogRequest request) throws CustomException {
    return api.updateBlog(request);
  }

  @PostMapping("/getBlog")
  @Operation(summary = "Obtener blogs.", description = "Este endpoint permite obtener blogs.", tags = {"Blog"})
  public ResponseEntity<BaseResponse<GetBlogResponse>> getBlog(@RequestBody @Valid GetBlogRequest request) throws CustomException {
    return api.getBlog(request);
  }

}
