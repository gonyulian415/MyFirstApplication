package com.learn.gyl.projectg1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MainActivity extends BaseActivity {
    Handler handler = new Handler();
    @ViewInject(R.id.weather_bg2)
    private ImageView imageView;
    @ViewInject(R.id.testButton1)
    private AppCompatButton testButton1;
    @ViewInject(R.id.testButton2)
    private AppCompatButton testButton2;
    @ViewInject(R.id.testTextView)
    private TextView textView;
    private int i = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frame_test_layout);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        x.view().inject(this);
        imageView.setAlpha(100);

    }

    @Event(value = {R.id.testButton1,R.id.testButton2})
    private void changeAlpha(View v) {
        switch (v.getId()){
            case R.id.testButton1:i++;
                imageView.setAlpha(i);
                textView.setText(i + "");
                break;
            case R.id.testButton2:i--;
                imageView.setAlpha(i);
                textView.setText(i + "");
                break;
        }
    }
}
