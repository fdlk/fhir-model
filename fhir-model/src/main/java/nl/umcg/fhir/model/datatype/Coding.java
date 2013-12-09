package nl.umcg.fhir.model.datatype;

import org.eclipse.persistence.oxm.annotations.XmlPath;

public class Coding {
	@XmlPath("system/@value")
	private String system;
	@XmlPath("version/@value")
	private String version;
	@XmlPath("code/@value")
	private String code;
	@XmlPath("display/@value")
	private String display;
	@XmlPath("primary/@value")
	private Boolean primary;
	@XmlPath("valueSet/@value")
	private ValueSet valueSet;
	
	public Coding(){}

	public Coding(String code, String display, String system) {
		this.code = code;
		this.display = display;
		this.system = system;
	}

	public String getSystem() {
		return system;
	}

	public String getVersion() {
		return version;
	}

	public String getCode() {
		return code;
	}

	public String getDisplay() {
		return display;
	}

	public Boolean getPrimary() {
		return primary;
	}

	public ValueSet getValueSet() {
		return valueSet;
	}

	public Coding setCode(String code) {
		this.code = code;
		return this;
	}

	public Coding setSystem(String codeSystem) {
		this.system = codeSystem;
		return this;
	}
	
}
