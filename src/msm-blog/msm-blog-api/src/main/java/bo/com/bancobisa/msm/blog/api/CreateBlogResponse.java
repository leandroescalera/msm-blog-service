package bo.com.bancobisa.msm.blog.api;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author leandro.escalera
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Schema(description = "Respuesta a la solicitud para crear blogs.")
public class CreateBlogResponse implements Serializable {
  private static final long serialVersionUID = 1L;

  @Schema(description = "Identificador unico", example = "1")
  private Long id;

  @Schema(description = "Titulo del blog.", example = "Mi primera publicacion.")
  private String title;

  @Schema(description = "Tema del blog.", example = "Asi debio ser.")
  private String theme;

  @Schema(description = "Contenido de la publicacion.", example = "Este mi primera publicacoin ........")
  private String content;

  @Schema(description = "Perioodo de publicacion", example = "SEMANAL")
  private String periodicity;

  @Schema(description = "Estado de verificacion de publicacion.", example = "true")
  private Boolean allowComments;

  @Schema(description = "Fecha de creacion del blog", example = "08/10/1991 15:30:45")
  private Date creationDate;

  @Schema(description = "Fecha de actualizacion del blog,", example = "08/10/1991 15:30:45")
  private Date updateDate;

  @Schema(description = "Identificador unico del autor.", example = "1")
  private Long authorId;
}
