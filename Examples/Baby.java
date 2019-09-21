public class Baby {
    String name;
    double weight;
    boolean isMale;
    int numPoops = 0; // [定义类时]成员变量直接赋值
    int age = 0; // 编译器在 new 对象的时候才赋值，赋值在创建完对象后才有空间完成
    Baby[] siblings; // 递归定义，在 C 语言中编译不过

    Baby (String myname, double myweight, boolean male) { // [创建对象时]成员变量在构造函数中赋值
        name = myname;
        weight = myweight;
        isMale = male;
    }
    void poop() {}
    void sayHi() {}
    void eat(double foodWeight) {
        weight += foodWeight;
    }

    public static void main(String[] arguments) {
        Baby dawa = new Baby("大娃", 20, true);
        System.out.println(dawa.name); // 访问成员变量
    }
}