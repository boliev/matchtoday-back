package ru.matchtoday.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    @JsonIgnore
    private String lsId;

    @JsonIgnore
    private Boolean isActive;

    @CreationTimestamp
    @JsonIgnore
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @JsonIgnore
    private LocalDateTime updatedAt;

    protected Tournament() {
    }

    public Tournament(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public String getLsId() {
        return lsId;
    }

    public void setLsId(String lsId) {
        this.lsId = lsId;
    }

    public String getCountry() {
        return country;
    }
}