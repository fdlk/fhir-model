package nl.umcg.fhir.model.resource.patient;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import nl.umcg.fhir.serialize.json.DeceasedBooleanConverter;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@XmlRootElement
@JsonSerialize(converter=DeceasedBooleanConverter.class)
public class DeceasedBoolean implements Deceased {
	@XmlAttribute
	private Boolean value;
	
	private DeceasedBoolean(){
		
	}

	public DeceasedBoolean(Boolean value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value == null ? "null" : Boolean.toString(value);
	}
	
	public boolean isDeceased(){
		return value;
	}
}
