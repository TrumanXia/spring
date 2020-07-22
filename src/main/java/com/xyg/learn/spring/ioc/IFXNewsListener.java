package com.xyg.learn.spring.ioc;

/**
 * @author 97994
 * @since 2020-07-15
 */
public interface IFXNewsListener {
	String[] getAvailableNewsIds();

	FXNewsBean getNewsByPK(String newsId);

	void postProcessIfNecessary(String newsId);
}
