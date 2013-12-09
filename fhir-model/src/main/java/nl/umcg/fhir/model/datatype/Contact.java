package nl.umcg.fhir.model.datatype;

import javax.xml.bind.annotation.XmlElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

public class Contact {
	@XmlPath("system/@value")
	private String system;
	@XmlPath("value/@value")
	private String value;
	@XmlPath("use/@value")
	private String use;
	@XmlElement
	private Period period;
}
