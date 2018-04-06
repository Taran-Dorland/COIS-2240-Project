
public class CarClass { //car class should probable implement customer
 private int carID;
 private String carType;
 private String carDescript;
 private String carOwner;
 //NO ARG COSTRUCTOR
 public CarClass(){
	 this.carID = 0;
	 this.carType = null;
	 this.carDescript = null;
	 this.carOwner = null;
 }
 //ARG CONSTRUCTOR
 public CarClass( int carID,String carType, String carDescript, String carOwner){
	 this.carID = carID;
	 this.carType = carType;
	 this.carDescript = carDescript;
	 this.carOwner = carOwner; 
 }
 
 //GETTERS and SETTERS//  //I don't know if we should have full on methods for adding and removing cars or not
 public void setCarID (int carID){
	 this.carID = carID;
 }
 public void removeCarID (int carID){
	 this.carID = 0;
 }
 public int getCarID(){
	 return carID;
 }
 //CAR TYPE
 public void setCarType (String carType){
	 this.carType = carType;
 }
 public void removeCarType (String carType){ 
	 this.carType = null;
 }
 public String getCarType (){
	return carType;
//CAR DESCRIPTION
 }
 public void setCarDescript (String carDescript){
	 this.carDescript = carDescript;
 }
 public void removeCarDeposit (String carDescript){
	 this.carDescript = null;
 }
 public String getCarDescript (){
	return carDescript;

//CAR OWNER 
 }
 public void setCarOwner (String carOwner){
	 this.carOwner = carOwner;
 }
 public void removeCarOwner (String carOwner){
	 this.carOwner = null;
 }
 public String getCarOwner (){
	return carOwner;
	 
 }
 
}
