-- noinspection SqlNoDataSourceInspectionForFile

create table author
(
    id   integer generated by default as identity,
    name varchar(255),
    primary key (id)
);
create table book
(
    id    integer generated by default as identity,
    title varchar(255),
    primary key (id)
);