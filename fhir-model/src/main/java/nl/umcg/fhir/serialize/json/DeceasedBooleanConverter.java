package nl.umcg.fhir.serialize.json;

import nl.umcg.fhir.model.resource.patient.DeceasedBoolean;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

public class DeceasedBooleanConverter implements
		Converter<DeceasedBoolean, Boolean> {

	@Override
	public Boolean convert(DeceasedBoolean value) {
		return value.isDeceased();
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(DeceasedBoolean.class);
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(Boolean.class);
	}

}
