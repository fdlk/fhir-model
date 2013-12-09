package nl.umcg.fhir.model.resource.patient;

import javax.xml.bind.annotation.XmlRootElement;

import nl.umcg.fhir.model.datatype.FhirDateTime;

@XmlRootElement
public class DeceasedDateTime extends FhirDateTime implements Deceased {

	private DeceasedDateTime(){
		
	}
	
	public DeceasedDateTime(String date){
		super(date);
	}
	
}
