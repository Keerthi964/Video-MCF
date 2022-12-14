package es.seresco.cursojee.videoclub.view.dto.actor;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import es.seresco.cursojee.videoclub.validation.IsAfter;
import es.seresco.cursojee.videoclub.validation.NotNullIfAnotherFieldHasValue;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@SuperBuilder
@NotNullIfAnotherFieldHasValue(
	fieldName       = "segundoApellido",
	dependFieldName = "primerApellido"
)
public class ActorDTO implements Serializable
{

	private static final long serialVersionUID = -3115217488196629524L;

	@JsonProperty("nombre")
	@NotBlank
	private String nombre;

	@JsonProperty("primerApellido")
	private String primerApellido;

	@JsonProperty("segundoApellido")
	private String segundoApellido;

	@JsonProperty("fechaNacimiento")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull
	@IsAfter(date = "1900-01-01")
	private Date fechaNacimiento;

}
