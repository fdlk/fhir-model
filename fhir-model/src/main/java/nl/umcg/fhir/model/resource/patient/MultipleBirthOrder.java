package nl.umcg.fhir.model.resource.patient;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import nl.umcg.fhir.serialize.json.MultipleBirthOrderConverter;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(converter = MultipleBirthOrderConverter.class)
@XmlRootElement(name="multipleBirthInteger")
public class MultipleBirthOrder implements MultipleBirth {

	@XmlAttribute
	private int value;
	
	private MultipleBirthOrder(){
	}
	
	public MultipleBirthOrder(int order) {
		this.value = order;
	}

	public Integer getOrder() {
		return value;
	}

}
