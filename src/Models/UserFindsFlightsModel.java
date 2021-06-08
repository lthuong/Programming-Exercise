package Models;

public class UserFindsFlightsModel {
	private int owDate;
	private int reDate;
	private String dep;
	private String arr;
	private int user_id;
	
	public UserFindsFlightsModel(int dateinput,String depinput,String arrinput,int id) {
		this.user_id = id;
		this.owDate = dateinput;
		this.dep = depinput;
		this.arr = arrinput;
	}
	
	public UserFindsFlightsModel(int owdateinput,int returndateinput,String depinput,String arrinput,int id) {
		this.owDate = owdateinput;
		this.reDate = returndateinput;
		this.dep = depinput;
		this.arr = arrinput;
		this.user_id = id;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public int getOWDate() {
		return owDate;
	}

	public void setDate(int date) {
		owDate = date;
	}

	public String getDep() {
		return dep;
	}

	public int getReDate() {
		return reDate;
	}

	public void setReDate(int reDate) {
		this.reDate = reDate;
	}

	public void setDep(String dep) {
		this.dep = dep;
	}

	public String getArr() {
		return arr;
	}

	public void setArr(String arr) {
		this.arr = arr;
	}
	
	
}
