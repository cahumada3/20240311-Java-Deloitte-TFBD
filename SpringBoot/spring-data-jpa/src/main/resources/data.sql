/*

    used by the h2 database duing application startup

    populates table with data
    
*/

/* make sure to insert directors first */
insert into DIRECTORS (first_name, last_name) values ('Carma', 'Baine');
insert into DIRECTORS (first_name, last_name) values ('Isa', 'Phibb');
insert into DIRECTORS (first_name, last_name) values ('Karalynn', 'Caw');
insert into DIRECTORS (first_name, last_name) values ('Codie', 'Sally');
insert into DIRECTORS (first_name, last_name) values ('Rozamond', 'Rumbellow');

insert into MOVIES (movie_title, rating, director_id) values ('Friend Zone (Pagafantas)', 2, 2);
insert into MOVIES (movie_title, rating, director_id) values ('Kismet', 5, 1);
insert into MOVIES (movie_title, rating, director_id) values ('Casanova', 6, 2);
insert into MOVIES (movie_title, rating, director_id) values ('Extreme Ops', 2, 1);
insert into MOVIES (movie_title, rating, director_id) values ('Goodbye First Love', 7, 2);
insert into MOVIES (movie_title, rating, director_id) values ('Woman''s Face, A (En kvinnas ansikte) ', 8, 4);
insert into MOVIES (movie_title, rating, director_id) values ('French Film', 9, 1);
insert into MOVIES (movie_title, rating, director_id) values ('Hitting Home', 7, 1);
insert into MOVIES (movie_title, rating, director_id) values ('Contracted', 7, 3);
insert into MOVIES (movie_title, rating, director_id) values ('Room with a View, A', 3, 1);
insert into MOVIES (movie_title, rating, director_id) values ('40 Pounds of Trouble', 3, 1);
insert into MOVIES (movie_title, rating, director_id) values ('Easy A', 4, 4);
insert into MOVIES (movie_title, rating, director_id) values ('Grouse', 8, 5);
insert into MOVIES (movie_title, rating, director_id) values ('Mind Game', 4, 4);
insert into MOVIES (movie_title, rating, director_id) values ('Bye Bye Monkey (Ciao maschio)', 9, 3);
insert into MOVIES (movie_title, rating, director_id) values ('Three on a Weekend', 2, 1);
insert into MOVIES (movie_title, rating, director_id) values ('Legend of Hell House, The', 8, 5);
insert into MOVIES (movie_title, rating, director_id) values ('Teeth', 9, 4);
insert into MOVIES (movie_title, rating, director_id) values ('Kull the Conqueror', 3, 1);
insert into MOVIES (movie_title, rating, director_id) values ('Seconds Apart ', 9, 2);
insert into MOVIES (movie_title, rating, director_id) values ('Brain, The', 5, 4);
insert into MOVIES (movie_title, rating, director_id) values ('All Fall Down', 8, 4);
insert into MOVIES (movie_title, rating, director_id) values ('Bopha!', 4, 1);
insert into MOVIES (movie_title, rating, director_id) values ('Avengers: Infinity War', 10, 4);
insert into MOVIES (movie_title, rating, director_id) values ('Avengers: Endgame', 9, 2);

