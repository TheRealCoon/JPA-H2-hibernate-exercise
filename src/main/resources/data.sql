INSERT INTO author (name)
VALUES ('Giovanni Bocacchio'),
       ('F. Scott Fitzgerald');

INSERT INTO book (title, author_id)
VALUES ('Bible', null),
       ('The Decameron', 1),
       ('The Life of Dante', 1),
       ('The Great Gatsby', 2),
       ('The Curious Case of Benjamin Buttons', 2);

-- INSERT INTO author_books(author_id, books_id)
-- VALUES (1,2),
--        (1,3),
--        (2,4),
--        (2,5);