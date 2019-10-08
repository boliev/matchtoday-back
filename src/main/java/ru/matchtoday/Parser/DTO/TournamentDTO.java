package ru.matchtoday.Parser.DTO;

public class TournamentDTO {
    private String id;
    private String name;

    public TournamentDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
