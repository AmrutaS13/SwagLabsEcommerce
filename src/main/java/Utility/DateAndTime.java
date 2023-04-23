package Utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {

	public static String getDateAndTime()  {
		
		LocalDateTime date	=LocalDateTime.now();
		
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		String dateAndTime =date.format(pattern);
		
		return dateAndTime;
		
	}

}
