package pl.mateusz1364.tasksapplication.client.dto;

public class TaskDto {
    private String name;
    private String description;
    private Long createAtMs;
    private String reporterFirstName;
    private String reporterLastName;
    private String streetWithNumber;
    private String city;

    public TaskDto(String name, String description, Long createAtMs, String reporterFirstName,
                   String reporterLastName, String streetWithNumber, String city) {
        this.name = name;
        this.description = description;
        this.createAtMs = createAtMs;
        this.reporterFirstName = reporterFirstName;
        this.reporterLastName = reporterLastName;
        this.streetWithNumber = streetWithNumber;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCreateAtMs() {
        return createAtMs;
    }

    public void setCreateAtMs(Long createAtMs) {
        this.createAtMs = createAtMs;
    }

    public String getReporterFirstName() {
        return reporterFirstName;
    }

    public void setReporterFirstName(String reporterFirstName) {
        this.reporterFirstName = reporterFirstName;
    }

    public String getReporterLastName() {
        return reporterLastName;
    }

    public void setReporterLastName(String reporterLastName) {
        this.reporterLastName = reporterLastName;
    }

    public String getStreetWithNumber() {
        return streetWithNumber;
    }

    public void setStreetWithNumber(String streetWithNumber) {
        this.streetWithNumber = streetWithNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}