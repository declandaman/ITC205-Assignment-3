package hotel.credit;

public class CreditAuthorizer {
	
	private static CreditAuthorizer self;
	
	public static synchronized CreditAuthorizer getInstance() {
		if (self == null) {
			self = new CreditAuthorizer();
		}
		return self;
		
	}


	public boolean authorize(CreditCard card, double amount) {
		if (card.getNumber() <= 5) {
			return true;
		}
		return false;
	}

}
