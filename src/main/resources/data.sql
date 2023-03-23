INSERT INTO book (title)
VALUES ('Bible'),
       ('The Decameron'),
       ('The Life of Dante'),
       ('The Great Gatsby'),
       ('The Curious Case of Benjamin Buttons');

INSERT INTO author (name)
VALUES ('Giovanni Bocacchio'),
       ('F. Scott Fitzgerald');

INSERT INTO author_books(author_id, books_id)
VALUES (1,2),
       (1,3),
       (2,4),
       (2,5);