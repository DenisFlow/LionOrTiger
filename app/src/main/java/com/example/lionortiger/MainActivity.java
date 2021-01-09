package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    enum Player {
        one, two
    }

    ImageView im0, im1, im2, im3, im4, im5, im6, im7, im8;


    Player current = Player.one;
    int[] table = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[][] win = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 4, 8}, {2, 4, 6}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}};
    boolean global_b_end_of_game = false;
    int resultPlayer = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        im0 = findViewById(R.id.imageView1);
        im1 = findViewById(R.id.imageView2);
        im2 = findViewById(R.id.imageView3);
        im3 = findViewById(R.id.imageView4);
        im4 = findViewById(R.id.imageView5);
        im5 = findViewById(R.id.imageView6);
        im6 = findViewById(R.id.imageView7);
        im7 = findViewById(R.id.imageView8);
        im8 = findViewById(R.id.imageView9);


    }

    public void onClickPush(View View) {
        if (!global_b_end_of_game) {
            ImageView tappedImageView = (ImageView) View;

            tappedImageView.setTranslationX(-2000);
            if (current == Player.one) {
                tappedImageView.setImageResource(R.drawable.lepard);
                current = Player.two;
                setArray(tappedImageView.getId(), 1);
            } else {
                tappedImageView.setImageResource(R.drawable.lion);
                current = Player.one;
                setArray(tappedImageView.getId(), 2);
            }

            resultPlayer = CheckWinner();


            tappedImageView.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);
        }

        if (resultPlayer == 0) {

        }else if (resultPlayer <= -1){
            Toast.makeText(MainActivity.this, "NOONE WIN", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(MainActivity.this, "WIN PLAYER #" + resultPlayer, Toast.LENGTH_LONG).show();
        }
    }

    public void setArray(int id, int playerNum) {
//        for(int i = 0; i <= 8; i++){
//
//            table[i] = playerNum;
//        }
        if (im0.getId() == id) {
            table[0] = playerNum;
        } else if (im1.getId() == id) {
            table[1] = playerNum;
        } else if (im2.getId() == id) {
            table[2] = playerNum;
        } else if (im3.getId() == id) {
            table[3] = playerNum;
        } else if (im4.getId() == id) {
            table[4] = playerNum;
        } else if (im5.getId() == id) {
            table[5] = playerNum;
        } else if (im6.getId() == id) {
            table[6] = playerNum;
        } else if (im7.getId() == id) {
            table[7] = playerNum;
        } else if (im8.getId() == id) {
            table[8] = playerNum;
        }

    }

    public int CheckWinner() {
        boolean bWin = true;
        int lastData = -1;
        boolean existZero = false;

        for (int i = 0; i < win.length - 1; i++) {
            lastData = -1;
            bWin = true;
            for (int a : win[i]
            ) {
                if (table[a] == 0) {
                    bWin = false;
                    existZero = true;
                    break;
                }
                if (lastData == -1) {
                    lastData = table[a];
                    continue;
                } else if (lastData != table[a]) {
                    bWin = false;
                }

            }
            if (bWin) {
                break;
            }
        }
        if (bWin) {
            System.out.println("WIN PLAYER #" + lastData);
            global_b_end_of_game = true;
            return lastData;
        } else if (!existZero) {
            System.out.println("ALL LOST");
            global_b_end_of_game = true;
            return -1;
        } else {
            return 0;
        }
    }


}