CREATE TABLE BOARD(
	boardnum INT NOT NULL auto_increment,
	id INT NOT NULL,
	title varchar (25) NOT NULL,
	content varchar (2000) NOT NULL,
	updateday date DEFAULT NOW(),
	
	primary key (boardnum)
	
    
)


