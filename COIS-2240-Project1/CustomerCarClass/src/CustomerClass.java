
public class CustomerClass {

	private String customerName;
	private String customerPhone;
	private String cusAddress;
	
	public CustomerClass(){
		this.customerName = null;
		this.customerPhone = null;
		this.cusAddress = null;
	}
	public CustomerClass(String customerName, String customerPhone, String cusAddress){
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.cusAddress = cusAddress;
	}
	//CUSTOMER NAME//  (if it really is a bother, we can make it all a method)
	public void setCustomerClass(String customerName){
		this.customerName = customerName;
	}
	public void removeCustomerClass(String customerName){
		this.customerName = null;
	}
	public String getCustomerClass(){
		return customerName;
	}
	//CUSTOMER PHONE//
	public void setCustomerPhone(String customerPhone){
		this.customerPhone = customerPhone;
	}
	public void removeCustomerPhone(String customerPhone){
		this.customerPhone = null;
	}
	public String getCustomerPhone(){
		return customerPhone;
	}
	//CUSTOMER ADDRESS//   
	public void setCustomerAddress(String cusAddress){
		this.cusAddress = cusAddress;
	}
	public void removeCustomerAddres(String cusAddress){
		this.cusAddress = null;
	}
	public String getCustomerAddres(){
		return cusAddress;
	}
}
