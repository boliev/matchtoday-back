CREATE TABLE tournament_stages (
    id INT NOT NULL,
    tournament_id INT,
    name varchar(50),
    created_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    PRIMARY KEY(id)
);

ALTER TABLE tournament_stages ADD CONSTRAINT tournament_stages_tournament_id FOREIGN KEY (tournament_id) REFERENCES tournaments (id) NOT DEFERRABLE INITIALLY IMMEDIATE;