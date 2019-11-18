public class University extends Organization {
    private int number;
    private MyDate found_date;
    University (String _name) {
        super(_name);
    }
    public void setNumber (int _number) {
        number = _number;
    }
    public void setFoungDate (MyDate _date) {
        found_date = _date;
    }
    public int getNumber () {
        return number;
    }
    public MyDate getFoundDate () {
        return found_date;
    }
    public String toString () {
        return "University: " + getName();
    }
}