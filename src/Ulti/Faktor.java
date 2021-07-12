package Ulti;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Faktor {
	public float factor(float flight_dep, String carrier, int flightday)
	{
		float x =1;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat day = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat time = new SimpleDateFormat("HH");
		SimpleDateFormat month = new SimpleDateFormat("MM");
		SimpleDateFormat dayflight = new SimpleDateFormat("dd");
		@SuppressWarnings("static-access")
		char[] a =toString().valueOf(flightday).toCharArray();
		System.out.println(flightday);
		StringBuilder Input1 = new StringBuilder().append(a[4]).append(a[5]);
		int InputMonth = Integer.parseInt(String.valueOf(Input1));
		System.out.println(InputMonth);
		StringBuilder Input2 = new StringBuilder().append(a[6]).append(a[7]);
		int InputDay=Integer.parseInt(String.valueOf(Input2));
		System.out.println(InputDay);
		//carrier
		if(carrier.equalsIgnoreCase("Lufthansa"))
		{
			x=(float) (x+0.2);
		}
		//flight in day
		if(Integer.parseInt(day.format(calendar.getTime()))==flightday)
		{
			x=(float) (x-0.3);
			if(Float.valueOf(time.format(calendar.getTime()))==flight_dep-3)
			{
				x=(float) (x-0.5);
			}
			else if (Float.valueOf(time.format(calendar.getTime()))==flight_dep-4)
			{
				x=(float) (x-0.4);
			}
			else
			{
				x=(float) (x-0.2);
			}
		}
		//month
		if (Integer.parseInt(month.format(calendar.getTime()))==InputMonth-1)
		{
			x=(float) (x-0.1);
		}
		else if (Integer.parseInt(month.format(calendar.getTime()))==InputMonth-2)
		{
			x=(float) (x-0.2);
		}
		else if(Integer.parseInt(month.format(calendar.getTime()))<=InputMonth-3)
		{
			x=(float) (x-0.3);
		} 
		//day
		if(Integer.parseInt(day.format(calendar.getTime()))==InputMonth && Integer.parseInt(dayflight.format(calendar.getTime())) == InputDay-1)
		{
			x= (float) (x-0.3);
		}
		else if (Integer.parseInt(day.format(calendar.getTime()))==InputMonth && Integer.parseInt(dayflight.format(calendar.getTime())) <= InputDay-3)
		{
			x= (float) (x-0.2);
		}
		return x;
	}
}
