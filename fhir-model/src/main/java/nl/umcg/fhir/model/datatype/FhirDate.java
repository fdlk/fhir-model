package nl.umcg.fhir.model.datatype;

import javax.xml.bind.annotation.XmlAttribute;

import org.joda.time.DateTimeFieldType;
import org.joda.time.LocalDate;
import org.joda.time.Partial;
import org.joda.time.YearMonth;
import org.joda.time.base.AbstractPartial;
import org.joda.time.format.ISODateTimeFormat;

public class FhirDate {
	private AbstractPartial date;

	protected FhirDate() {
		date = null;
	}

	public FhirDate(int year) {
		date = new Partial(DateTimeFieldType.year(), year);
	}

	public FhirDate(YearMonth yearMonth) {
		date = yearMonth;
	}

	public FhirDate(LocalDate yearMonthDay) {
		date = yearMonthDay;
	}

	public FhirDate(String dateIsoFormat) {
		try{	
			// yyyy-MM-dd
			date = ISODateTimeFormat.date().parseLocalDate(dateIsoFormat);
			return;
		} catch (IllegalArgumentException e) {

		}
		try {
			// yyyy-MM
			date = new YearMonth(ISODateTimeFormat.yearMonth().parseLocalDate(
					dateIsoFormat));
			return;
		} catch (IllegalArgumentException e) {

		}
		try {
			// yyyy
			date = new Partial(DateTimeFieldType.year(), ISODateTimeFormat
					.year().parseLocalDate(dateIsoFormat).getYear());
			return;
		} catch (IllegalArgumentException e) {

		}
		throw new IllegalArgumentException("illegal iso date format: "+ dateIsoFormat);
	}

	public FhirDate(FhirDate partialDate) {
		this.date = partialDate.date;
	}

	@XmlAttribute
	public String getValue() {
		return toString();
	}

	@Override
	public String toString() {
		return date == null ? null : date.toString();
	}

}