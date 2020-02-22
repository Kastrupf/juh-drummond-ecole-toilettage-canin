CREATE TABLE client (
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nom VARCHAR(60) NOT NULL,
	prenom VARCHAR(60),
	email VARCHAR(60) NOT NULL,
	message VARCHAR(255)NOT NULL,
	datetime DATETIME
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO client (nom, prenom, email, message, datetime) values ('DUMOND', 'Patricia', 'dumondp@email.com', 'message test', sysdate());
