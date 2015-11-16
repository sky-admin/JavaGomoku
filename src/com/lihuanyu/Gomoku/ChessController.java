/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lihuanyu.Gomoku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class ChessController {

    BufferedReader input;
    PrintWriter output;
    String ip;
    String port;
    MyPanel mp;

    public ChessController(MyPanel mp) {
        this.mp = mp;
    }

    public String arrToString(int[][] arr) {
        String temp = "";

        return temp;
    }
    public int[][] StringToArr(String s) {
        int[][] arr = new int[15][15];
        
        return arr;
    }

    public void run() throws InterruptedException {
        while (true) {

            output.println(arrToString(mp.getArr()));
            output.flush();
            mp.repaint();
            Thread.sleep(1000);
        }
    }

    public void client() {
        try {
            Socket socket = new Socket(ip, Integer.parseInt(port));
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (UnknownHostException ex) {
            Logger.getLogger(ChessController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChessController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void server() {
        try {
            ServerSocket ss = new ServerSocket(50000);
            Socket socket = ss.accept();
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ChessController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
