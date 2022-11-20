package tests;

import Car.Car;

// Class used for testing the car super class itself
class TestCar extends Car {
    public TestCar() {
        nrDoors = 2;
        enginePower = 5;
        modelName = "Test 473658235343623458432654325";
        stopEngine();
    }
    
    @Override
    public double speedFactor() {
        return 1;
    }

    @Override
    protected void incrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    @Override
    protected void decrementSpeed(double amount) {
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }
}
