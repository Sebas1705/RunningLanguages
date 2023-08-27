package com.sebss;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class TicTacToe extends JFrame{
    
    //component's Frame:
    //Panels:
    private JPanel global;
    private JPanel backTicTokTac;
    private JPanel points;
    //Buttons:
    private JButton reset;
    //JLabels:
    private JLabel l0;private JLabel l1;private JLabel l2;private JLabel l3;private JLabel l4;
    private JLabel l5;private JLabel l6;private JLabel l7;private JLabel l8;private JLabel pointsX;
    private JLabel pointsO;private JLabel comX;private JLabel comO;private JLabel ind;
    //End component's.

    //Variables:
    private String turn = "X";
    private String nextTurn = "O";
    private String winner = null;
    private JLabel[][] lbs = {
        {l0,l1,l2},
        {l3,l4,l5},
        {l6,l7,l8}
    };
    private int[][][] comb = {
        {{0,0},{0,1},{0,2}},
        {{1,0},{1,1},{1,2}},
        {{2,0},{2,1},{2,2}},
        {{0,0},{1,0},{2,0}},
        {{0,1},{1,1},{2,1}},
        {{0,2},{1,2},{2,2}},
        {{0,0},{1,1},{2,2}},
        {{0,2},{1,1},{2,0}}
    };
    //End Variables
    
    //Constructor:
    public TicTacToe(){
        initComponent();
    }
    //End Constructor.

    //Private Methods:
    private void initComponent(){
        this.setTitle("TicTacToe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setSize(300,500);
        this.setLocationRelativeTo(null);

        //Panel global:
        global = new JPanel();
        global.setBounds(0, 0, this.getWidth(), this.getHeight());
        global.setBackground(new Color(0x000000));
        global.setLayout(null);

        //Panel BackTicTokTac:
        backTicTokTac = new JPanel();
        backTicTokTac.setBounds(25, 100, 240, 240);
        backTicTokTac.setBackground(new Color(0x55A00E));
        backTicTokTac.setLayout(null);

        //Panel points:
        points = new JPanel();
        points.setLayout(null);
        points.setBounds(25, 360, 150, 90);
        points.setBackground(new Color(0x014C44));
        global.add(points);
        
        //Labels:
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                lbs[i][j] = new JLabel();
                lbs[i][j].setForeground(new Color(0x55A00E));
                lbs[i][j].setFont(new Font("MV Boli", Font.BOLD, 65));
                lbs[i][j].setHorizontalAlignment(JLabel.CENTER);
                lbs[i][j].setBackground(new Color(0x000000));
                lbs[i][j].setOpaque(true);
                lbs[i][j].setBounds(j*85,i*85,70,70);
                final int x = i;
                final int y = j;
                lbs[i][j].addMouseListener(new MouseInputAdapter() {
                    public void mousePressed(MouseEvent evt) {
                       press(x,y); 
                    }
                });
                backTicTokTac.add(lbs[i][j]);
            }
        }
        ind = new JLabel("turn: X");
        ind.setBounds(20, 20, 250, 60);
        ind.setOpaque(true);
        ind.setBackground(new Color(0x014C44));
        ind.setForeground(Color.BLACK);
        ind.setFont(new Font("MV Boli", Font.BOLD, 40));
        ind.setHorizontalAlignment(JLabel.CENTER);
        global.add(ind);

        comX = new JLabel("Points X:");
        comX.setBounds(0, 0, 100, 45);
        comX.setForeground(Color.BLACK);
        comX.setFont(new Font("MV Boli", Font.BOLD, 18));
        comX.setHorizontalAlignment(JLabel.CENTER);
        points.add(comX);

        pointsX = new JLabel("0");
        pointsX.setBounds(100, 0, 50, 45);
        pointsX.setForeground(Color.BLACK);
        pointsX.setFont(new Font("MV Boli", Font.BOLD, 18));
        pointsX.setHorizontalAlignment(JLabel.CENTER);
        points.add(pointsX);

        comO = new JLabel("Points O:");
        comO.setBounds(0, 45, 100, 45);
        comO.setForeground(Color.BLACK);
        comO.setFont(new Font("MV Boli", Font.BOLD, 18));
        comO.setHorizontalAlignment(JLabel.CENTER);
        points.add(comO);

        pointsO = new JLabel("0");
        pointsO.setBounds(100, 45, 50, 45);
        pointsO.setForeground(Color.BLACK);
        pointsO.setFont(new Font("MV Boli", Font.BOLD, 18));
        pointsO.setHorizontalAlignment(JLabel.CENTER);
        points.add(pointsO);

        //Button:
        reset = new JButton("Reset");
        reset.setBackground(Color.LIGHT_GRAY);
        reset.setBounds(global.getWidth()-115, global.getHeight()-85, 90, 35);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++){
                        lbs[i][j].setText("");
                        lbs[i][j].setBackground(new Color(0x000000));
                    }
                }
                turn = nextTurn;
                if(nextTurn.equals("X")){
                    nextTurn = "O";
                }else nextTurn = "X";
                ind.setText("turn: " + turn);
                winner = null;
            }
        });
        global.add(reset);
        
        
        
        global.add(backTicTokTac);
        this.add(global);
        this.setVisible(true);
    }

    private void press(int x, int y){
        if(lbs[x][y].getText().equals("") && winner == null){
            lbs[x][y].setText(turn);
            changeTurn();
            isWinner();
        }
    }

    private void changeTurn(){
        if("X".equals(turn)){
            turn = "O";
        }else turn = "X";
        ind.setText("turn: "+ turn);
    }

    private void isWinner(){
        for(int i = 0; i < 8; i++){
            if(lbs[comb[i][0][0]][comb[i][0][1]].getText().equals("X") && 
            lbs[comb[i][1][0]][comb[i][1][1]].getText().equals("X") &&
            lbs[comb[i][2][0]][comb[i][2][1]].getText().equals("X")){
                lbs[comb[i][0][0]][comb[i][0][1]].setBackground(Color.RED);
                lbs[comb[i][1][0]][comb[i][1][1]].setBackground(Color.RED);
                lbs[comb[i][2][0]][comb[i][2][1]].setBackground(Color.RED);
                winner = "X";
                pointsX.setText(Integer.toString(Integer.parseInt(pointsX.getText())+1));
                ind.setText("winner: X");
            }
            if(lbs[comb[i][0][0]][comb[i][0][1]].getText().equals("O") && 
            lbs[comb[i][1][0]][comb[i][1][1]].getText().equals("O") &&
            lbs[comb[i][2][0]][comb[i][2][1]].getText().equals("O")){
                lbs[comb[i][0][0]][comb[i][0][1]].setBackground(Color.RED);
                lbs[comb[i][1][0]][comb[i][1][1]].setBackground(Color.RED);
                lbs[comb[i][2][0]][comb[i][2][1]].setBackground(Color.RED);
                winner = "O";
                pointsO.setText(Integer.toString(Integer.parseInt(pointsO.getText())+1));
                ind.setText("winner: O");
            }
        }
    }
}
