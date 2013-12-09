package nl.umcg.fhir.model.datatype;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Address {
	public enum AddressUse {
		home, work, temp, old
	}

	@XmlPath("use/@value")
	private AddressUse use;
	@XmlPath("text/@value")
	private String text;
	@XmlPath("line/@value")
	private List<String> line = new ArrayList<String>();
	@XmlPath("city/@value")
	private String city;
	@XmlPath("state/@value")
	private String state;
	@XmlPath("zip/@value")
	private String zip;
	@XmlPath("country/@value")
	private String country;
	@XmlElement
	private Period period;

	public Address setUse(AddressUse use) {
		this.use = use;
		return this;
	}

	public Address setText(String text) {
		this.text = text;
		return this;
	}

	public Address addLine(String line) {
		this.line.add(line);
		return this;
	}
	
	public Address setCity(String city) {
		this.city = city;
		return this;
	}

	public Address setState(String state) {
		this.state = state;
		return this;
	}

	public Address setZip(String zip) {
		this.zip = zip;
		return this;
	}

	public Address setCountry(String country) {
		this.country = country;
		return this;
	}

	public Address setPeriod(Period period) {
		this.period = period;
		return this;
	}

	public AddressUse getUse() {
		return use;
	}

	public String getText() {
		return text;
	}

	public List<String> getLine() {
		return line;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public String getCountry() {
		return country;
	}

	public Period getPeriod() {
		return period;
	}

}
