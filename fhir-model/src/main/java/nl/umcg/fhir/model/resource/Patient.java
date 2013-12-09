package nl.umcg.fhir.model.resource;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;

import nl.umcg.fhir.model.datatype.Address;
import nl.umcg.fhir.model.datatype.Attachment;
import nl.umcg.fhir.model.datatype.Contact;
import nl.umcg.fhir.model.datatype.FhirDate;
import nl.umcg.fhir.model.datatype.HumanName;
import nl.umcg.fhir.model.datatype.Identifier;
import nl.umcg.fhir.model.datatype.codeableconcept.AdministrativeGender;
import nl.umcg.fhir.model.datatype.codeableconcept.MaritalStatus;
import nl.umcg.fhir.model.resource.patient.Deceased;
import nl.umcg.fhir.model.resource.patient.DeceasedBoolean;
import nl.umcg.fhir.model.resource.patient.DeceasedDateTime;
import nl.umcg.fhir.model.resource.patient.MultipleBirth;
import nl.umcg.fhir.model.resource.patient.MultipleBirthBoolean;
import nl.umcg.fhir.model.resource.patient.MultipleBirthOrder;
import nl.umcg.fhir.serialize.json.AdministrativeGenderConverter;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@XmlRootElement
public class Patient extends Resource {
	@XmlElement
	private List<Identifier> identifier = new ArrayList<Identifier>();
	@XmlElement
	private List<HumanName> name = new ArrayList<HumanName>();
	@XmlElement
	private List<Contact> telecom = new ArrayList<Contact>();
	@XmlElement
	private AdministrativeGender gender;
	@XmlElement
	private FhirDate birthDate;
	@XmlElementRef
	private Deceased deceased;
	@XmlElement(name = "address")
	private List<Address> address = new ArrayList<Address>();
	@XmlElement
	private MaritalStatus maritalStatus;
	@XmlElementRef
	private MultipleBirth multipleBirth;
	@XmlElement
	private List<Attachment> photo = new ArrayList<Attachment>();
	@XmlPath("active/@value")
	private Boolean active;

	public Identifier addIdentifier() {
		Identifier newIdentifier = new Identifier();
		identifier.add(newIdentifier);
		return newIdentifier;
	}

	public Patient setActive(Boolean active) {
		this.active = active;
		return this;
	}
	
	public Deceased getDeceased(){
		return deceased;
	}

	public Patient setDeceased(Boolean deceased) {
		this.deceased = new DeceasedBoolean(deceased);
		return this;
	}
	
	public Patient setDeceased(String deceasedDate){
		this.deceased = new DeceasedDateTime(deceasedDate);
		return this;
	}
	
	private void setDeceased(Deceased deceased){
		this.deceased = deceased;
	}

	public Patient setGender(AdministrativeGender gender) {
		this.gender = gender;
		return this;
	}

	public Patient setMultipleBirth(int order) {
		this.multipleBirth = new MultipleBirthOrder(order);
		return this;
	}
	
	public Patient setMultipleBirth(boolean multipleBirth){
		this.multipleBirth = new MultipleBirthBoolean(multipleBirth);
		return this;
	}

	public Patient setBirthDate(String birthDate) {
		this.birthDate = new FhirDate(birthDate);
		return this;
	}
	
	private void setBirthDate(FhirDate birthDate){
		this.birthDate = birthDate;
	}

	public HumanName addName() {
		HumanName newName = new HumanName();
		name.add(newName);
		return newName;
	}

	public List<Identifier> getIdentifier() {
		return identifier;
	}

	public List<HumanName> getName() {
		return name;
	}

	public List<Contact> getTelecom() {
		return telecom;
	}

	@JsonSerialize(converter = AdministrativeGenderConverter.class)
	public AdministrativeGender getGender() {
		return gender;
	}

	public String getBirthDate() {
		return birthDate.toString();
	}

	public List<Address> getAddress() {
		return address;
	}

	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public MultipleBirth getMultipleBirth() {
		return multipleBirth;
	}

	public List<Attachment> getPhoto() {
		return photo;
	}

	public Boolean getActive() {
		return active;
	}

	@Override
	public String getResourceType() {
		return "Patient";
	}
}
