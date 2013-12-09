package nl.umcg.fhir.model.datatype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

public class CodeableConcept {
	public CodeableConcept(){
		coding = new ArrayList<Coding>();
	}
	
	public CodeableConcept(String text, String code, String system) {
		this.text = text;
		coding = Collections.singletonList(new Coding(code, text, system));
	}

	@XmlElement
	private List<Coding> coding;
	@XmlPath("text/@value")
	private String text;

	public List<Coding> getCoding() {
		return coding;
	}

	public String getText() {
		return text;
	}

	public Coding addCoding() {
		Coding newCoding = new Coding();
		this.coding.add(newCoding);
		return newCoding;
	}

}
