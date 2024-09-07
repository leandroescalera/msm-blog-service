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
@Schema(description = "Objeto blog.")
public class Author implements Serializable {
  private static final long serialVersionUID = 1L;

  @Schema(description = "Identificador unico", example = "1")
  private Long id;

  @Schema(description = "Nombres del Autor", example = "Leandro Marcelo")
  private String names;

  @Schema(description = "Nombres del Autor", example = "Escalera")
  private String firstSurname;

  @Schema(description = "second_surname", example = "Alconini")
  private String secondSurname;

  @Schema(description = "Fecha de nacimiento.", example = "08/10/1991")
  private Date birthDate;

  @Schema(description = "country_residence", example = "Bolivia")
  private String countryResidence;

  @Schema(description = "mail", example = "marcelo.escalera.inf@gmail.com")
  private String mail;
}
