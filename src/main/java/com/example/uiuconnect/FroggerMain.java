package com.example.uiuconnect;

import javafx.animation.AnimationTimer;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class FroggerMain extends Application {
    int score =0;
    Text textArea = new Text();
    private AnimationTimer timer;
    private Pane root;
    private List<Node> cars = new ArrayList<>();
    private Node frog;
    private Parent createContent(){
        root = new Pane();
        root.setPrefSize(800, 600);
        root.setBackground(Background.fill(Color.ORANGE));

        frog = initFrog();
        root.getChildren().add(frog);
        timer = new AnimationTimer(){
            @Override
            public void handle(long now) {
                onUpdate();
            }

        } ;
        timer.start();

        return root;
    }
    private void adjustment(){
        if(frog.getTranslateX()<0){
            frog.setTranslateX(800);
        }
        if (frog.getTranslateY()<0){
            frog.setTranslateY(600);
        }
        if (frog.getTranslateY()>600){
            frog.setTranslateY(0);
        }
        if (frog.getTranslateX()>800){
            frog.setTranslateX(0);
        }
    }

    private void onUpdate() {
        for (Node car : cars)
            car.setTranslateX(car.getTranslateX()+ Math.random()*10);

        if (Math.random()< 0.075){
            cars.add(spawnCar());
        }
        checkState();
    }

    private void checkState() {
        adjustment();
        for (Node car : cars){
            if (car.getBoundsInParent().intersects(frog.getBoundsInParent())) {
                root.getChildren().clear();
                String sc = score + "";
                textArea.setText("Game over \nYour Score=" + sc);
                textArea.setTranslateX(350);
                textArea.setTranslateY(250);
                root.getChildren().add(textArea);
                timer.stop();
            }
        }

    }

    private Node initFrog() {
        Rectangle rect = new Rectangle(38, 38 , Color.WHITE);
        rect.setTranslateY(600 - 39);

        return rect;
    }
    private Node spawnCar(){
        Rectangle rect = new Rectangle(38 , 38 , Color.BLACK);
        double v = (int )(Math.random() * 14) *40 ;
        rect.setTranslateY(v);
        root.getChildren().add(rect);
        return  rect;
    }


    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(createContent()));

        stage.getScene().setOnKeyPressed(event -> {

                    switch (event.getCode()) {
                        case UP:
                            frog.setTranslateY(frog.getTranslateY() - 40);
                            score++;
                            break;
//                    case DOWN:
//                        frog.setTranslateY(frog.getTranslateY() + 40);
//                        break;
                        case RIGHT:
                            frog.setTranslateX(frog.getTranslateX() + 40);
                            break;
                        case LEFT:
                            frog.setTranslateX(frog.getTranslateX() - 40);
                            break;
                        default:
                            break;
                    }

                }

        );
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
