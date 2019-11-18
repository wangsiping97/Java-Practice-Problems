public class School extends University {
    private String field;
    School (String _name) {
        super(_name);
    }
    public void setField (String _field) {
        field = _field;
    }
    public String getField () {
        return field;
    }
    public String toString () {
        return "School: " + getName();
    }
}