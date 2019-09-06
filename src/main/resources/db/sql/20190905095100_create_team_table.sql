CREATE TABLE teams (
    id INT NOT NULL,
    name varchar(50) not null,
    country varchar(2),
    created_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    PRIMARY KEY(id)
);