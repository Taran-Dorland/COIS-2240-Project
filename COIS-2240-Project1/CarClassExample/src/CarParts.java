
public class CarParts extends CarClass { //if car class does implement customer, we could add the customer ID
	private String carParts;

	public CarParts() {
		super();
		this.carParts = null;
	}
	
	public CarParts(int carID,String carType, String carDescript, String carOwner, String carParts ){
		super(carID, carType, carDescript, carOwner);
		this.carParts = carParts;
	}
	
	public void partInventory (int carParts){
		//assume there is a database application here
	}




}
