--liquibase formatted sql
--changeset KDA-1
--author TheMidgart

create table if not exists person
(
    id         uuid primary key,
    created    timestamp,
    created_by varchar(32),
    updated    timestamp,
    updated_by varchar(32),
    first_name varchar(32),
    last_name  varchar(32),
    email      varchar(32) unique,
    age        integer,
    status     varchar(15)
)

--rollback drop table person