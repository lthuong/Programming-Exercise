package Ulti;

public class Converter {

	public Converter() {
		
	}
	public String convertDateToString(String date) {
		return date.substring(6,8)+"-"+
    			date.subSequence(4, 6)+"-"+date.subSequence(0,4);
	}
	
	public float convertTimeToFloatTime(String time) {
		String[] times = time.split(":");
		return Float.parseFloat(times[0]) + Float.parseFloat(times[1])/60;
	}
	
	public String convertDateToDateWithoutDash(String dateWithDash) {
		String[] dates = dateWithDash.split("-");
		return dates[0]+dates[1]+dates[2];
	}
	
	public String convertTimeToString(float time) {
		String new_time = new String();
		
		return new_time;
	}
}
