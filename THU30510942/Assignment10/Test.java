import java.lang.reflect.Method;

public class Test 
{
    public static void main (String[] args) throws Exception
    {
        GeometricObject[] array = new GeometricObject[5];
        array[0] = new Circle (2, "white", true);
        array[1] = new Circle (2, "white", false);
        array[2] = new Rectangle(1, 3, "white", true);
        array[3] = new Rectangle(1, 3, "white", false);
        array[4] = new Pentagon(1, 1, 1, 1, 1, "white", false);
        for (GeometricObject obj: array) // de不出bug
        {
            if (obj instanceof Fillable)
            {
                Method method = obj.getClass().getMethod("howToFill");
                method.invoke(obj);
            }
        }
    }
}