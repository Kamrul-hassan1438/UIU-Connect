package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class YourthoughtsPanel {
    @FXML
    private Button PostButton;



    @FXML
    private TextArea postShow;

    @FXML
    private TextField postTextField;


    private BufferedWriter writer;
    private BufferedReader reader;
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
        String myName = "011212133";
        try {
            Socket socket = new Socket("127.0.0.1", 5000);

            OutputStreamWriter o = new OutputStreamWriter(socket.getOutputStream());
            writer = new BufferedWriter(o);

            InputStreamReader isr = new InputStreamReader(socket.getInputStream());
            reader = new BufferedReader(isr);

            writer.write(myName + "\n");
            writer.flush();

            Thread t = new Thread(){
                public void run(){
                    try{
                        String line = reader.readLine() + "\n";
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
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
