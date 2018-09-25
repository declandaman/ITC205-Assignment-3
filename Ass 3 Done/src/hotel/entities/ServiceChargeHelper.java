package hotel.entities;

public class ServiceChargeHelper {

	private static ServiceChargeHelper self;
	
	public static synchronized ServiceChargeHelper getInstance() {
		if (self == null) {
			self = new ServiceChargeHelper();
		}
		return self;
		
	}


	public ServiceCharge makeServiceCharge(ServiceType service, double cost) {
		ServiceCharge serviceCharge = new ServiceCharge(service, cost);
		return serviceCharge;
	}

}
