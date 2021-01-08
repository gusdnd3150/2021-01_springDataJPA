CREATE TABLE USERS(
	id INT NOT NULL auto_increment,
	email varchar (100) NOT NULL,
	name varchar (25) NOT NULL,
	password varchar (50) NOT NULL,
	
	primary key (id)

);

insert into users values(1, 'gusdnd3150@gmail.com','woong','123');