INSERT INTO author (name)
VALUES ('Giovanni Bocacchio'),
       ('F. Scott Fitzgerald'),
       ('Marc'),
       ('Lucas'),
       ('Paul'),
       ('Matthew');

INSERT INTO book (title, author_id)
VALUES ('Bible', null),
       ('The Decameron', 1),
       ('The Life of Dante', 1),
       ('The Great Gatsby', 2),
       ('The Curious Case of Benjamin Buttons', 2);

INSERT INTO books_authors(authors_id, books_id)
VALUES (1, 2),
       (1, 3),
       (2, 4),
       (2, 5),
       (3, 1),
       (4, 1),
       (5, 1),
       (6, 1);