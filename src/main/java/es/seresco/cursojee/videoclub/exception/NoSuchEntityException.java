package es.seresco.cursojee.videoclub.exception;

import static java.lang.String.format;

import java.io.Serializable;
import java.util.function.Supplier;

import es.seresco.cursojee.videoclub.view.dto.Identificable;

public class NoSuchEntityException
		extends PreconditionalException
		implements Identificable<Serializable>
{

	private static final long serialVersionUID = 6004871815354527714L;

	//
	// Campos
	//

	private final String type;

	private final Serializable id;

	//
	// Constructores.
	// Al menos con uno sin parametros (Bean) y otros con los NotNull
	//

	public NoSuchEntityException(final String type, final Serializable id)
	{
		super(format("The `%s` identified by `%s` doesn't exist.", type, id));
		this.type = type;
		this.id = id;
	}

	public NoSuchEntityException(final String type, final Serializable id, final Throwable cause)
	{
		this(type, id);
		initCause(cause);
	}

	public NoSuchEntityException(final Class<?> type, final Serializable id)
	{
		this(type.getTypeName(), id);
	}

	public NoSuchEntityException(final Class<?> type, final Serializable id, final Throwable cause)
	{
		this(type, id);
		initCause(cause);
	}

	public static Supplier<NoSuchEntityException> creater(final String type, final Serializable id) {
		return () -> new NoSuchEntityException(type, id);
	}

	public static Supplier<NoSuchEntityException> creater(final Class<?> type, final Serializable id) {
		return () -> new NoSuchEntityException(type, id);
	}

	//
	// Getters y setters
	//

	public String getType() {
		return type;
	}

	@Override
	public Serializable getId() {
		return id;
	}

}
