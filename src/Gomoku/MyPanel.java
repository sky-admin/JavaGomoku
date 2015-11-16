/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gomoku;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Administrator
 */
public class MyPanel extends javax.swing.JPanel {

    int startX = 40;
    int startY = 40;
    int lineNum = 15;
    int space = 40;
    int currentX;
    int currentY;
    private int[][] arr = new int[lineNum][lineNum];
    private int[][] opponentArr = new int[lineNum][lineNum];
    Color chessColor = Color.blue;
    Color opponentColor = Color.white;
    ChessController controller;

    /**
     * Creates new form MyPanel
     */
    public MyPanel() {
        for (int i = 0; i < lineNum; i++) {
            for (int j = 0; j < lineNum; j++) {
                arr[i][j] = 0;
                opponentArr[i][j] = 0;
            }
        }
        //arrClient[3][5]=1;
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        initComponents();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);

        for (int i = 0; i < lineNum; i++) {
            g.drawLine(startX + space * i, startY, startX + space * i, startY + space * (lineNum - 1));
        }
        for (int i = 0; i < lineNum; i++) {
            g.drawLine(startX, startY + space * i, startX + space * (lineNum - 1), startY + space * i);
        }


        for (int i = 0; i < lineNum; i++) {
            for (int j = 0; j < lineNum; j++) {
                if (getArr()[i][j] == 1) {
                    g.setColor(chessColor);
                    g.fillOval(i * space + startX - 15, j * space + startY - 15, 30, 30);
                }
                if (getOpponentArr()[i][j] == 1) {
                    g.setColor(opponentColor);
                    g.fillOval(i * space + startX - 15, j * space + startY - 15, 30, 30);
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        currentX = evt.getX();
        currentY = evt.getY();
        int i = -1, j = -1;
        if ((currentX - startX) % space <= 15) {
            i = (currentX - startX) / space;
        }
        if ((currentX - startX) % space >= 25) {
            i = (currentX - startX) / space + 1;
        }
        if ((currentY - startY) % space <= 15) {
            j = (currentY - startY) / space;
        }
        if ((currentY - startY) % space >= 25) {
            j = (currentY - startY) / space + 1;
        }
        if (i >= 0 && j >= 0) {
            getArr()[i][j] = 1;
        }
        this.repaint();
    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    /**
     * @return the arr
     */
    public int[][] getArr() {
        return arr;
    }

    /**
     * @param arr the arr to set
     */
    public void setArr(int[][] arr) {
        this.arr = arr;
    }

    /**
     * @return the opponentArr
     */
    public int[][] getOpponentArr() {
        return opponentArr;
    }

    /**
     * @param opponentArr the opponentArr to set
     */
    public void setOpponentArr(int[][] opponentArr) {
        this.opponentArr = opponentArr;
    }
}