CREATE TABLE tournaments (
    id INT NOT NULL,
    name VARCHAR(50),
    ls_id INT,
    created_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    PRIMARY KEY(id)
);