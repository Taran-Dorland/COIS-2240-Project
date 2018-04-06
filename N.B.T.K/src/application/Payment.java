package application;



import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * 
 */
public class Payment {

	static public int paymentCount = 0;

	public int Card_No;
	public String paymentDate = "";
	public int payment_Type;
	public String billingAddress;
	public int cvv;
	public String city;
	public String state;
	public String province;
	public int paymentID;
	public double amount;

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public int getCard_No() {
		return Card_No;
	}

	public void setCard_No(int Card_No) {
		this.Card_No = Card_No;
	}

	public int getPayment_Type() {
		return payment_Type;
	}

	public void setPayment_Type(int payment_Type) {
		this.payment_Type = payment_Type;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public int getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentDetails() {
		String str = "";
		switch (getPayment_Type()) {
		case 1:
			str = "Thanks! your credit card with number " + getCard_No() + "have been deducted with: " + getAmount() + " on " + getPaymentDate();
			break;
		case 2:
			str = "Thanks! your debit card with number " + getCard_No() + "have been deducted with: " + getAmount() + " on " + getPaymentDate();
			break;
		default:
			str = "Thanks we recieved: " + getAmount() + " from you on " + getPaymentDate();
			break;
		}
		return str;
	}

	public void editPayment() {
		// get the id of the payment from the user then search it in the database and edit the required one
	}

	public boolean searchPayment() {
		// get the id of the payment to search
		// search the database and return true or false accordingly

		// if payment not found then return false
		return false;
	}

	@Override
	public String toString() {
		String str;
		System.out.println("\n\n///////////////////////////////Tranasction Statements//////////////////////////////");
		switch (getPayment_Type()) {
		case 1:
			str = "Card No : " + getCard_No() + "\n"
					+ "Date/Time : " + getPaymentDate() + "\n"
					+ "Amount : " + getAmount() + "\n"
					+ "Billing Address " + getBillingAddress() + "\n";
			break;
		case 2:
			str = "Card No : " + getCard_No() + "\n"
					+ "Date/Time : " + getPaymentDate() + "\n"
					+ "Amount : " + getAmount() + "\n"
					+ "Billing Address " + getBillingAddress() + "\n";
			break;
		default:
			str = "Payment Through Cash"
					+ "Date/Time : " + getPaymentDate() + "\n"
					+ "Amount : " + getAmount() + "\n";

			break;
		}
		return str;
	}

}

