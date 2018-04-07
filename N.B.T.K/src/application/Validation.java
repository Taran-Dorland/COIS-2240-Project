package application;

import javafx.scene.control.TextField;

public class Validation extends Controller {

	public Validation() {
		System.out.println("Validation loaded");
	}


	public boolean isPhoneNumberValid(String bookingPhone) {
		char[] UserId = bookingPhone.toCharArray();

		// check if user id is of length 10
		if (UserId.length != 10) {
			return false;
		}

		for (char i : UserId) {
			if (!(i >= 48 && i <= 57)) { // Check if all the character in user name are nnumericals.
				return false;
			}
		}

		return true;
	}

	public boolean isPostalCodeValid(String postalCode) {
		char[] pCodeArray = postalCode.toCharArray();

		if (pCodeArray.length != 6) {
			return false;
		}

		return true;
	}

	public boolean isNotEmpty(String any) {
		char[] charArray = any.toCharArray();

		if (charArray.length == 0) {
			return false;
		}

		return true;
	}

	public static boolean isInt(TextField input, String message ) {

		try {
			//int ID = Integer.parseInt(message);
			return true;
		} catch (NumberFormatException e) {

			return false;
		}

	}

	public boolean isUserIdValid(String custID) {
		char[] UserId = custID.toCharArray();
		// check if user id is of length 10
		if (UserId.length != 10) {
			return false;
		} else {
			for (char i : UserId) {
				if (!(i >= 48 && i <= 57)) // Check if all the character in user name are nnumericals.
				{
					return false;
				}
			}
		}
		return true;
	}

	public boolean isDateValid(String bookingDate ) {
		// check if the length of dat is 10 (dd/mm/yyyy)
		if (bookingDate.length() != 10) {
			return false;
		} else {
			String[] div = bookingDate.split("/");
			if ((div.length) == 3) {
				try {
					int date = Integer.parseInt(div[0]);
					int month = Integer.parseInt(div[1]);
					// int year = Integer.parseInt(div[2]);
					if (!(date >= 1 && date <= 31) || !(month >= 1 && month <= 12)) {
						return false;
					}
				} catch (NumberFormatException e) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}

	public boolean isUserInputValid(String userInput) {
		char[] input = userInput.toCharArray();

		for (char i : input) {
			if (!(i >= 48 && i <= 57)) {
				return false;
			}
		}
		return true;
	}

	public boolean isValidEmailAddress(String emailAddress) {

		String[] email = emailAddress.split(""); // get individual characters of email address;
		if (email.length <= 5) { // check if length of email address is less than 3
			return false; // if lenght is less  than three return false
		}
		// checking if "@" is present
		boolean check = false;
		for (String i : email) {
			if (i.equals("@")) {
				check = true;
			}
		}
		if (!check) {
			return false;
		}
		//check is starting and ending cahracters of email is "." or "@"
		if ((email[0].equals("@")) || (email[email.length - 1].equals("@")) || (email[0].equals(".")) || email[email.length - 1].equals(".")) {
			// System.out.println("1");
			return false; // if engine characters is "." or "@" return false
		}
		// get the last four characters of the email address.
		String last4char = emailAddress.substring(email.length - 4);
		// System.out.println(last4char);
		if (!last4char.equals(".com")) { // check if last foir characters of email address is ".com"
			//System.out.println("2");
			return false; // if not return false;
		}
		// check if the  fouth last character of email address is @ examole adawe@.com
		if (email[email.length - 5].equals("@")) {
			//System.out.println("3");
			return false;
		}

		return true;  // if all conditions are satisfied return true;
	}

}
