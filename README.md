# MarqueeView
## 跑马灯效果
![images](https://github.com/Wiser-Wong/MarqueeView/blob/master/images/marquee.gif)

### 使用方法
    marqueeView.setMarquee(list, new MarqueeAdapter<String>(this) {
			@Override
			protected View createItemView(String data) {
				View view = inflate(R.layout.item);
				TextView tvMarquee = view.findViewById(R.id.tv_marquee);
				tvMarquee.setText(data);
				return view;
			}
		}).setMarqueeAnim(R.anim.in_bottom,R.anim.out_top).setTimeInterval(3000).isOneItemNoScroll(false).start();

### 配置
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	
	dependencies {
	        implementation 'com.github.Wiser-Wong:MarqueeView:1.2.0'
	}
