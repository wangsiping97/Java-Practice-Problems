public class Test {
    public static void main (String[] args) {
        Organization org = new Organization ("一个机构名字");
        System.out.println(org.toString());
        Company com = new Company ("一个公司名字");
        com.setScale(Company.Scale.LOCAL);
        System.out.println(com.toString());
        // System.out.println(com.getScale());
        University uni = new University ("清华大学");
        System.out.println(uni.toString());
        School sch = new School ("清华大学经管学院");
        System.out.println(sch.toString());
        Office off = new Office ("一个办公室名字");
        System.out.println(off.toString());
    }
}