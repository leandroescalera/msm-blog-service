package bo.com.example.msm.blog.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author leandro.escalera
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Schema(description = "Solicitud para obtener blogs.")
public class GetBlogRequest implements Serializable {
  private static final long serialVersionUID = 1L;

  @Schema(description = "Identificador unico de blog", example = "1")
  private Long id;
}
