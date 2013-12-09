package nl.umcg.fhir.model.resource;

import org.eclipse.persistence.oxm.annotations.XmlPath;

public class Reference {
	
	private Reference(){
		
	}
	
	public Reference(String display){
		this.display = display;
	}

	@XmlPath("reference/@value")
	private String reference;

	@XmlPath("display/@value")
	private String display;

	public String getDisplay() {
		return display;
	}

	public String getReference() {
		return reference;
	}
}
