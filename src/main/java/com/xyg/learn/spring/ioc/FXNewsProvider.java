package com.xyg.learn.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author 97994
 * @since 2020-07-15
 */
@Component
public class FXNewsProvider {
	@Autowired
	private IFXNewsListener newsListener;
	@Autowired
	private IFXNewsPersister newPersistener;

	public FXNewsProvider(IFXNewsListener newsListener, IFXNewsPersister newPersistener) {
		this.newsListener = newsListener;
		this.newPersistener = newPersistener;
	}

	public IFXNewsListener getNewsListener() {
		return newsListener;
	}
	public void setNewsListener(IFXNewsListener newsListener) {
		this.newsListener = newsListener;
	}
	public IFXNewsPersister getNewPersistener() {
		return newPersistener;
	}
	public void setNewPersistener(IFXNewsPersister newPersistener) {
		this.newPersistener = newPersistener;
	}

	public void getAndPersistNews() {
		String[] newsIds = newsListener.getAvailableNewsIds();
		if (newsIds.length == 0) {
			return;
		}
		for (String newsId : newsIds) {
			FXNewsBean newsBean = newsListener.getNewsByPK(newsId);
			newPersistener.persistNews(newsBean);
			newsListener.postProcessIfNecessary(newsId);
		}
	}
}
