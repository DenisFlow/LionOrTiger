package com.example.libtestlogicwin;

public class MyClass {
//    int[] table = {0,0,0,0,0,0,0,0,0};

    public static void main(String[] args) {
        int[] table = {1,2,0,0,2,0,0,2,1};
        int[][] win = {{0,1,2}, {3,4,5}, {6,7,8}, {0,4,8}, {2,4,6}, {0,3,6}, {1,4,7}, {2,5,8}};
        boolean bWin = true;
        int lastData = -1;

//        System.out.println(win.length);

        for (int i = 0; i < win.length - 1; i++) {
            lastData = -1;
            bWin = true;
            for (int a:win[i]
                 ) {
                if (table[a] == 0){
                    bWin = false;
                    break;
                }
                if (lastData == -1 ){
                    lastData = table[a];
                    continue;
                } else if(lastData != table[a]) {
                    bWin = false;
                }

            }
            if (bWin){
                break;
            }
        }
        if (bWin){

            System.out.println("WIN PLAYER #" + lastData);
        }else{
            System.out.println("ALL LOST");
        }
    }
}