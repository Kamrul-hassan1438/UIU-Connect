package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    @FXML
    private Rectangle r1;
    @FXML
    private Rectangle r2;
    @FXML
    private Rectangle r3;
    @FXML
    private Rectangle r4;
    @FXML
    private Rectangle r5;
    @FXML
    private Rectangle r6;
    @FXML
    private Rectangle r7;
    @FXML
    private Rectangle r8;
    @FXML
    private Rectangle r9;


    @FXML
    private Circle c1;
    @FXML
    private Circle c2;
    @FXML
    private Circle c3;

    @FXML
    private QuadCurve curve1;
    @FXML
    private Line l1;
    @FXML
    private Line l2;

    @FXML
    private Label la1;
    @FXML
    private Label la11;

    @FXML
    private Label la111;

    @FXML
    private Label la1111;

    @FXML
    private Label la11111;

    @FXML
    private Label la111111;

    @FXML
    private Label la1111111;

    @FXML
    private Label la11111111;


    @FXML
    private Label  la2;

    @FXML
    private Button pla;


    @FXML
    final  int Max=4;
    @FXML
    int Count=0;
    @FXML
    public char[] word;
    @FXML
    public char[] temp_Char;


    @FXML
    private  void Play_Action()
    {
        try {
            FileReader fileReader= new FileReader("src/Hangman_Words");
            Scanner sc= new Scanner(fileReader);
            ArrayList<String> list= new ArrayList<>();
            int a= new Random().nextInt(200);
            int b;
            while (sc.hasNext())
            {
                list.add(sc.nextLine());
            }
            sc.close();
            String temp = "BABBBAAA";
            //list.get(a).toUpperCase();
            temp_Char= temp.toCharArray();
            word= new char[temp.length()];
            la1.setText(temp_Char[0]+"");
            System.out.println(temp);
        }
        catch (IOException e)
        {
            System.out.println("ERRor");
        }
        pla.setVisible(false);
    }


    @FXML
    private void check(KeyEvent event) {
        word = la1.getText().toCharArray();
        Count++;

        if(Count<2)
        {
            r1.setVisible(true);
            r2.setVisible(true);
            r3.setVisible(true);
            r4.setVisible(true);
            r5.setVisible(true);
            r6.setVisible(true);
        }

        else if (Count<3)
        {
            c1.setVisible(true);
            c2.setVisible(true);
            c3.setVisible(true);
            curve1.setVisible(true);
        }
        else if (Count<4)
        {
            r7.setVisible(true);
            l1.setVisible(true);
            l2.setVisible(true);
        }
        else if(Count<5)
        {
            r8.setVisible(true);
            r9.setVisible(true);
        }
        else {
            System.out.println("game over");
        }


        if (Count<5) {
            if ((event.getCode() == KeyCode.A)) {
                System.out.println("A Clicked");

                for (int i= 0; i<temp_Char.length; i++)
                {
                    if ('A'==temp_Char[i])
                    {
                    }
                }
                System.out.println(word);

                // String temp2=String.valueOf(word);
                // System.out.println(temp2);
                la1.setText(word+"");
            } else if ((event.getCode() == KeyCode.B)) {

                la1.setText(word + "B");

            } else if ((event.getCode() == KeyCode.C)) {

                la1.setText(word + "C");
            } else if ((event.getCode() == KeyCode.D)) {

                la1.setText(word + "D");
            } else if ((event.getCode() == KeyCode.E)) {

                la1.setText(word + "E");
            } else if ((event.getCode() == KeyCode.F)) {

                la1.setText(word + "F");
            } else if ((event.getCode() == KeyCode.G)) {

                la1.setText(word + "G");
            } else if ((event.getCode() == KeyCode.H)) {
                la1.setText(word + "H");
            } else if ((event.getCode() == KeyCode.I)) {
                la1.setText(word + "I");
            } else if ((event.getCode() == KeyCode.J)) {
                la1.setText(word + "J");
            } else if ((event.getCode() == KeyCode.K)) {
                la1.setText(word + "K");
            } else if ((event.getCode() == KeyCode.L)) {
                la1.setText(word + "L");
            } else if ((event.getCode() == KeyCode.M)) {
                la1.setText(word + "M");
            } else if ((event.getCode() == KeyCode.N)) {
                la1.setText(word + "N");
            } else if ((event.getCode() == KeyCode.O)) {
                la1.setText(word + "O");
            } else if ((event.getCode() == KeyCode.P)) {
                la1.setText(word + "P");
            } else if ((event.getCode() == KeyCode.Q)) {
                la1.setText(word + "Q");
            } else if ((event.getCode() == KeyCode.R)) {

                la1.setText(word + "R");
            } else if ((event.getCode() == KeyCode.S)) {

                la1.setText(word + "S");
            } else if ((event.getCode() == KeyCode.T)) {

                la1.setText(word + "T");
            } else if ((event.getCode() == KeyCode.U)) {
                la1.setText(word + "U");
            } else if ((event.getCode() == KeyCode.V)) {
                la1.setText(word + "V");
            } else if ((event.getCode() == KeyCode.W)) {
                la1.setText(word + "W");
            } else if ((event.getCode() == KeyCode.X)) {
                la1.setText(word + "X");
            } else if ((event.getCode() == KeyCode.Y)) {
                la1.setText(word + "Y");
            } else if ((event.getCode() == KeyCode.Z)) {
                la1.setText(word + "Z");
            }
        }
        else {
            la2.setText("game over");
        }
    }

    @FXML
    public void setBack(ActionEvent e) throws IOException {
        SceneChanger setBack= new SceneChanger("GameZonePanel.fxml",e);
    }
}
