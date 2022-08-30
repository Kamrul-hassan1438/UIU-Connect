package Snake;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class SnakeBody extends Circle {
    private List<Circle> tails;
    private  int length =0;
    Direction currentDirection;
    private int Step= 5;
    public SnakeBody(double d , double d1 , double d2){
        super(d , d1, d2);
        tails = new ArrayList<>();
        currentDirection = Direction.UP;
    }
    public void step(){

        for(int i= length-1 ; i>=0 ; i--){
            if (i==0){
                tails.get(i).setCenterX(getCenterX());
                tails.get(i).setCenterY(getCenterY());
            }
            else {
                tails.get(i).setCenterX(tails.get(i-1).getCenterX());
                tails.get(i).setCenterY(tails.get(i-1).getCenterY());
            }
        }
        if (currentDirection == Direction.UP){
            setCenterY(getCenterY()-Step);
        }
        else if (currentDirection == Direction.DOWN){
            setCenterY(getCenterY()+Step);
        }
        else if (currentDirection == Direction.LEFT){
            setCenterX(getCenterX()-Step);
        }
        else if (currentDirection == Direction.RIGHT){
            setCenterX(getCenterX()+Step);
        }

    }

    public boolean eatItSelf(){
        for(int i=0 ; i<length ; i++){
            if(this.getCenterX()==tails.get(i).getCenterX() && this.getCenterY()==tails.get(i).getCenterY() ) {
                return true;
            }
        }
        return false;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }
    private Circle endTail(){
        if (length == 0){
            return this;
        }
        return tails.get(length-1);
    }
    public void eat(Circle food ){
        Circle tail = new Circle();
        food.setCenterX(tail.getCenterX());
        food.setCenterY(tail.getCenterY());
        tails.add(length++, food);


    }

    public int getLength() {
        return length;
    }
}

