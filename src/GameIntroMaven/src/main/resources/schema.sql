create table player(
    id bigserial primary key,
    nickname varchar(30) unique not null,
    score int,
    win_count int,
    loses_count int
);