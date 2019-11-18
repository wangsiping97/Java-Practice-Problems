public class Organization {
    private String name;
    private String address;
    private String tel;
    private String email;
    Organization (String _name) {
        name = _name;
    }
    public void setName (String _name) {
        name = _name;
    }
    public void setAddress (String _address) {
        address = _address;
    }
    public void setTel (String _tel) {
        tel = _tel;
    }
    public void setEmail (String _email) {
        email = _email;
    }
    public String getName () {
        return name;
    }
    public String getAddress () {
        return address;
    }
    public String getTel () {
        return tel;
    }
    public String getEmail () {
        return email;
    }
    public String toString () {
        return "Organization: " + name;
    }
}