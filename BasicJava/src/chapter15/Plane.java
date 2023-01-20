package chapter15;

public class Plane {
	String manufacturer;
	String model;
	int maxNumberOfPassengers;
	static int numberOfPlanes;
	
	public Plane() {
		numberOfPlanes++;
	}
	public Plane(String manufacturer, String model, int maxNumberOfPassengers) {
		numberOfPlanes++;
		this.manufacturer = manufacturer;
		this.model = model;
		this.maxNumberOfPassengers = maxNumberOfPassengers;
	}
	
	public String getManufacturer(){
		return manufacturer;
	}
	public void setManufacturer(String manufacturer){
		this.manufacturer = manufacturer;
	}
	public String getModel(){
		return model;
	}
	public void setModel(String model){
		this.model = model;
	}
	public int getMaxNumberOfPassengers(){
		return maxNumberOfPassengers;
	}
	public void setMaxNumberOfPassengers(int maxNumberOfPassengers){
		if(maxNumberOfPassengers < 0) {
			this.maxNumberOfPassengers = 0;
		}else {
		this.maxNumberOfPassengers = maxNumberOfPassengers;
		}
	}
	public static int getNumberOfPlanes(){
		return numberOfPlanes;
	}
	
	
}
