package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class YourthoughtsPanel {
    @FXML
    private Button PostButton;

    @FXML
    private Button answerButton;

    @FXML
    private Button commentButton;

    @FXML
    private Button reactButton;

    @FXML
    private TextArea postShow;

    @FXML
    private TextField postTextField;


    private BufferedWriter writer;
    private BufferedReader reader;
    String temp;
    @FXML
    void PostButtonAction(ActionEvent event) {
        try {
            String msg = postTextField.getText() + "\n";
            postTextField.setText("");
            writer.write(msg);
            writer.flush();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    void posttextFieldAction(ActionEvent event) {

    }



    public YourthoughtsPanel(){

        try {
            String myName ;
            if(StudentLoginPanel.id!=null)
            {
                myName=StudentLoginPanel.id;
            }
            else {
                myName=OthersLoginPanel.Mail;
            }
            Socket socket = new Socket("127.0.0.1", 5002);

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(isr);

            writer.write(myName +"\n");
            writer.flush();
            Thread t1 = new Thread() {
                public void run() {
                    try {
                        Scanner sc= new Scanner(new FileReader("src/data.txt"));
                        while (sc.hasNext())
                        {
                            temp+=sc.nextLine()+"\n";
                        }
                        sc.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            };
            t1.start();
            t1.join();


            Thread t = new Thread(){
                public void run(){
                    try{
                        String line = temp+"\n"+reader.readLine() + "\n";
                        while (line != null){
                            postShow.appendText(line);
                            line = reader.readLine() + "\n";
                        }
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }
            };
            t.start();
        }
        catch (IOException | InterruptedException e){
            //e.printStackTrace();
            System.out.println("Host server");
        }
    }

    @FXML
    void reactButtonAction(ActionEvent event) {

    }

    @FXML
    void commentButtonAction(ActionEvent event) {

    }

    @FXML
    void answerButtonAction(ActionEvent event) {

    }

    @FXML
    void backAction(ActionEvent event) throws IOException{
        SceneChanger back = new SceneChanger("HomePage.fxml", event);
    }
}
