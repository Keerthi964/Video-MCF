package es.seresco.cursojee.videoclub.view.dto.pelicula;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.fasterxml.jackson.annotation.JsonProperty;

import es.seresco.cursojee.videoclub.view.dto.Identificable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
public class RequestActualizarPeliculaDTO extends PeliculaDTO implements Identificable<Long>
{

	private static final long serialVersionUID = 5937614731389356596L;

	@JsonProperty(value = "id", index = 0)
	@NotNull
	@Positive
	@EqualsAndHashCode.Include
	private Long id;

}
