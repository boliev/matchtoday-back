CREATE TABLE leagues_stages (
    id INT NOT NULL,
    league_id INT,
    name varchar(50),
    created_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    PRIMARY KEY(id)
);