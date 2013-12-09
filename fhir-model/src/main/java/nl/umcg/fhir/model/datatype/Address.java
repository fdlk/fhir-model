package nl.umcg.fhir.model.datatype;

import java.util.List;

public class Address {
	//TODO: enum
	private String use;
	private String text;
	private List<String> line;
	private String city;
	private String state;
	private String zip;
	private String country;
	private Period period;
	
}
