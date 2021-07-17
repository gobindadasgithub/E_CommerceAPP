package com.example.e_commerce;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

public class OnBoardingActivity extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotslayout;
    SliderAadpter sliderAadpter;
    TextView [] dots;
    Button btn;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //statusber hide
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_on_boarding);
      //tollber hide
        getSupportActionBar().hide();

        viewPager=findViewById(R.id.slider);
        dotslayout=findViewById(R.id.dots);
        sliderAadpter=new SliderAadpter(this);

        viewPager.setAdapter(sliderAadpter);
        btn=findViewById(R.id.get_started_btn);
        viewPager.addOnPageChangeListener(changeListener);

     addDosts(0);



    }

    private void addDosts(int postion){
        dots=new TextView[3];
        dotslayout.removeAllViews();
        for (int i=0;  i< dots.length; i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dotslayout.addView((dots[i]));

        }
        if (dots.length>0){
           dots[postion].setTextColor(getResources().getColor(R.color.pink));

       }

    }
    ViewPager.OnPageChangeListener changeListener=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDosts(0);{
                if (position==0){
               btn.setVisibility(View.INVISIBLE);

                }
                else if(position==1){
                    btn.setVisibility(View.INVISIBLE);

                }
                else{
                    animation= AnimationUtils.loadAnimation(OnBoardingActivity.this,R.anim.slide_animation);
                    btn.setAnimation(animation);
                    btn.setVisibility(View.VISIBLE);
                }
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };




}