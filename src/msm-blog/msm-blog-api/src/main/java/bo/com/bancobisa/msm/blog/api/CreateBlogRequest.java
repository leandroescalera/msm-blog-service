package bo.com.bancobisa.msm.blog.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author leandro.escalera
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Schema(description = "Solicitud para crear blogs.")
public class CreateBlogRequest implements Serializable {
  private static final long serialVersionUID = 1L;

  @Schema(description = "Identificador unico", example = "1")
  private Long authorId;

  @NotBlank
  @Pattern(regexp = "^[a-zA-ZÀ-ÿ0-9,\\.\\-\\s¡!¿?]+$", message = "El título puede contener letras, números, espacios y los caracteres , . - ¡ ! ¿ ?")
  @Schema(description = "Titulo del Blog", example = "Mi primera publicacion")
  private String title;

  @NotBlank
  @Pattern(regexp = "^[a-zA-ZÀ-ÿ0-9,\\.\\-\\s!¡?¿()_&+*'\"/:;@]+$", message = "El tema puede contener letras, números, espacios y los caracteres , . - ! ¡ ? ¿ ( ) _ & + * ' \" / : ; @")
  @Schema(description = "Titulo del Blog", example = "Mi primera publicacion")
  private String theme;

  @NotBlank
  @Pattern(regexp = "^[\\s\\S]*$", message = "El contenido del blog puede contener cualquier carácter, incluidos espacios y saltos de línea.")
  @Schema(description = "Titulo del Blog", example = "Mi primera publicacion")
  private String content;

  @NotBlank
  @Pattern(regexp = "^(DIARIA|SEMANAL|MENSUAL)$", message = "El periodo debe ser DIARIA, SEMANAL o MENSUAL.")
  @Schema(description = "Titulo del Blog", example = "Mi primera publicacion")
  private String periodicity;

  @Schema(description = "Titulo del Blog", example = "Mi primera publicacion")
  private Boolean allowComments;


  @Schema(description = "Fecha de creacion de blog.", example = "08/10/1991 15:30:45")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDate creationDate;

  @Schema(description = "Fecha de actualizacion del blog.", example = "08/10/1991 15:30:45")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDate updateDate;


}
