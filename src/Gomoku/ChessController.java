/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

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
    int[][] arr;
    int[][] opponentArr;

    public ChessController(MyPanel mp) {
        this.mp = mp;
    }

    public String arrToString(int[][] arr) {
        String temp="";
        int x=arr.length;
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr.length;j++)
                temp+=String.valueOf(arr[i][j]);
        return temp;
    }

    public int[][] StringToArr(String s) {
        int num=(int)Math.sqrt(s.length());
        int[][] temp=new int[num][num];
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr.length;j++)
            {
              temp[i][j]=Integer.parseInt(s.substring(i*num+j, i*num+j+1));
            }
        
        return temp;
    }

    public void run() throws InterruptedException, IOException {
        while (true) {
            output.println(arrToString(mp.getArr()));
            output.flush();
            mp.setOpponentArr(StringToArr(input.readLine()));
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

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the port
     */
    public String getPort() {
        return port;
    }

    /**
     * @param port the port to set
     */
    public void setPort(String port) {
        this.port = port;
    }
}
