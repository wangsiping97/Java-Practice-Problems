import java.lang.Math;

public class Pentagon extends GeometricObject implements Fillable 
{
    private double a;
    public Pentagon()
	{
    }
    public Pentagon(double _a)
    {
        a = _a;
    }
    public Pentagon(double _a, String _color, boolean _filled)
    {
        super(_color,_filled);
        a = _a;
    }
    public double getA () 
    {
        return a;
    }
    public void setA (double a)
    {
        this.a = a;
    }
    public double getPerimeter()
	{
		return 5 * a;
    }
    public double getArea()
    {
        return Math.sqrt(25 + 10 * Math.sqrt(5)) * a * a / 4;
    }
    public void howToFill () 
    {
        System.out.println("Put the color in the pentagon");
    }
}