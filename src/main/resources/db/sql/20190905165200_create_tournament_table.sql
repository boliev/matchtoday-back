CREATE TABLE tournaments (
    id serial NOT NULL,
    name VARCHAR(50),
    country VARCHAR(10),
    ls_id VARCHAR(50),
    is_active BOOLEAN,
    created_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    updated_at TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
    PRIMARY KEY(id)
);