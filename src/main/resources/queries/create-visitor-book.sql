DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS visitor;
DROP TABLE IF EXISTS visitor_book;

CREATE TABLE IF NOT EXISTS book
(
	id SERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	author TEXT NOT NULL,
	publishingYear INTEGER,
	isbn VARCHAR(32),
	publisher TEXT
);

INSERT INTO book (name, author, publishingYear, isbn, publisher)
VALUES
('The Lord of the Rings', 'J.R.R. Tolkien', 1954, '0395026468', 'Allen & Unwin'),
('To Kill a Mockingbird', 'Harper Lee', 1960, '0446310759', 'HarperPerennial'),
('The Fault in Our Stars', 'John Green', 2012, '0316038746', 'Dutton'),
('The Book Thief', 'Markus Zusak', 2005, '0375831004', 'Knopf'),
('The Shack', 'William P. Young', 2007, '0316067860', 'Windblown Media'),
('The Kite Runner', 'Khaled Hosseini', 2003, '0385506982', 'Riverhead Books'),
('The Nightingale', 'Kristin Hannah', 2015, '0385387035', 'St. Martin''s Press'),
('Pride and Prejudice', 'Jane Austen', 1813, '0525472125', 'Penguin Classics'),
('1984', 'George Orwell', 1949, '0451534852', 'Signet Classics'),
('The Hitchhiker''s Guide to the Galaxy', 'Douglas Adams', 1979, '034539082X', 'Del Rey'),
('The Great Gatsby', 'F. Scott Fitzgerald', 1925, '0743273567', 'Scribner'),
('Harry Potter and the Philosopher''s Stone', 'J.K. Rowling', 1997, '0747532735', 'Bloomsbury'),
('Brave New World', 'Aldous Huxley', 1932, '0060860495', 'Harper Perennial'),
('The Hunger Games', 'Suzanne Collins', 2008, '0439023483', 'Scholastic'),
('The Catcher in the Rye', 'J.D. Salinger', 1951, '0316769487', 'Little, Brown'),
('The Alchemist', 'Paulo Coelho', 1988, '0060920508', 'HarperOne'),
('The Da Vinci Code', 'Dan Brown', 2003, '0385504209', 'Doubleday'),
('Gone Girl', 'Gillian Flynn', 2012, '0316205775', 'Crown'),
('The Girl on the Train', 'Paula Hawkins', 2015, '0007555445', 'Riverhead Books'),
('The Martian', 'Andy Weir', 2011, '0553418438', 'Crown');

CREATE TABLE IF NOT EXISTS visitor
(
	id SERIAL PRIMARY KEY,
	name TEXT NOT NULL,
	surname TEXT NOT NULL,
	phone VARCHAR(32),
	subscribed BOOLEAN NOT NULL
);

INSERT INTO visitor (name, surname, phone, subscribed)
VALUES
('John', 'Doe', '123-456-7890', TRUE),
('Jane', 'Smith', '987-654-3210', FALSE),
('Michael', 'Johnson', '555-123-4567', TRUE),
('Emily', 'Brown', '555-987-6543', TRUE),
('David', 'Wilson', '555-111-2222', FALSE),
('Olivia', 'Miller', '555-333-4444', TRUE),
('William', 'Davis', '555-555-5555', TRUE),
('Sophia', 'Garcia', '555-666-7777', FALSE),
('James', 'Martinez', '555-888-9999', TRUE),
('Isabella', 'Anderson', '555-000-1111', FALSE),
('Ethan', 'Taylor', '555-222-3333', TRUE),
('Ava', 'Thomas', '555-444-5555', TRUE),
('Jack', 'Hill', '555-666-7777', TRUE),
('Lily', 'Jones', '555-777-8888', TRUE),
('Oliver', 'Baker', '555-888-9999', TRUE);

CREATE TABLE IF NOT EXISTS visitor_book
(
    visitor_id INTEGER,
    book_id INTEGER,
    PRIMARY KEY (visitor_id, book_id),
    FOREIGN KEY (visitor_id) REFERENCES visitor(id) ON DELETE CASCADE,
    FOREIGN KEY (book_id) REFERENCES book(id) ON DELETE CASCADE
);

INSERT INTO visitor_book (visitor_id, book_id)
VALUES
(1, 1), (1, 2), (1, 3), (1, 4), (1, 5), (1, 6), (1, 7),
(2, 8), (2, 9), (3, 10), (3, 11), (4, 12), (4, 1),(5, 9), 
(5, 13), (6, 8), (6, 14), (7, 15), (7, 11), (8, 2), (8, 14),
(9, 10), (9, 1), (10, 8), (10, 11), (10, 16), (10, 17),
(11, 15), (11, 14), (11, 18), (12, 2), (12, 14), (13, 10), 
(13, 11), (14, 8), (14, 14), (14, 18), (14, 19), (14, 20),
(15, 15), (15, 11), (15, 7);

