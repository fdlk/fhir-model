package nl.umcg.fhir.model.datatype.codeableconcept;

import nl.umcg.fhir.model.datatype.CodeableConcept;

public enum MaritalStatus {
	UNMARRIED("unmarried", "U", "http://hl7.org/fhir/marital-status"), ANNULLED(
			"Annulled", "A", "http://hl7.org/fhir/v3/MaritalStatus"), DIVORCED(
			"Divorced", "D", "http://hl7.org/fhir/v3/MaritalStatus"), INTERLOCUTORY(
			"Interlocutory", "I", "http://hl7.org/fhir/v3/MaritalStatus"), LEGALLY_SEPARATED(
			"Legally Separted", "L", "http://hl7.org/fhir/v3/MaritalStatus"), MARRIED(
			"Married", "M", "http://hl7.org/fhir/v3/MaritalStatus"), POLYGAMOUS(
			"Polygamous", "P", "http://hl7.org/fhir/v3/MaritalStatus"), NEVER_MARRIED(
			"Never Married", "S", "http://hl7.org/fhir/v3/MaritalStatus"), DOMESTIC_PARTNER(
			"Domestic partner", "T", "http://hl7.org/fhir/v3/MaritalStatus"), WIDOWED(
			"Widowed", "W", "http://hl7.org/fhir/v3/MaritalStatus"), UNKNOWN(
			"unknown", "UNK", "http://hl7.org/fhir/v3/NullFlavor");

	private CodeableConcept representation;

	private MaritalStatus(String text, String code, String system) {
		this.representation = new CodeableConcept(text, code, system);
	}

	public CodeableConcept getRepresentation() {
		return representation;
	}
}
