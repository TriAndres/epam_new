package by.epam.learn.bean;

public class Coin {
    private double diameter;
    private double weight;

    public double getDiameter() {
        return diameter;
    }

    public void setDiameter(double value) {
        if (value > 0) {
            this.diameter = value;
        } else {
            diameter = 0.01;
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double value) {
        this.weight = value;
    }
}
