CREATE TABLE comments
(
    comment_id   serial       not null
        constraint comments_pkey primary key,
    username     varchar(100) not null,
    comment_date timestamp    not null,
    comment      text         not null
);

alter table comments
    owner to tis;

create function create_comment(date timestamp without time zone, usr character varying, comm text) returns boolean
    security definer
    language plpgsql
as
$$
BEGIN
    INSERT INTO tis.comments(comment_date, username, comment) values (date, usr, comm);
    RETURN true;
END
$$;

alter function create_comment(timestamp, varchar, text) owner to tis;