
public class CarSales extends CarClass {
	public CarSales() {
		super();
		
	}
	
	public CarSales(int carID,String carType, String carDescript, String carOwner){
		super(carID, carType, carDescript, carOwner);
	}

	public void saleInventory(){
		//another assumption of sales being implemented by a database
	}

}
