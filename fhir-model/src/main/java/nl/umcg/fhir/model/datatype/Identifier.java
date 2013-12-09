package nl.umcg.fhir.model.datatype;

import javax.xml.bind.annotation.XmlElement;

import nl.umcg.fhir.model.resource.Reference;

import org.eclipse.persistence.oxm.annotations.XmlPath;


public class Identifier implements Datatype {
	public enum IdentifierUse{usual, official, temp}
	
	@XmlPath("use/@value")
	private IdentifierUse use;
	@XmlPath("label/@value")
	private String label;
	@XmlPath("system/@value")
	private String system;
	@XmlPath("value/@value")
	private String value;
	private Period period;
	@XmlElement
	private Reference assigner;
	
	public Identifier setValue(String value) {
		this.value = value;
		return this;
	}

	public Identifier setSystem(String system) {
		this.system = system;
		return this;
	}

	public Identifier setLabel(String label) {
		this.label = label;
		return this;
	}

	public Identifier setUse(IdentifierUse use) {
		this.use = use;
		return this;
	}
	
	public Identifier setAssigner(Reference assigner){
		this.assigner = assigner;
		return this;
	}

	public IdentifierUse getUse() {
		return use;
	}

	public String getLabel() {
		return label;
	}

	public String getSystem() {
		return system;
	}

	public String getValue() {
		return value;
	}

	public Period getPeriod() {
		return period;
	}

	public Reference getAssigner() {
		return assigner;
	}
}
