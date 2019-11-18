public class Company extends Organization {
    public static enum Scale {PERSONAL, LOCAL, INTERNATIONAL};
    private Scale scale;
    Company (String _name) {
        super(_name);
    }
    public void setScale (Scale _scale) {
        scale = _scale;
    }
    public Scale getScale () {
        return scale;
    }
    public String toString () {
        return "Company: " + getName();
    }
}