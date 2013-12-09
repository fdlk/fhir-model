package nl.umcg.fhir.model.datatype.codeableconcept;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import nl.umcg.fhir.model.datatype.CodeableConcept;
import nl.umcg.fhir.serialize.xml.AdministrativeGenderAdapter;

@XmlJavaTypeAdapter(value = AdministrativeGenderAdapter.class)
public enum AdministrativeGender {
	FEMALE("Female", "F", "http://hl7.org/fhir/v3/AdministrativeGender"), MALE(
			"Male", "M", "http://hl7.org/fhir/v3/AdministrativeGender"), UNDIFFERENTIATED(
			"Undifferentiated", "UN",
			"http://hl7.org/fhir/v3/AdministrativeGender"), UNKNOWN("unknown",
			"UNK", "http://hl7.org/fhir/v3/NullFlavor");

	private CodeableConcept representation;

	private AdministrativeGender(String text, String code, String system) {
		this.representation = new CodeableConcept(text, code, system);
	}

	public CodeableConcept getRepresentation() {
		return representation;
	}
}
