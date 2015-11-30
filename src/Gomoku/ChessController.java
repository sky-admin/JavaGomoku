/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author skyADMIN
 */
public class ChessController extends Thread{
    private int status;
    MyPanel panel;
    BufferedReader input;
    PrintWriter output;
    Socket socket;
    private String ip;
    private String port;
    int[][] arr;
    int[][] opponentArr;
    public ChessController(MyPanel panel,int status){
        this.status = status;
        this.panel=panel;
    }
    public void client(){
        try {
            Socket client=new Socket(ip,Integer.parseInt(port));
            input=new BufferedReader(new InputStreamReader(client.getInputStream()));
            output=new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (UnknownHostException ex) {
            Logger.getLogger(ChessController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ChessController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void server(){
        try {
            ServerSocket serverSocket = new  ServerSocket(50000);
            Socket client=serverSocket.accept();
            JOptionPane.showMessageDialog(null, "有客户端链接到了本机的50000端口,游戏开始,我方先走.");
            input=new BufferedReader(new InputStreamReader(client.getInputStream()));
            output=new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ChessController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void run(){
         if (status == 0) {
             panel.setIsMyTurn(1);
             this.server();
         }
         if(status == 1){
             this.client();
         }
        while(true){
            try {
                arr=panel.getArr();
                String myResult=arrToString(arr);
                output.println(myResult);
                output.flush();
                opponentArr=stringToArr(input.readLine());
                panel.setOpponentArr(opponentArr);
                panel.repaint();
                Thread.sleep(1000);
            } catch (Exception ex) {
                Logger.getLogger(MyPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String arrToString(int[][] arr){
        String temp="";
        int x=arr.length;
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr.length;j++)
                temp+=String.valueOf(arr[i][j]);
        if (panel.getIsGo()==1) {
            temp+=";1";
            panel.setIsGo(0);
        }
        if (panel.getIsWin()==0) {
            temp+=";0";
        }else{
            temp+=";1";
        }
        return temp;
    }   
    public int[][] stringToArr(String orgrins){
        String[] ss = orgrins.split(";");
        String s = ss[0];
        if (ss[1].equals("1")) {
            //System.out.println("123");
            panel.setIsMyTurn(1);
        }
        int num=(int)Math.sqrt(s.length());
        int[][] temp=new int[num][num];
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr.length;j++)
            {
              temp[i][j]=Integer.parseInt(s.substring(i*num+j, i*num+j+1));
            }
        
        return temp;
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
