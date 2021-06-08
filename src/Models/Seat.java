package Models;

/*
 * @author: Thien Huong Le
 */

public class Seat {
	private int seatId;
	private String seatNum;
	private int flightId;
	private int booked;
	private float seatPrice;
	private String seatType;
	
	public Seat(int sID,String num, int flightId, int booked, float price, String type,int b) {
		this.seatId = sID;
		this.seatNum = num;
		this.flightId = flightId;
		this.booked = booked;
		this.seatPrice = price;
		this.seatType = type;
		this.booked = b;
	}
	
	public Seat(int id) {
		this.seatId = id;
	}
	
	public Seat() {};
	
	
	public float getSeatPrice() {
		return seatPrice;
	}


	public void setSeatPrice(float seatPrice) {
		this.seatPrice = seatPrice;
	}


	public int getSeatId() {
		return seatId;
	}

	public void setSeatId(int seatId) {
		this.seatId = seatId;
	}
	

	public String getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}

	@Override
	public String toString() {
		return "Seat [seatNum=" + seatNum + ", flightId=" + flightId + ", booked=" + booked + "]";
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int isBooked() {
		return booked;
	}

	public void setState(int state) {
		this.booked = state;
	}


	public String getSeatType() {
		return seatType;
	}


	public void setSeatType(String seatType) {
		this.seatType = seatType;
	}

	
}
