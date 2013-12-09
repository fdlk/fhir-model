package nl.umcg.fhir.serialize.json;

import nl.umcg.fhir.model.resource.patient.MultipleBirthBoolean;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

public class MultipleBirthBooleanConverter implements
		Converter<MultipleBirthBoolean, Boolean> {

	@Override
	public Boolean convert(MultipleBirthBoolean value) {
		return value.isMultipleBirth();
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(MultipleBirthBoolean.class);
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(Boolean.class);
	}

}
