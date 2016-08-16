package com.learn.gyl.xutilssample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.androidadvance.topsnackbar.TSnackbar;
import com.daimajia.swipe.SwipeLayout;

import org.xutils.common.Callback;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.weixin_viewpager)
    private ViewPager viewPager;
    @ViewInject(R.id.tab_weixin)
    private LinearLayout mWeixin;
    @ViewInject(R.id.tab_tongxunlu)
    private LinearLayout mTongxunlu;
    @ViewInject(R.id.tab_faxian)
    private LinearLayout mFaxian;
    @ViewInject(R.id.tab_wo)
    private LinearLayout mWo;
    private PagerAdapter pagerAdapter;
    private List<View> list;
    private LayoutInflater layoutInflater;
    @ViewInject(R.id.swipe)
    private SwipeLayout swipeLayout;
    @ViewInject(R.id.rightcehua)
    private ListView list2;
    private ArrayAdapter adapter;
    private String[] data = new String[]{"41554","454"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        init();
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,data);
        list2.setAdapter(adapter);
//        viewPager.setAdapter(pagerAdapter);
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                TSnackbar.make(viewPager,position+"",Snackbar.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
    }

    private void init() {
        layoutInflater = LayoutInflater.from(this);
        list = new ArrayList<View>();
        View view1 = layoutInflater.inflate(R.layout.viewpager1_layout,null);
        View view2 = layoutInflater.inflate(R.layout.viewpager2_layout,null);
        View view3 = layoutInflater.inflate(R.layout.viewpager3_layout,null);
        list.add(view1);
        list.add(view2);
        list.add(view3);
        pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(list.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(list.get(position));
                return list.get(position);
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }
        };
    }
//    @Event(value = {R.id.chat,R.id.tongxunlu,R.id.faxian,R.id.wo})
//    private void weixinOnclick(View view){
//        switch (view.getId()){
//            case R.id.chat:
//                Toast.makeText(this,"chat",Toast.LENGTH_SHORT).show();
//                radioButton.setBackgroundResource(R.drawable.al_);
//                break;
//            case R.id.tongxunlu:Toast.makeText(this,"tongxunlu",Toast.LENGTH_SHORT).show();
//                break;
//        }
//    }
}
