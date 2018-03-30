
public class CarService extends CarClass{
	
	
	public CarService() {
		super();
		
	}
	
	public CarService(int carID,String carType, String carDescript, String carOwner){
		super(carID, carType, carDescript, carOwner);
	}
	
	public String removeCarInService (int carID){
	return "car " + carID + " is no longer in service";
	
	}
	
	
	public String getCarInService (int carID){
		return "car " + carID + "is in service";
		
	}


}
