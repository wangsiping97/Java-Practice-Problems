public class Office extends University {
    private String service_area;
    Office (String _name) {
        super(_name);
    }
    public void setServiceArea (String _area) {
        service_area = _area;
    }
    public String getServiceArea () {
        return service_area;
    }
    public String toString () {
        return "Office: " + getName();
    }
}