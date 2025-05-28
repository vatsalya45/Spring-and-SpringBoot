package com.vatsalya.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hotel")
public class Hotel {
	@Value("6969") // Direct value injection
	private Integer hotelId;
	@Value("${hotel.name}")
	private String hotelName;
	@Value("${hotel.addrs}")
	private String hotelAddrs;
	@Value("${hotel.mobNum}")
	private Long mobileNumber;
	@Value("${customer.name}")
	private String custName;
	/*
	 * @Value("#{${menu.samosaRate}+${menu.pohaRate}}")//SpEL for arithmetic
	 * operation
	 * 
	 * @Value("#{T(java.lang.Float).parseFloat('${menu.samosaRate}') + T(java.lang.Float).parseFloat('${menu.pohaRate}')}"
	 * ) private Float billAmount;
	 */
	@Value("#{menup.samosaPrice+menup.pohaPrice}")
	private Float billAmount;
	// os.name and user.name are the fixed system property key --> injecting system
	// properties
	@Value("${os.name}")
	private String osName;
	@Value("${user.name}")
	private String windowsName;
	// Path is the fixed environment variable name --> injecting environment
	// variable value
	@Value("${Path}")
	private String pathData;

	// toString (alter + shift + s, s)
	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", hotelName=" + hotelName + ", hotelAddrs=" + hotelAddrs
				+ ", mobileNumber=" + mobileNumber + ", custName=" + custName + ", billAmount=" + billAmount
				+ ", osName=" + osName + ", windowsName=" + windowsName + ", pathData=" + pathData + "]";
	}

}
