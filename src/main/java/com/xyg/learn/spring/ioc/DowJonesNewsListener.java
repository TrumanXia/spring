package com.xyg.learn.spring.ioc;

import org.springframework.stereotype.Component;

/**
 * @author 97994
 * @since 2020-07-15
 */
@Component
public class DowJonesNewsListener implements IFXNewsListener {
	@Override
	public String[] getAvailableNewsIds() {
		return new String[0];
	}

	@Override
	public FXNewsBean getNewsByPK(String newsId) {
		return null;
	}

	@Override
	public void postProcessIfNecessary(String newsId) {

	}
}
