package bo.com.example.msm.blog.api;

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
@Schema(description = "Solicitud para crear comentarios en una publicacion.")
public class CreateCommentRequest  implements Serializable {
  private static final long serialVersionUID = 1L;


  @Schema(description = "Identificador unico", example = "1")
  private Long id;

  @NotBlank
  @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "Los nombres solo puede contener letras y espacios")
  @Schema(description = "Nombres del Autor", example = "Leandro Marcelo")
  private String names;

  @NotBlank
  @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "El formato del correo es inválido")
  @Schema(description = "mail", example = "marcelo.escalera.inf@gmail.com")
  private String mail;

  @NotBlank
  @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El pais de residencia solo puede contener letras y espacios")
  @Schema(description = "country_residence", example = "Bolivia")
  private String countryResidence;

  @NotBlank
  @Pattern(regexp = "^[\\s\\S]*$", message = "El contenido del blog puede contener cualquier carácter, incluidos espacios y saltos de línea.")
  @Schema(description = "Titulo del Blog", example = "Mi primera publicacion")
  private String content;


  @NotBlank
  @Pattern(regexp = "^(?:10|[0-9])$", message = "La calificación debe ser un número entero entre 0 y 10.")
  @Schema(description = "Titulo del Blog", example = "Mi primera publicacion")
  private String score;

  @Schema(description = "Fecha de creacion del comentario", example = "08/10/1991")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate creationDate;


  @Schema(description = "Identificador unico", example = "1")
  private Long blogId;

}
