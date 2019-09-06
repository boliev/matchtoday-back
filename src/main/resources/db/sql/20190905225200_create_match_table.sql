CREATE TABLE matches (
    id INT NOT NULL,
    home_team_id INT,
    guest_team_id INT,
    tournament_id INT,
    stage_id INT,
    datetime TIMESTAMP,
    created_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    PRIMARY KEY(id)
);