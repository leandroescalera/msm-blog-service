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
@Schema(description = "Solicitud para crear autor.")
public class CreateAuthorRequest implements Serializable {
  private static final long serialVersionUID = 1L;


  @NotBlank
  @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "Los nombres solo puede contener letras y espacios")
  @Schema(description = "Nombres del Autor", example = "Leandro Marcelo")
  private String names;

  @NotBlank
  @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El apellido solo puede contener letras y espacios")
  @Schema(description = "Nombres del Autor", example = "Escalera")
  private String firstSurname;

  @NotBlank
  @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El apellido solo puede contener letras y espacios")
  @Schema(description = "second_surname", example = "Alconini")
  private String secondSurname;

  @Schema(description = "Fecha de nacimiento", example = "08/10/1991")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate birthDate;

  @NotBlank
  @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "El pais de residencia solo puede contener letras y espacios")
  @Schema(description = "country_residence", example = "Bolivia")
  private String countryResidence;

  @NotBlank
  @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$", message = "El formato del correo es inválido")
  @Schema(description = "mail", example = "marcelo.escalera.inf@gmail.com")
  private String mail;


}
