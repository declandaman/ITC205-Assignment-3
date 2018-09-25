package hotel.credit;

public class CreditCard{
	
	CreditCardType type;
	int number;
	int ccv;
	
	
	public CreditCard(CreditCardType type, int number, int ccv) {
		this.type = type;
		this.number = number;
		this.ccv = ccv;
	}

	public CreditCardType getType() {
		return type;
	}

	public int getNumber() {
		return number;
	}

	public int getCcv() {
		return ccv;
	}

	public String getVendor() {
		return type.getVendor();
	}

}
