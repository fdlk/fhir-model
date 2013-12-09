package nl.umcg.fhir.model.datatype;

import javax.xml.bind.annotation.XmlElement;

public class Period {
	@XmlElement
	private FhirDateTime start;
	@XmlElement
	private FhirDateTime end;
	
	public Period setStart(String start){
		this.start = new FhirDateTime(start);
		return this;
	}
	
	public Period setEnd(String end){
		this.end = new FhirDateTime(end);
		return this;
	}
	
	public String getStart(){
		return start.toString();
	}
	
	public String getEnd(){
		return end.toString();
	}
}
