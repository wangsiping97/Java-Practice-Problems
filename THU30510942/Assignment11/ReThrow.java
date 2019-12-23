public class ReThrow {
    public static void f()throws Exception{
        throw new Exception("Exception: f()");
    }

    public static void g() throws Exception{
        try{
            f();
        }catch(Exception e){
            System.out.println("inside g()");
            throw e;
        }
    }
    public static void main(String[] args){
        try{
            g();
        }
        catch(Exception e){
            System.out.println("inside main() function");
            e.printStackTrace(System.out);
        }
    }
}