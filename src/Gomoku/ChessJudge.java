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
        if (heng()) {
            return true;
        }
        if (shu()) {
            return true;
        }
        if(zuoxie()){
            return  true;
        }
        if(youxie()){
            return true;
        }
        return false;
    }

    public boolean heng() {
        int time = 0;
        int x = i;
        int y = j;
        while (arr[x][y] != 0 && x != 14) {
            x++;
        }
        x--;
        while (arr[x][y] != 0) {
            time++;
            if (x >= 0) {
                x--;
            }
        }
        if (time == 5) {
            return true;
        } else {
            return false;
        }
    }
    public boolean shu() {
        int time = 0;
        int x = i;
        int y = j;
        while (arr[x][y] != 0 && x!=14) {
            y++;
        }
        y--;
        while(arr[x][y]!=0){
            time++;
            if(y >=0){
                y--;
            }
        }
        if (time == 5) {
            return true;
        } else {
            return false;
        }
    }
     public boolean zuoxie() {
        int time = 0;
        int x = i;
        int y = j;
        while (arr[x][y] != 0 && x != 14 && y != 14) {
            x++;
            y++;
        }
        x--;
        y--;
        while (arr[x][y] != 0) {
            time++;
            if (x >= 0 && y>=0) {
                x--;
                y--;
            }
        }
        if (time == 5) {
            return true;
        } else {
            return false;
        }
    }
      public boolean youxie() {
        int time = 0;
        int x = i;
        int y = j;
        while (arr[x][y] != 0 && x != -1 && y != 14) {
            y++;
            x--;
        }
        y--;
        x++;
        while (arr[x][y] != 0) {
            time++;
            if (x >= 0 && y>=0) {
                y--;
                x++;
            }
        }
        if (time == 5) {
            return true;
        } else {
            return false;
        }
    }
}
