package com.wiser.marqueelayout;

import java.util.ArrayList;
import java.util.List;

import com.wiser.marquee.MarqueeAdapter;
import com.wiser.marquee.MarqueeView;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends Activity {

    MarqueeView<String> marqueeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.ll_layout).setBackgroundColor(Color.YELLOW);

        marqueeView = findViewById(R.id.marquee);

        initMarquee();

    }

    private void initMarquee() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("跑马灯" + i);
        }
        marqueeView.setMarquee(list, new MarqueeAdapter<String>(this) {
            @Override
            protected View createItemView(String data) {
                View     view      = inflate(R.layout.item);
                TextView tvMarquee = view.findViewById(R.id.tv_marquee);
                tvMarquee.setText(data);
                return view;
            }
        }).setMarqueeAnim(R.anim.in_bottom, R.anim.out_top).setTimeInterval(3000).start();
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
