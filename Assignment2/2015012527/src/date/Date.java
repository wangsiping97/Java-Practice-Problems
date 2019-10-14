package date;

public class Date {
    private int year;
    private int month;
    private int day;
    Date (String strDate) {
        String[] arrDate = strDate.split("\\.");
        String strMonth = arrDate[0];
        switch (strMonth) {
            case "Jan" : month = 1; break;
            case "Feb" : month = 2; break;
            case "Mar" : month = 3; break;
            case "Apr" : month = 4; break;
            case "May" : month = 5; break;
            case "Jun" : month = 6; break;
            case "Jul" : month = 7; break;
            case "Aug" : month = 8; break;
            case "Sept" : month = 9; break;
            case "Oct" : month = 10; break;
            case "Nov" : month = 11; break;
            default : month = 12;
        }
        String temp = arrDate[1].replace(" ", "");
        day = Integer.parseInt(temp.split(",")[0]);
        year = Integer.parseInt(temp.split(",")[1]);
    }
    Date (String strMonth, int _day, int _year) {
        day = _day;
        year = _year;
        switch (strMonth) {
            case "Jan." : month = 1; break;
            case "Feb." : month = 2; break;
            case "Mar." : month = 3; break;
            case "Apr." : month = 4; break;
            case "May." : month = 5; break;
            case "Jun." : month = 6; break;
            case "Jul." : month = 7; break;
            case "Aug." : month = 8; break;
            case "Sept." : month = 9; break;
            case "Oct." : month = 10; break;
            case "Nov." : month = 11; break;
            default : month = 12;
        }
    }
    Date (int _year, int _month, int _day) {
        year = _year;
        month = _month;
        day = _day;
    }
    public String print() {
        return year + "/" + month + "/" + day;
    }
}