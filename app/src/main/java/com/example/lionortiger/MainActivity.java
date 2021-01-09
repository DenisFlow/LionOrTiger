package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
      enum Player {
        one, two
    }

    Player current = Player.one;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void onClickPush(View View){
        ImageView tappedImageView = (ImageView) View;
        tappedImageView.setTranslationX(-2000);
        if (current == Player.one) {
            tappedImageView.setImageResource(R.drawable.lepard);
            current = Player.two;
        }else {
            tappedImageView.setImageResource(R.drawable.lion);
            current = Player.one;
        }

        tappedImageView.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);

    }

}