--liquibase formatted sql
--changeset ewcode:2022-01-31-17:36-init-project splitStatements:true endDelimiter:;

CREATE
EXTENSION moddatetime;

CREATE TABLE "user"
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255)        NOT NULL,
    email      VARCHAR(255) UNIQUE NOT NULL,
    created_at TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP           NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TRIGGER mdt_updated_at_user
    BEFORE UPDATE
    ON "user"
    FOR EACH ROW
    EXECUTE PROCEDURE moddatetime (updated_at);

CREATE TABLE "category"
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(255) NOT NULL,
    created_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TRIGGER mdt_updated_at_category
    BEFORE UPDATE
    ON "category"
    FOR EACH ROW
    EXECUTE PROCEDURE moddatetime (updated_at);

CREATE TABLE "transaction"
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(255)   NOT NULL,
    amount      DECIMAL(10, 2) NOT NULL,
    category_id BIGINT NULL,
    user_id     BIGINT NULL,
    created_at  TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at  TIMESTAMP      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_category_transaction FOREIGN KEY (category_id) REFERENCES "category" (id) ON DELETE SET NULL,
    CONSTRAINT fk_user_transaction FOREIGN KEY (user_id) REFERENCES "user" (id) ON DELETE SET NULL
);

CREATE TRIGGER mdt_updated_at_transaction
    BEFORE UPDATE
    ON "transaction"
    FOR EACH ROW
    EXECUTE PROCEDURE moddatetime (updated_at);

-- rollback DROP TABLE transaction
-- rollback DROP TABLE category
-- rollback DROP TABLE user
