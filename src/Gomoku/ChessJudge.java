/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

/**
 *
 * @author skyADMIN
 */
public class ChessJudge {

    private int[][] arr;
    private int i, j;

    public ChessJudge(int[][] arr, int i, int j) {
        this.arr = arr;
        this.i = i;
        this.j = j;
    }

    public boolean iswin() {

        for (int step = 0; step < 4; step++) {
        }
        return false;
    }

    public boolean heng() {
        int time = 0;
        int x = 0;
        int y = 0;
        while (arr[x][y] != 0) {
            x++;
        }
        x--;
        while(arr[x][y]!=0){
            time++;
            if(x>0){
                x--;
            }
        }
        time = time1+time2;
        if (time == 4) {
            return true;
        } else {
            return false;
        }
    }

    public boolean shu() {
       int time = 0;
        int time1 = 0;
        int time2 = 0;
        int x = 0;
        int y = 0;
        while (arr[x][y] != 0) {
            time1++;
            y++;
        }
        while(arr[x][y]!=0){
            time2++;
            if(x>0){
                y--;
            }
        }
        time = time1+time2;
        if (time == 4) {
            return true;
        } else {
            return false;
        }
    }
    public boolean zouxie(){
         int time = 0;
        int time1 = 0;
        int time2 = 0;
        int x = 0;
        int y = 0;
        while (arr[x][y] != 0) {
            time1++;
            x++;
            y++;
        }
        while(arr[x][y]!=0){
            time2++;
            if(x>0&&y>0){
                x--;
                y--;
            }
        }
        time = time1+time2;
        if (time == 4) {
            return true;
        } else {
            return false;
        }
    }
    public boolean youxie(){
         int time = 0;
        int time1 = 0;
        int time2 = 0;
        int x = 0;
        int y = 0;
        while (arr[x][y] != 0) {
            time1++;
            x++;
            y--;
        }
        while(arr[x][y]!=0){
            time2++;
            if(x>0){
                x--;
                y++;
            }
        }
        time = time1+time2;
        if (time == 4) {
            return true;
        } else {
            return false;
        }
    }
}
