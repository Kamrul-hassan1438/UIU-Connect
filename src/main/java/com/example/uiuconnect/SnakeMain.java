package com.example.uiuconnect;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Random;

public class SnakeMain extends Application {
    private static final int Pane_Width= 300;
    private static final int Pane_Hight= 250;
    private static final int Radius= 5;
    private static final int Step= 5;
    private int speed=100;


    private Pane root;
    private Text score;
    Random random = new Random();

    private Circle food;
    private SnakeBody snake;

    private void newSnake(){
        snake = new SnakeBody(Pane_Width/2 , Pane_Hight/ 2 , Radius+2);
        root.getChildren().add(snake);
    }

    private void newFood(){
        food = new Circle(random.nextInt(Pane_Width-10), random.nextInt(Pane_Hight-10),Radius );
        food.setFill(Color.RED);
        root.getChildren().add(food);
    }

    private boolean hit(){
        return food.intersects(snake.getBoundsInLocal());
    }
    private boolean gameOver(){return snake.eatItSelf();}

    private void move(){
        Platform.runLater(()->{
            snake.step();
            adjustment();
            if (hit()){
                snake.eat(food);
                score.setText(""+snake.getLength());
                newFood();

                //speed+=5;
            }
            else if (gameOver()){
                root.getChildren().clear();
                root.getChildren().add(score);
                score.setText("Game over \n Your Score="+snake.getLength());

            }
        });
    }
    private void adjustment(){
        if(snake.getCenterX()<0){
            snake.setCenterX(Pane_Width);
        }
        if (snake.getCenterY()<0){
            snake.setCenterY(Pane_Hight);
        }
        if (snake.getCenterY()>Pane_Hight){
            snake.setCenterY(0);
        }
        if (snake.getCenterX()>Pane_Width){
            snake.setCenterX(0);
        }
    }





    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        root = new Pane();
        root.setPrefSize(Pane_Width, Pane_Hight);
        random=new Random();
        score = new Text(0, 32, "0");
        newFood();
        newSnake();

        Runnable r =() ->{
            try {
                for(;;){
                    move();
                    Thread.sleep(speed);
                }
            } catch (Exception e){

            }
        };


        Scene scene = new Scene(root);

        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.UP){
                snake.setCurrentDirection(Direction.UP);
            }
            if (event.getCode() == KeyCode.DOWN){
                snake.setCurrentDirection(Direction.DOWN);
            }
            if (event.getCode() == KeyCode.RIGHT){
                snake.setCurrentDirection(Direction.RIGHT);
            }
            if (event.getCode() == KeyCode.LEFT){
                snake.setCurrentDirection(Direction.LEFT);
            }
        });

        stage.setTitle("Snake Game");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        Thread th = new Thread(r);
        th.setDaemon(true);
        th.start();
    }
}

