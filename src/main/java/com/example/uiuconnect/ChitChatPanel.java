package com.example.uiuconnect;

import Massage.Data;
import Massage.NetworkConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ChitChatPanel {
    NetworkConnection nc;
    Socket socket;
    Data data;
    @FXML
    private Button SendButton;

    @FXML
    private Button activeButton;

    @FXML
    private TextArea all_text;

    @FXML
    private Button backButton;

    @FXML
    private TextField textField;

    @FXML
    private Label member;

    String username;
    public ChitChatPanel() {
         username=StudentLoginPanel.id;
        socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("www.google.com", 80));
            nc  =new NetworkConnection(socket.getLocalAddress().getHostAddress(),12345);
            data=new Data();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Client Started--- ");
        System.out.println(socket.getLocalAddress().getHostAddress());

        nc.write(username);

        Thread t = new Thread() {
            public void run() {
                String msg;
                Object obj = nc.read();
                while (obj!=null) {
                    msg = (String) obj;
                    //Data dataObj=(Data)obj;
                    if (!getMessage().equals(msg)) ;
                    {
                        setMessage(msg);
                       // System.out.println("\nReceived : " + msg);
                        all_text.appendText(msg);
                        check = false;
                    }
                    obj = nc.read();
//            if(check==true){
//            setMessage(msg);
//            System.out.println("Received : "+msg);
//            check = false;
//            }

                }
            }
        };
        t.start();
    }

    String msg="";
    public static boolean check = false;
    public void setMessage(String msg){
        this.msg=msg;
    }
    public void StartThread(){
        new Thread((Runnable) this).start();
        //this.start();
    }
    public String getMessage() {
        if(msg!=null)
            return msg;
        else return "";
    }
    @FXML
    void send(ActionEvent event) {

        //Thread readerThread=new Thread(new Reader(nc));
        //Thread writerThread=new Thread(new Writer(nc));

        // readerThread.start();
        // writerThread.start();

        // readerThread.join();
        // writerThread.join();
        data.message=textField.getText();
        try{
            nc.write(data.clone());

        }
        catch(Exception ex){
            System.out.println("sending failed");
        }
    }

    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        SceneChanger back = new SceneChanger("HomePage.fxml", event);
    }

    @FXML
    void activeAction(ActionEvent event) {
        data.message=username+">>"+username+">>list";
        try{
            nc.write(data.clone());

        }
        catch(Exception ex){
            System.out.println("sending failed");
        }
    }


}
