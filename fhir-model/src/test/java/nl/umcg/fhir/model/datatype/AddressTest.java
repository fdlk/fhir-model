package nl.umcg.fhir.model.datatype;

import static org.junit.Assert.assertEquals;

import java.io.StringBufferInputStream;
import java.io.StringWriter;
import java.util.Collections;

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

		assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<address xmlns=\"http://hl7.org/fhir\">"
				+ "<use value=\"home\"/>" + "<line value=\"Hanzeplein 1\"/>"
				+ "<city value=\"Groningen\"/>" + "<zip value=\"9700 AB\"/>"
				+ "</address>", sw.toString());
	}

	@Test
	public void testFromXml() throws JAXBException {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
				+ "<address xmlns=\"http://hl7.org/fhir\">"
				+ "<use value='home' />"
				+ "<line value='Hanzeplein 1'/>"
				+ "<city value='Groningen' />"
				+ "<zip value='9700 AB' />"
				+ "</address>";

		JAXBContext context = JAXBContext.newInstance(Address.class);
		Address address = (Address) context.createUnmarshaller().unmarshal(
				new StringBufferInputStream(xml));
		assertEquals(AddressUse.home, address.getUse());
		assertEquals(Collections.singletonList("Hanzeplein 1"),
				address.getLine());
		assertEquals("Groningen", address.getCity());
		assertEquals("9700 AB", address.getZip());
	}

}
