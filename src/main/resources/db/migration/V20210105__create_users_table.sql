CREATE TABLE USERS(
	id INT NOT NULL auto_increment,
	email varchar (100) NOT NULL,
	name varchar (25) NOT NULL,
	password varchar (100) NOT NULL,
	
	primary key (id)

);

insert into users values(1, 'gusdnd3150@gmail.com','woong','$2a$10$fPHB8UbYJzVx2jMVH6YCNeQjxkOvt2EZlBaO.xSs2fpbf6q6StfNe');