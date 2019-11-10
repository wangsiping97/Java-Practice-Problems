public class Fan {
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String color = "blue";
    Fan () { }
    public int getSpeed () {
        return speed;
    }
    public boolean getOn () {
        return on;
    }
    public double getRadius () {
        return radius;
    }
    public String getColor () {
        return color;
    }
    public void setSpeed (int _speed) {
        speed = _speed;
    }
    public void setOn (boolean _on) {
        on = _on;
    }
    public void setRadius (double _radius) {
        radius = _radius;
    }
    public void setColor (String _color) {
        color = _color;
    }
    public String toString () {
        if (on) {
            return "speed: " + speed + "; radius: " + radius + "; color: " + color + ".";
        }
        else {
            return "Fan is off. " + "speed: " + speed + "; radius: " + radius + "; color: " + color + ".";
        }
    }
    public static void main (String[] arguments) {
        Fan f1 = new Fan ();
        Fan f2 = new Fan ();

        f1.setSpeed(FAST);
        f1.setRadius(10);
        f1.setColor("yellow");
        f1.setOn(true);

        f2.setSpeed(MEDIUM);
        f2.setRadius(5);
        f2.setColor("blue");
        f2.setOn(false);

        System.out.println("Fan1: " + f1.toString());
        System.out.println("Fan2: " + f2.toString());
    }
}