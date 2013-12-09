package nl.umcg.fhir.model.datatype;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.persistence.oxm.annotations.XmlPath;

public class HumanName {
	@XmlPath("use/@value")
	private String use;
	@XmlPath("text/@value")
	private String text;
	@XmlPath("family/@value")
	private List<String> family = new ArrayList<String>();
	@XmlPath("given/@value")
	private List<String> given = new ArrayList<String>();
	@XmlPath("prefix/@value")
	private List<String> prefix = new ArrayList<String>();
	@XmlPath("suffix/@value")
	private List<String> suffix = new ArrayList<String>();
	private Period period;

	public HumanName addFamily(String string) {
		family.add(string);
		return this;
	}

	public HumanName addGiven(String string) {
		given.add(string);
		return this;
	}

	public HumanName addPrefix(String string) {
		prefix.add(string);
		return this;
	}

	public HumanName addSuffix(String string) {
		suffix.add(string);
		return this;
	}

	public HumanName setText(String string) {
		this.text = string;
		return this;
	}

	public String getUse() {
		return use;
	}

	public String getText() {
		return text;
	}

	public List<String> getFamily() {
		return family;
	}

	public List<String> getGiven() {
		return given;
	}

	public List<String> getPrefix() {
		return prefix;
	}

	public List<String> getSuffix() {
		return suffix;
	}

	public Period getPeriod() {
		return period;
	}

}
