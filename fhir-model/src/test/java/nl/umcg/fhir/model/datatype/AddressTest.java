package nl.umcg.fhir.model.datatype;

import static org.junit.Assert.*;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.namespace.QName;

import nl.umcg.fhir.model.datatype.Address.AddressUse;

import org.junit.Test;

public class AddressTest {

	@Test
	public void testXml() throws JAXBException {
		Address address = new Address();
		address.setUse(AddressUse.home).addLine("Hanzeplein 1")
				.setZip("9700 AB").setCity("Groningen");

		JAXBContext context = JAXBContext.newInstance(Address.class);
		StringWriter sw = new StringWriter();
		context.createMarshaller().marshal(
				new JAXBElement<Address>(new QName("http://hl7.org/fhir",
						"address"), Address.class, address), sw);

		assertEquals(
				"<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<address xmlns=\"http://hl7.org/fhir\">"
				+ "<use>home</use>"
				+ "<line>Hanzeplein 1</line>"
				+ "<city>Groningen</city>"
				+ "<zip>9700 AB</zip>"
				+ "</address>",
				sw.toString());
	}

}
