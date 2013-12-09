package nl.umcg.fhir.model.datatype;

import javax.xml.bind.annotation.XmlAttribute;

import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.LocalDate;
import org.joda.time.Partial;
import org.joda.time.YearMonth;
import org.joda.time.base.AbstractPartial;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class FhirDateTime {

	private DateTime dateTime;
	private AbstractPartial date;
	private DateTimeFormatter dateTimeFormatter;

	protected FhirDateTime() {
		date = null;
		dateTime = null;
	}

	public FhirDateTime(int year) {
		date = new Partial(DateTimeFieldType.year(), year);
		dateTime = null;
	}

	public FhirDateTime(YearMonth yearMonth) {
		date = yearMonth;
		dateTime = null;
	}

	public FhirDateTime(LocalDate yearMonthDay) {
		date = yearMonthDay;
		dateTime = null;
	}

	public FhirDateTime(String dateIsoFormat) {
		try {
			// yyyy-MM-dd'T'HH:mm:ss.SSSZZ
			dateTime = ISODateTimeFormat.dateTime().withOffsetParsed()
					.parseDateTime(dateIsoFormat);
			date = null;
			dateTimeFormatter = ISODateTimeFormat.dateTime().withZone(
					dateTime.getZone());
			return;
		} catch (IllegalArgumentException e) {
		}
		try {
			// yyyy-MM-dd'T'HH:mm:ssZZ
			dateTime = ISODateTimeFormat.dateTimeNoMillis().withOffsetParsed()
					.parseDateTime(dateIsoFormat);
			date = null;
			dateTimeFormatter = ISODateTimeFormat.dateTimeNoMillis().withZone(
					dateTime.getZone());
			return;
		} catch (IllegalArgumentException e) {

		}
		try {
			dateTime = null;
			// yyyy-mm-dd
			date = ISODateTimeFormat.date().parseLocalDate(dateIsoFormat);
			return;
		} catch (IllegalArgumentException e) {

		}
		try {
			dateTime = null;
			date = new YearMonth(ISODateTimeFormat.yearMonth().parseLocalDate(
					dateIsoFormat));
			return;
		} catch (IllegalArgumentException e) {

		}
		try {
			dateTime = null;
			date = new Partial(DateTimeFieldType.year(), ISODateTimeFormat
					.year().parseLocalDate(dateIsoFormat).getYear());
			return;
		} catch (IllegalArgumentException e) {

		}
		throw new IllegalArgumentException("illegal iso date format: "
				+ dateIsoFormat);
	}

	public FhirDateTime(FhirDateTime partialDate) {
		this.date = partialDate.date;
	}

	@XmlAttribute
	public String getValue() {
		return toString();
	}

	@Override
	public String toString() {
		return date == null ? dateTimeToString() : date.toString();
	}

	private String dateTimeToString() {
		return dateTime == null ? null : dateTimeFormatter.print(dateTime);
	}

}