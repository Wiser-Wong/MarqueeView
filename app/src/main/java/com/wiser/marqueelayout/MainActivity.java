package com.wiser.marqueelayout;

import java.util.ArrayList;
import java.util.List;

import com.wiser.marquee.MarqueeAdapter;
import com.wiser.marquee.MarqueeView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	MarqueeView<String> marqueeView;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		marqueeView = findViewById(R.id.marquee);

		initMarquee();

		findViewById(R.id.ll_layout).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,SecondActivity.class));
			}
		});

	}

	private void initMarquee() {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add("跑马灯" + i);
		}
		marqueeView.setMarquee(list, new MarqueeAdapter<String>(this) {
			@Override
			protected View createItemView(String data) {
				View view = inflate(R.layout.item);
				TextView tvMarquee = view.findViewById(R.id.tv_marquee);
				tvMarquee.setText(data);
				return view;
			}
		}).setMarqueeAnim(R.anim.in_bottom,R.anim.out_top).setTimeInterval(2000).start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		marqueeView.stop();
	}

	@Override
	protected void onResume() {
		super.onResume();
		marqueeView.start();
	}
}
