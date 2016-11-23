package com.org.iii.will25;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView apple;
    private ObjectAnimator animator1, animator2, animator3, animator4, animator5;
    private View container, drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = findViewById(R.id.activity_main);
        apple = (ImageView)findViewById(R.id.apple);
        drawer = findViewById(R.id.drawer);
        drawer.setX(-200f);
    }

    public void test1(View v){
        animator1 = ObjectAnimator.ofFloat(apple,"x", 0, 300);
        animator1.setDuration(2000);
        animator1.setRepeatCount(0);
        animator1.start();
    }

    public void test2(View v){
        animator1 = ObjectAnimator.ofFloat(apple,"y", 0, 800);
        animator1.setDuration(2000);
        animator1.setRepeatCount(0);
        animator1.start();
    }

    public void test3(View v){
        animator1 = ObjectAnimator.ofFloat(apple,"x", 0, 300);
        animator2 = ObjectAnimator.ofFloat(apple,"y", 0, 800);
        animator3 = ObjectAnimator.ofFloat(apple,"alpha", 0f, 1f);
        animator4 = ObjectAnimator.ofFloat(apple,"rotationX", 0f, 1f);
        animator5 = ObjectAnimator.ofFloat(apple,"rotationY", 0f,360f,0f,360f);

        AnimatorSet set = new AnimatorSet();
//        set.playSequentially(animator1, animator2, animator3, animator4, animator5);
        set.playTogether(animator1, animator2, animator3, animator4, animator5);
        set.setDuration(3*1000);
        set.start();
    }

    public void test4(View v){
        animator1 = ObjectAnimator.ofFloat(drawer, "x", -200, 0);
        animator2 = ObjectAnimator.ofFloat(drawer, "alpha", 0, 1f);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(animator1, animator2);
        set.setDuration(4*1000);
        set.start();
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.v("will", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Log.v("will", "onResume()");
        Log.v("will", "onResume" + container.getWidth() + " x " + container.getHeight());
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.v("will", "onWindowFocusChanged()");
        if (hasFocus) {
            Log.v("will", container.getWidth() + " x " + container.getHeight());
        }else{
            Log.v("will", "onWindowFocusChanged():false");
        }
    }
}
