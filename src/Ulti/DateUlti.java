package Ulti;

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
	
	
}
