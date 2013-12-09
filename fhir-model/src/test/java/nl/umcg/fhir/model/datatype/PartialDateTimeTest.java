package nl.umcg.fhir.model.datatype;

import static org.junit.Assert.*;

import org.junit.Test;

public class PartialDateTimeTest {

	private FhirDateTime partial;
	
	@Test
	public void testYYYY() {
		partial = new FhirDateTime("1932");
		assertEquals("1932", partial.toString());
	}
	
	@Test
	public void testYYYYMM(){
		partial = new FhirDateTime("1901-12");
		assertEquals("1901-12", partial.toString());
	}
	
	@Test
	public void testYYYYMMDD(){
		partial = new FhirDateTime("2014-08-02");
		assertEquals("2014-08-02", partial.toString());
	}
	
	@Test
	public void testYYYYMMDDTHHmmSS(){
		partial = new FhirDateTime("2014-08-02T12:34:15Z");
		assertEquals("2014-08-02T12:34:15Z", partial.toString());
	}
	
	@Test
	public void testYYYYMMDDHHmmSSZ(){
		partial = new FhirDateTime("2014-08-02T12:34:15+00:00");
		assertEquals("2014-08-02T12:34:15Z", partial.toString());
	}

	@Test
	public void testYYYYMMDDHHmmSSZplus3(){
		partial = new FhirDateTime("2014-08-02T12:34:15+03:00");
		assertEquals("2014-08-02T12:34:15+03:00", partial.toString());
	}

	
}
