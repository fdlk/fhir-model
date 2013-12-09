package nl.umcg.fhir.serialize.json;

import nl.umcg.fhir.model.datatype.CodeableConcept;
import nl.umcg.fhir.model.datatype.codeableconcept.AdministrativeGender;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

/**
 * Converts AdministrativeGender to a CodeableConcept
 */
public class AdministrativeGenderConverter implements
		Converter<AdministrativeGender,CodeableConcept> {

	@Override
	public CodeableConcept convert(AdministrativeGender value) {
		return value.getRepresentation();
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(AdministrativeGender.class);
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(CodeableConcept.class);
	}

}
