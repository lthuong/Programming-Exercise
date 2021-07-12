package Ulti;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUlti {
	
	
	public static int ConvertDateToInt(String date)
	{
		int answer = 0;
		int day = 0;
		int month = 0;
		int year = 0;
		
	    String[] values = date.split("-");
	    day = Integer.parseInt(values[2]);	
	    month = Integer.parseInt(values[1]);
	    year = Integer.parseInt(values[0]);
		
		answer = year*10000 + month*100 + day;
		return answer;
	}
	
	
	
	public static boolean dateValid(String dateDE, String dateARR) throws ParseException
	{
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd"); 

		java.util.Date dateDe = formatter.parse(dateDE);
		java.util.Date dateArr = formatter.parse(dateARR);
		if ( ( dateDe.compareTo(dateArr) > 0) || ( dateDe.compareTo(dateArr) == 0) )
			return false;
	     	
		return true;
	}
	
	public static Date today() {
		Date today = new Date();
		return today;
	}
	
}
