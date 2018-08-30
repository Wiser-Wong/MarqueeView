package com.wiser.marquee;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

/**
 * @author Wiser
 * 
 *         跑马灯适配器
 * @param <T>
 *            View 根布局
 * @param <V>
 */
public abstract class MarqueeAdapter<V> extends MarqueeFactory<V> {

	private LayoutInflater mInflater;

	protected MarqueeAdapter(Context mContext) {
		mInflater = LayoutInflater.from(mContext);
	}

	protected View inflate(int layoutId) {
		return mInflater.inflate(layoutId, null, false);
	}

	protected abstract View createItemView(V data);

	@Override protected View generateMarqueeItemView(V data) {
		return createItemView(data);
	}
}