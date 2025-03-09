package by.epam.employee.model;

public class Employee {
    private Long id;
    private String firstName;
    private String SecondName;
    private String timeFrom;
    private String timeTo;

    public Employee() {
    }

    public Employee(Long id, String firstName, String secondName, String timeFrom, String timeTo) {
        this.id = id;
        this.firstName = firstName;
        SecondName = secondName;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public String getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(String timeFrom) {
        this.timeFrom = timeFrom;
    }

    public String getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(String timeTo) {
        this.timeTo = timeTo;
    }

    @Override
    public String toString() {
        return id + "/" + firstName + "/" +
                SecondName + "/" + timeFrom + "/" + timeTo;
    }
}