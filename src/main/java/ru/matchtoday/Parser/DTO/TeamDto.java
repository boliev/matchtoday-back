package ru.matchtoday.Parser.DTO;

public class TeamDto {
    private String id;
    private String name;
    private String country;

    public TeamDto(String id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public TeamDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
