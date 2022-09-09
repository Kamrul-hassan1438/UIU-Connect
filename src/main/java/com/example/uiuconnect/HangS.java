package com.example.uiuconnect;

import  javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

public class HangS implements Initializable {

    @FXML
    private Text hangmanTextArea;

    @FXML
    private TextField guess;

    @FXML
    private Text textForWord;

    @FXML
    private Text endOfGameText;

    private String word;
    private String M_Word;

    private StringBuilder secretWord = new StringBuilder();

    private int livesPos = 0;

    ArrayList<String> hangManLives = new ArrayList<>(Arrays.asList(
            """
            +---+
            |   |
                |
                |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
                |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
            |   |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|   |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|\\  |
                |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|\\  |
           /    |
                |
          =========""",
            """
            +---+
            |   |
            O   |
           /|\\  |
           / \\  |
                |
          ========="""
    ));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        hangmanTextArea.setText(hangManLives.get(livesPos));
    }

    @FXML
    void getTextInput(ActionEvent event) {
        if(word == null){
            word = guess.getText();
            M_Word=word;
            setupWord();
            guess.clear();
        } else{
            playTurn();
            guess.clear();
        }
    }

    public void setupWord(){
        int wordLength = word.length();
        secretWord.append("*".repeat(wordLength));
        textForWord.setText(String.valueOf(secretWord));
    }

    public void playTurn(){
        String guess = this.guess.getText();
        ArrayList<Integer> positions = new ArrayList<>();
        char[] wordChars = word.toCharArray();
        char letterGuess = guess.charAt(0);

        if(word.contains(guess) && word.equals(guess)){
            endOfGameText.setText("You won!!");
        }

        else if(word.contains(guess)){

            for (int i = 0; i < word.length(); i++) {
                if (wordChars[i] == letterGuess) {
                    positions.add(i);
                }
            }
            positions.forEach(pos -> {
                secretWord.setCharAt(pos, letterGuess);
            });

            textForWord.setText(String.valueOf(secretWord));

        } else {
            hangmanTextArea.setText(hangManLives.get(++livesPos));
            if(livesPos == 6){
                textForWord.setText(M_Word);
                endOfGameText.setText("You LOST!!");
            }
        }
    }

    @FXML
    void reset(ActionEvent event) {
        word = null;
        secretWord.setLength(0);
        livesPos = 0;
        hangmanTextArea.setText(hangManLives.get(0));
        guess.setText("");
        endOfGameText.setText("");
        textForWord.setText("Enter new input");
    }
    @FXML
    public void GoingBack(ActionEvent e) throws IOException {
        SceneChanger GoingBack= new SceneChanger("GameZonePanel.fxml",e);
    }
}


