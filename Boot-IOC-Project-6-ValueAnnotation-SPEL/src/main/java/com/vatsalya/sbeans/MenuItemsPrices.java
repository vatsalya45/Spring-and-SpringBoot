package com.vatsalya.sbeans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component("menup")
@Data
public class MenuItemsPrices {

	@Value("${menu.samosaRate}")
	private float samosaPrice;
	
	@Value("${menu.jalebiRate}")
	private float jalebiPrice;
	
	@Value("${menu.pohaRate}")
	private float pohaPrice;
	
	@Value("${menu.dosaRate}")
	private float dosaPrice;
}
