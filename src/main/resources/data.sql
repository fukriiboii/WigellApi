INSERT INTO Address(street, postal_code, city)
VALUES ('Storgatan 1', '12345', 'Stockholm'),
       ('Lillgatan 2', '67890', 'Göteborg'),
       ('Mellangatan 3', '11223', 'Malmö'),
       ('Huvudgatan 4', '45678', 'Uppsala'),
       ('Bredgatan 5', '90123', 'Lund');

INSERT INTO Members(first_name, last_name, address_id, email, phone_number, date_of_birth)
VALUES ('Anna', 'Andersson', 1, 'anna@example.com', '0737638976', '1990-01-01'),
       ('Bengt', 'Bengtsson', 2, 'bengt@example.com', '0723647432', '1995-02-02'),
       ('Carl', 'Carlsson', 3, 'carl@example.com', '0730988909', '2000-03-03'),
       ('David', 'Davidsson', 4, 'david@example.com', '0731245464', '1985-04-04'),
       ('Eva', 'Eriksson', 5, 'eva@example.com', '0731765445', '1992-05-05');
