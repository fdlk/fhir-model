package nl.umcg.fhir.model.resource.patient;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import nl.umcg.fhir.serialize.json.MultipleBirthBooleanConverter;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@XmlRootElement
@JsonSerialize(converter = MultipleBirthBooleanConverter.class)
public class MultipleBirthBoolean implements MultipleBirth {

	@XmlAttribute
	private boolean value;
	
	private MultipleBirthBoolean(){}
	
	public MultipleBirthBoolean(boolean multipleBirth) {
		value = multipleBirth;
	}
	
	public boolean isMultipleBirth(){
		return value;
	}
}
