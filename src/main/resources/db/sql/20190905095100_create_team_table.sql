CREATE TABLE teams (
    id INT NOT NULL,
    name VARCHAR(50) not null,
    country VARCHAR(2),
    ls_id INT,
    created_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    PRIMARY KEY(id)
);