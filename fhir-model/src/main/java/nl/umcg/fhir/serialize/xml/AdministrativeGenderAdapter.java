package nl.umcg.fhir.serialize.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import nl.umcg.fhir.model.datatype.CodeableConcept;
import nl.umcg.fhir.model.datatype.codeableconcept.AdministrativeGender;

public class AdministrativeGenderAdapter extends
		XmlAdapter<CodeableConcept, AdministrativeGender> {

	@Override
	public AdministrativeGender unmarshal(CodeableConcept concept)
			throws Exception {
		for (AdministrativeGender gender : AdministrativeGender.values()) {
			if (gender.getRepresentation().equals(concept)){
				return gender;
			}
		}
		return null;
	}

	@Override
	public CodeableConcept marshal(AdministrativeGender gender)
			throws Exception {
		if (null == gender) {
			return null;
		}
		return gender.getRepresentation();
	}
}
