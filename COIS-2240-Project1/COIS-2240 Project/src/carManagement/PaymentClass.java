
public class PaymentClass extends CustomerClass {
	private int paymentID; //maybe should be a string, idk
	private String paymentType; //is this really needed?
	private String paymentDescription; //as well as this, not really needed
	private String paymentDate; //
	//NO ARG CONSTRUCTOR
	public PaymentClass() {
		// TODO Auto-generated constructor stub
		super();
		this.paymentDate = null;
		this.paymentDescription = null;
		this.paymentID = 0;
		this.paymentType= null;

	}
	// ARG CONSTRUCTOR
	public PaymentClass(String customerName, String customerPhone, String cusAddress, String paymentDate, String paymentDescription, int paymentID, String paymentType) {
		super(customerName, customerPhone, cusAddress);
		this.paymentDate = paymentDate;
		this.paymentDescription = paymentDescription;
		this.paymentID = paymentID;
		this.paymentType= paymentType;
	}
	//BOOKING DATE
	public void setPaymentDate(String paymentDate){
		this.paymentDate = paymentDate;	
	}
	public void removePaymentDate(String PaymentDate){
		this.paymentDate = null;
	}
	public String getPaymentDate(){
		return paymentDate;
	}

	//BOOKING DESCRIPTION
	public void setPaymentDes( String paymentDescription){
		this.paymentDescription = paymentDescription;	
	}
	public void removePaymentDes(String bookingDescription){
		this.paymentDescription = null;
	}
	public String getPaymentDes(){
		return paymentDescription;
	}

	//BOOKING ID
	public void setBookingID( int paymentID){
		this.paymentID = paymentID;	
	}
	public void removePaymentID(int paymentID){
		this.paymentID = 0;
	}
	public String getPaymentID(){
		return paymentDate;
	}

	//BOOKING TYPE
	public void setPaymentType(String paymentType){
		this.paymentType = paymentType;	
	}
	public void removeBookingType(String bookingDate){
		this.paymentType = null;
	}
	public String getBookingType(){
		return paymentType;
	}

	//SEARCH PAYMENT
	public void searchPayment(){
		//I assume there would be another database application
	}
}
