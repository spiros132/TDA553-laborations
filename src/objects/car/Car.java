package car;
import java.awt.*;

import objects.GameObject;
import utilities.Clamping;
import utilities.Vector2D;

public abstract class Car extends GameObject implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    private double currentSpeed; // The current speed of the car
    
<<<<<<< HEAD:src/objects/car/Car.java
    public int GetNrDoors(){
=======
    private Vector2D position = new Vector2D();
    private int direction = 0; // 0 = Up, 1 = Right, 2 = Down, 3 = Left
    

    public int getNrDoors(){
>>>>>>> lab1:src/Car/Car.java
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
	    color = clr;
    }

<<<<<<< HEAD:src/objects/car/Car.java
    public void StartEngine(){
        
=======
    public void startEngine(){
>>>>>>> lab1:src/Car/Car.java
	    currentSpeed = 0.1;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }


    protected abstract double speedFactor();
    
    protected boolean canDrive() {
        return true;
    }

    private void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }

<<<<<<< HEAD:src/objects/car/Car.java
    public void TurnLeft() {
        if(GetCurrentSpeed() <= 0)
            return;
=======
  
    public Vector2D getCurrentVectorDirection() {
        if(direction == 0) { // 0 is up
            return new Vector2D(0, 1);
        }
        else if(direction == 1) { // 1 is right
            return new Vector2D(1, 0);
        }
        else if(direction == 2) { // 2 is down
            return new Vector2D(0, -1);
        }
        else if (direction == 4) { // 3 is left
            return new Vector2D(-1, 0);
        }
        else {
            throw new Error("Direction: " + direction + "shouldn't exist");
        }
    }

    public int getCurrentIntDirection() {
        if(direction > 3 && direction < 0) {
            throw new Error("Direction: " + direction + "shouldn't exist");
        }
        return direction;
    }

    public Vector2D getCurrentPosition() {
        return position;
    }

    public void move() {
        position = Vector2D.add(position, Vector2D.multiply(getCurrentVectorDirection(), speedFactor()));
    }

    public void turnLeft() {
        System.out.println("Turn Left, current direction: " + direction);
        direction -= 1;
    
        if (direction < 0) {
            direction = 3;
        }
>>>>>>> lab1:src/Car/Car.java

        RotateLeft(1);  
    }

<<<<<<< HEAD:src/objects/car/Car.java
    public void TurnRight() {
        if(GetCurrentSpeed() <= 0)
            return;
=======
    public void turnRight() {
        System.out.println("Turn Right, current direction: " + direction);
>>>>>>> lab1:src/Car/Car.java

        RotateRight(1);
    }

    public void Move() {
        if (canDrive() == true)
            MoveWithDirection(Vector2D.Multiply(GetCurrentVectorDirection(), GetCurrentSpeed()));
    }

    public void gas(double amount){
        amount = Clamping.clamp(amount, 0, 1);

        incrementSpeed(amount);
        
        currentSpeed = Clamping.clamp(currentSpeed, 0, enginePower);
    }

    public void brake(double amount){
        amount = Clamping.clamp(amount, 0, 1);

        decrementSpeed(amount);

        currentSpeed = Clamping.clamp(currentSpeed, 0, enginePower);
    }
}
