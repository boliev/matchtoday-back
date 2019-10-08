CREATE TABLE matches (
    id serial NOT NULL,
    home_team_id INT,
    guest_team_id INT,
    tournament_id INT,
    tournament_stage_id INT,
    ls_id VARCHAR(50),
    datetime TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    created_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    PRIMARY KEY(id)
);

ALTER TABLE matches ADD CONSTRAINT matches_home_team_id FOREIGN KEY (home_team_id) REFERENCES teams (id) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE matches ADD CONSTRAINT matches_guest_team_id FOREIGN KEY (guest_team_id) REFERENCES teams (id) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE matches ADD CONSTRAINT matches_tournament_id FOREIGN KEY (tournament_id) REFERENCES tournaments (id) NOT DEFERRABLE INITIALLY IMMEDIATE;
ALTER TABLE matches ADD CONSTRAINT matches_tournament_stage_id FOREIGN KEY (tournament_stage_id) REFERENCES tournament_stages (id) NOT DEFERRABLE INITIALLY IMMEDIATE;