package main.java.com.outsource.platform.hiring.retailStore.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * User type enum values
 * @author manisha1875
 *
 */
public enum UserType {

	EMPLOYEE("employee"),
	AFFILIATE("affiliate"),
	CUSTOMER("customer");
	
	private String usertype;

	UserType(String userType) {
		this.usertype = userType;
	}
	
	public String getUsertype() {
		return usertype;
	}

	public static double getDiscount(UserType userType, Date registeredOn) {
		if(userType.equals(EMPLOYEE)) {
			return 0.30;
		} else if(userType.equals(AFFILIATE)) {
			return 0.10;
		} else if(userType.equals(CUSTOMER)) {
			LocalDate date = registeredOn.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate now = Calendar.getInstance().getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			 long numberOfYears = ChronoUnit.YEARS.between(date, now); 
		    if(numberOfYears >= 2) {
		    	return 0.05;
		    } else {
		    	return 0.0;
		    }
		} else {
			return 0.0;
		}
	}
}
