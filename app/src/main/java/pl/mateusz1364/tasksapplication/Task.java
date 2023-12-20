package pl.mateusz1364.tasksapplication;

public class Task {
    private final String dateWithName;
    private final String description;
    private final String reporter;
    private final String city;
    private final String street;

    public Task(String dateWithName, String description, String reporter,
                String city, String street) {
        this.dateWithName = dateWithName;
        this.description = description;
        this.reporter = reporter;
        this.city = city;
        this.street = street;
    }

    public String getDateWithName() {
        return dateWithName;
    }

    public String getDescription() {
        return description;
    }

    public String getReporter() {
        return reporter;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }
}