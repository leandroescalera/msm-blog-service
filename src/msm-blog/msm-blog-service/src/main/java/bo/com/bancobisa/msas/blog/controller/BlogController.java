package bo.com.bancobisa.msas.blog.controller;

import bo.com.bancobisa.msm.blog.api.CreateAuthorRequest;
import bo.com.bancobisa.msm.blog.api.CreateAuthorResponse;
import bo.com.bancobisa.msm.blog.api.IBlogApi;
import bo.com.bancofie.msas.common.config.CustomException;
import bo.com.bancofie.msas.common.data.BaseResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * @author leandro.escalera
 */
@Log
@RestController
@RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
@Tag(name = "Blog Service", description = "Servicio que realiza la gestion de un portal de blogs.")
public class BlogController {

  @Autowired
  private IBlogApi api;

  @PostMapping("/createAuthor")
  @Operation(summary = "Crea autores", description = "Este endpoint permite crear autores.", tags = {"Autor"})
  public ResponseEntity<BaseResponse<CreateAuthorResponse>> createAuthor(@RequestBody @Valid CreateAuthorRequest request) throws CustomException {
    return api.createAuthor(request);
  }
}
