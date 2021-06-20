package Ulti;

public class Converter {

	public Converter() {
		
	}
	
	public float convertTimeToFloatTime(String time) {
		String[] times = time.split(":");
		return Float.parseFloat(times[0]) + Float.parseFloat(times[1])/60;
	}
	public String convertDateToDateWithoutDash(String dateWithDash) {
		String[] dates = dateWithDash.split("-");
		return dates[0]+dates[1]+dates[2];
	}
	
}
