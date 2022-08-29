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
    private Label  la2;

    @FXML
    private Button pla;


    @FXML
    final  int Max=4;
    @FXML
    final  int Max_2=6;
    @FXML
    int Count=0;
    @FXML
    String temp;


    @FXML
    private  void Play_Action()
    {
        try {
            FileReader fileReader= new FileReader("Hangman_Words");
            Scanner sc= new Scanner(fileReader);
            ArrayList<String> list= new ArrayList<>();
            int a= new Random().nextInt(200);

            while (sc.hasNext())
            {
                list.add(sc.nextLine());
            }
            sc.close();
            temp= list.get(a);
            System.out.println(temp);
        }
        catch (IOException e)
        {

        }
        pla.setVisible(false);
    }
    @FXML
    private void check(KeyEvent event) throws  InterruptedException
    {
        System.out.println("CLICKED");
        if (event.getCode()== KeyCode.A )
        {
            ++Count;
            if (temp.length()<=7 && Count>Max)
            {
                if (la1.getText().equals(temp))
                {
                    la2.setText("YOU WON");
                }
                else {
                    la2.setText("LOSE");
                }
                pla.setVisible(true);
            }
            else {
                la1.setText(la1.getText()+"A");
            }
            System.out.println("CLICKED2");


        }
        if (event.getCode()==KeyCode.B)
        {
            la1.setText("B");
            System.out.println("CLICKED3");
        }
    }


    @FXML
    public void setBack(ActionEvent event) throws IOException {
        SceneChanger setBack= new SceneChanger("GameZone.fxml",event);
    }

}
