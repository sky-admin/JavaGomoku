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
       if(heng()){
           return true;
       }
        return false;
    }

    public boolean heng() {
        int time = 0;
        int x = i;
        int y = j;
        while (arr[x][y] != 0 && x!=14) {
            x++;
        }
        x--;
        while(arr[x][y]!=0){
            time++;
            if(x>=0){
                x--;
            }
        }
        if (time == 4) {
            return true;
        } else {
            return false;
        }
    }
}
