package nl.umcg.fhir.model.resource;

import javax.xml.bind.annotation.XmlElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

public class Narrative {
	@XmlPath("status/@value")
	private String status;
	@XmlElement(namespace="http://www.w3.org/1999/xhtml")
	private String div;
	
	public Narrative setStatus(String status){
		this.status = status;
		return this;
	}
	
	public Narrative setDiv(String div){
		this.div = div;
		return this;
	}

	public String getStatus() {
		return status;
	}

	public String getDiv() {
		return div;
	}
}