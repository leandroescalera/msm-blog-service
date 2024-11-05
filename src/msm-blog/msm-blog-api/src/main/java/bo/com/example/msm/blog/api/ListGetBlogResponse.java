package bo.com.example.msm.blog.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @author leandro.escalera
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Schema(description = "Respuesta a la solicitud para obtener blogs.")
public class ListGetBlogResponse implements Serializable {
  private static final long serialVersionUID = 1L;

  @Schema(description = "Lista de objetos respuesta por blog.")
  private List<GetBlogResponse> getBlogResponseList;
}
