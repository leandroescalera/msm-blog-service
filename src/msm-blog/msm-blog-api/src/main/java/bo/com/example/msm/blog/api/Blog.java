package bo.com.example.msm.blog.api;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * @author leandro.escalera
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Schema(description = "Objeto blog.")
public class Blog implements Serializable {
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

  @Schema(description = "Maximo de puntuacion.", example = "1")
  private Double max;

  @Schema(description = "Minimo de puntuacion.", example = "10")
  private Double min;

  @Schema(description = "Promedio de puntuacion", example = "15")
  private Double average;

  @Schema(description = "Lista de comentarios del blog.")
  private List<Comment> commentList;
}
