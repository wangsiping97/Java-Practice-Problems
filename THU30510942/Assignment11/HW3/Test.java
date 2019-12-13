package HW3;

public class Test 
{
    public static void main (String[] args) 
    {
        try
        {
            Triangle tri = new Triangle (1, 2, 3);
            System.out.println(tri.toString());
        } catch (IllegalTriangleException e) {
            e.printStackTrace();
        }
    }
}