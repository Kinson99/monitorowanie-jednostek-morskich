package pl.kinast.monitorowaniejednostekmorskich.model;

public class Point {

    private double x;
    private double y;
    private String name;
    private String destination;

    public Point(double y, double x, String name, String destination) {
        this.y = y;
        this.x = x;
        this.name = name;
        this.destination = destination;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
