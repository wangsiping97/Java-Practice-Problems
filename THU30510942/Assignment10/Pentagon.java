public class Pentagon extends GeometricObject implements Fillable 
{
    private double s1;
    private double s2;
    private double s3;
    private double s4;
    private double s5;
    public Pentagon()
	{
    }
    public Pentagon(double _s1, double _s2, double _s3, double _s4, double _s5)
    {
        s1 = _s1;
        s2 = _s2;
        s3 = _s3;
        s4 = _s4;
        s5 = _s5;
    }
    public Pentagon(double _s1, double _s2, double _s3, double _s4, double _s5, String _color, boolean _filled)
    {
        super(_color,_filled);
        s1 = _s1;
        s2 = _s2;
        s3 = _s3;
        s4 = _s4;
        s5 = _s5;
    }
    public double getS1 () 
    {
        return s1;
    }
    public double getS2 () 
    {
        return s2;
    }
    public double getS3 () 
    {
        return s3;
    }
    public double getS4 () 
    {
        return s4;
    }
    public double getS5 () 
    {
        return s5;
    }
    public void setS1 (double s)
    {
        s1 = s;
    }
    public void setS2 (double s)
    {
        s2 = s;
    }
    public void setS3 (double s)
    {
        s3 = s;
    }
    public void setS4 (double s)
    {
        s4 = s;
    }
    public void setS5 (double s)
    {
        s5 = s;
    }
    public double getPerimeter()
	{
		return s1 + s2 + s3 + s4 + s5;
	}
    public void howToFill () 
    {
        System.out.println("Put the color in the pentagon");
    }
}