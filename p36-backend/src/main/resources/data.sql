DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id int(11) primary key,
  firstName varchar(255),
  lastName varchar(255),
  username varchar(255),
  email varchar(255),
  password varchar(255),
  role varchar(50)
);

/*
password: duck
*/

INSERT INTO users(id, firstName, lastName, username, email, password, role)
 VALUES (1, 'Donald', 'Duck', 'dd', 'dd@duck.com', '$2a$10$839dntJVZi/hA1uFbMDyOufs2bbGo6gRNQyvUE7r3FiI0Wb1WZMzS', 'ROLE_USER');
