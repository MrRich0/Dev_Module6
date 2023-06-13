INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY)
VALUES ('James Smith', '1985-04-23', 'Senior', 15000),
       ('Emily Johnson', '1990-09-15', 'Middle', 9000),
       ('Benjamin Davis', '1995-02-02', 'Junior', 1200),
       ('Olivia Brown', '1988-12-31', 'Middle', 7000),
       ('William Taylor', '1987-06-12', 'Senior', 25000),
       ('Sophia Martinez', '1991-11-08', 'Trainee', 700),
       ('Samuel Anderson', '1984-08-05', 'Senior', 17000),
       ('Ava Wilson', '1992-03-19', 'Middle', 11000),
       ('Alexander Thompson', '1989-07-27', 'Junior', 1500),
       ('Mia Rodriguez', '1993-05-10', 'Trainee', 500);

INSERT INTO client (NAME)
VALUES ('ABC Company'),
       ('XYZ Corporation'),
       ('123 Industries'),
       ('Acme Ltd.'),
       ('Global Solutions');

INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE)
VALUES (1, '2022-01-01', '2022-02-28'),
       (2, '2022-03-15', '2022-06-30'),
       (1, '2022-07-10', '2022-12-31'),
       (3, '2022-09-01', '2022-10-31'),
       (2, '2017-11-15', '2023-01-31'),
       (4, '2023-02-10', '2023-05-31'),
       (3, '2023-07-15', '2023-12-31'),
       (5, '2018-09-01', '2023-10-31'),
       (4, '2023-11-15', '2024-01-31'),
       (2, '2012-09-07', '2024-02-18');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID)
VALUES (1, 3),
       (1, 8),
       (1, 5),
       (2, 1),
       (2, 3),
       (3, 7),
       (4, 1),
       (4, 10),
       (4, 9),
       (4, 6),
       (4, 2),
       (5, 4),
       (5, 10),
       (5, 3);