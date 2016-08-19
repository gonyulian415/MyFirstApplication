package com.learn.gyl.projectg1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.learn.gyl.projectg1.bean.Province;
import com.learn.gyl.projectg1.db.CityDB;
import com.learn.gyl.projectg1.db.DatabaseOpenHelper;
import com.learn.gyl.projectg1.db.ProvinceDB;
import com.learn.gyl.projectg1.model.ProvinceXmlParse;

import org.xutils.DbManager;
import org.xutils.x;

import java.util.List;


/**
 * Created by admin on 2016/7/29.
 */

public class WelcomeActivity extends BaseActivity {
    private AppCompatImageView imageView;
    private ProvinceDB provinceDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.welcome_layout);
        imageView = (AppCompatImageView) findViewById(R.id.welcome_image);
        provinceDB = new ProvinceDB();
        welcomeImage();
    }
    private void welcomeImage(){
        imageView.setImageResource(R.drawable.wk);
        final ScaleAnimation animation = new ScaleAnimation(1.0f,1.2f,1.0f,1.2f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        animation.setFillAfter(true);
        animation.setDuration(3000);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                //查询数据库查找省份信息,有就从数据库读,没有就读xml
                if (provinceDB.loadProvinces().isEmpty()) {
                    ProvinceXmlParse parse = new ProvinceXmlParse();
                    parse.parse(this.getClass().getClassLoader().getResourceAsStream("assets/" + "Provinces.xml"));
                    Log.d("xyz","read from xml");
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.startAnimation(animation);
    }
}
