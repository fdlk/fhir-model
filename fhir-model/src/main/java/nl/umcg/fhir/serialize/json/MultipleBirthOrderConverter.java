package nl.umcg.fhir.serialize.json;

import nl.umcg.fhir.model.resource.patient.MultipleBirthOrder;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

public class MultipleBirthOrderConverter implements
		Converter<MultipleBirthOrder, Integer> {

	@Override
	public Integer convert(MultipleBirthOrder value) {
		return value.getOrder();
	}

	@Override
	public JavaType getInputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(MultipleBirthOrder.class);
	}

	@Override
	public JavaType getOutputType(TypeFactory typeFactory) {
		return typeFactory.uncheckedSimpleType(Integer.class);
	}

}