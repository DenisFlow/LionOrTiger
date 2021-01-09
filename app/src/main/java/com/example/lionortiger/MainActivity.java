package com.example.lionortiger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    enum Player {
        one, two
    }

    ImageView im0, im1, im2, im3, im4, im5, im6, im7, im8;
    Button btnAgain;


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

        btnAgain = findViewById(R.id.button);




    }

    public void onClickPush(View View) {
        if (!global_b_end_of_game) {
            ImageView tappedImageView = (ImageView) View;

            tappedImageView.setTranslationX(-2000);
            if (current == Player.one) {
                if (setArray(tappedImageView.getId(), 1)) {
                    tappedImageView.setImageResource(R.drawable.lepard);
                    current = Player.two;
                }else{
                    fnShowErrorStep();
                    tappedImageView.setImageResource(R.drawable.lion);
//                    return;
                }
            } else {
                if (setArray(tappedImageView.getId(), 2)) {
                    tappedImageView.setImageResource(R.drawable.lion);
                    current = Player.one;
                }else{
                    fnShowErrorStep();
                    tappedImageView.setImageResource(R.drawable.lepard);
//                    return;
                }
            }

            resultPlayer = CheckWinner();


            tappedImageView.animate().translationXBy(2000).alpha(1).rotation(3600).setDuration(1000);
        }

        if (resultPlayer == 0) {

        }else {
            if (resultPlayer <= -1) {
                Toast.makeText(MainActivity.this, "NOONE WIN", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "WIN PLAYER #" + resultPlayer, Toast.LENGTH_LONG).show();
            }
            if (btnAgain.getVisibility() == android.view.View.INVISIBLE) {
                btnAgain.setVisibility(android.view.View.VISIBLE);
            }
        }
    }

    public void fnShowErrorStep(){
        Toast.makeText(MainActivity.this, "THIS IS WRONG STEP", Toast.LENGTH_LONG).show();
    }

    public void fnClickMakePlayAgain(View View){
        for (int i = 0; i < table.length; i++){
            table[i] = 0;
        }

        global_b_end_of_game = false;
        resultPlayer = 0;
        current = Player.one;
        btnAgain.setVisibility(android.view.View.INVISIBLE);

        im0.setImageResource(0);
        im1.setImageResource(0);
        im2.setImageResource(0);
        im3.setImageResource(0);
        im4.setImageResource(0);
        im5.setImageResource(0);
        im6.setImageResource(0);
        im7.setImageResource(0);
        im8.setImageResource(0);

    }

    public boolean setArray(int id, int playerNum) {
        boolean bWasChange = false;
//        for(int i = 0; i <= 8; i++){
//
//            table[i] = playerNum;
//        }
        if (im0.getId() == id && table[0] == 0 ) {
            table[0] = playerNum;
            bWasChange = true;
        } else if (im1.getId() == id && table[1] == 0 ) {
            table[1] = playerNum;
            bWasChange = true;
        } else if (im2.getId() == id && table[2] == 0 ) {
            table[2] = playerNum;
            bWasChange = true;
        } else if (im3.getId() == id && table[3] == 0 ) {
            table[3] = playerNum;
            bWasChange = true;
        } else if (im4.getId() == id && table[4] == 0 ) {
            table[4] = playerNum;
            bWasChange = true;
        } else if (im5.getId() == id && table[5] == 0 ) {
            table[5] = playerNum;
            bWasChange = true;
        } else if (im6.getId() == id && table[6] == 0 ) {
            table[6] = playerNum;
            bWasChange = true;
        } else if (im7.getId() == id && table[7] == 0 ) {
            table[7] = playerNum;
            bWasChange = true;
        } else if (im8.getId() == id && table[8] == 0 ) {
            table[8] = playerNum;
            bWasChange = true;
        }

        return bWasChange;

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