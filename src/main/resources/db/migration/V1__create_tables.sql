CREATE TABLE balances
(
    id          UUID PRIMARY KEY,
    name        VARCHAR(255) UNIQUE NOT NULL,
    balance_usd DOUBLE PRECISION    NOT NULL DEFAULT 0
);

CREATE TABLE transactions
(
    id         UUID PRIMARY KEY,
    type       VARCHAR(20)      NOT NULL,
    amount     DOUBLE PRECISION NOT NULL,
    currency   VARCHAR(10)      NOT NULL,
    timestamp  TIMESTAMP        NOT NULL,
    balance_id UUID REFERENCES balances (id) ON DELETE CASCADE
);
