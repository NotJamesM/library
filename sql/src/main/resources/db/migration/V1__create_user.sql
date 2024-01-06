create role library_read_write
login
password '${libraryRolePassword}'
connection limit 100;

create table books(
    book_id serial primary key,
    title varchar(100) not null,
    author varchar(100) null
);

grant all on books to library_read_write;