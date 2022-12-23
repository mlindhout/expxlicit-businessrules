create table `users` (
    id int primary key,
    firstname varchar(15) not null,
    lastname varchar(25) not null,
    gender varchar(10) not null,
    date_of_birth varchar(15) not null
);

insert into `users` (id, firstname, lastname, gender, date_of_birth) values
(1, 'John', 'Doe', 'male', '1954-01-01'),
(2, 'Bill', 'Gates', 'male', '1956-05-21'),
(3, 'Barack', 'Obama', 'male', '1962-02-14'),
(4, 'Jill', 'Buzz', 'female', '1960-03-09'),
(5, 'Tita', 'Tovenaar', 'female', '2000-03-09')
;
