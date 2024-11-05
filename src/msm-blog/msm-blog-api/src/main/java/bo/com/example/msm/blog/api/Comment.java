package bo.com.example.msm.blog.api;

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
@Schema(description = "Objeto Comentario.")
public class Comment implements Serializable {
  private static final long serialVersionUID = 1L;


  @Schema(description = "Identificador unico", example = "1")
  private Long id;

  @Schema(description = "Nombres del Autor", example = "Leandro Marcelo")
  private String names;

  @Schema(description = "mail", example = "marcelo.escalera.inf@gmail.com")
  private String mail;

  @Schema(description = "country_residence", example = "Bolivia")
  private String countryResidence;

  @Schema(description = "Contenido de la publicacion.", example = "Este mi primera publicacoin ........")
  private String content;

  @Schema(description = "Puntaje de la publicacion del blog.", example = "10")
  private String score;

  @Schema(description = "Fecha de creacion de la publicacion.", example = "08/10/1991")
  private Date creationDate;

  @Schema(description = "Identificador unico", example = "1")
  private Long blogId;




}
