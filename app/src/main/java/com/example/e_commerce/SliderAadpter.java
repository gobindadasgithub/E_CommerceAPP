package com.example.e_commerce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import org.jetbrains.annotations.NotNull;

public class SliderAadpter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;


    public  SliderAadpter(Context context){
        this.context=context;


    }

    int imagesarray[]={

            R.drawable.onboardscreen1,
            R.drawable.onboardscreen2,
            R.drawable.onboardscreen3

};

    int handingarray[]={



    };

    int descreptionarray[]={



    };

    @Override
    public int getCount() {
        return handingarray.length;
    }


    @Override
    public boolean isViewFromObject(@NonNull @NotNull View view, @NonNull @NotNull Object object) {
        return  view== (ConstraintLayout) object;
    }

    @NonNull
    @NotNull
    @Override
    public Object instantiateItem(@NonNull @NotNull ViewGroup container, int position) {

        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slideing_layout,container,false);


        ImageView imageView=view.findViewById(R.id.slider_img);
        TextView heading=view.findViewById(R.id.heading);
        TextView descreoition=view.findViewById(R.id.description);

        imageView.setImageResource(imagesarray[position]);
        heading.setText(handingarray[position]);
        descreoition.setText(descreptionarray[position]);
        container.addView(view);

        return view;

    }

    @Override
    public void destroyItem(@NonNull @NotNull ViewGroup container, int position, @NonNull @NotNull Object object) {

        container.removeView((ConstraintLayout)object);

        super.destroyItem(container, position, object);
    }
}
