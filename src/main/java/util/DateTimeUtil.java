package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
	public static LocalDate toDate(String dateString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(dateString, formatter);
	}
}
