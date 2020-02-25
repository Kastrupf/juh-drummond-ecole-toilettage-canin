CREATE TABLE client (
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nom VARCHAR(60) NOT NULL,
	prenom VARCHAR(60),
	email VARCHAR(60) NOT NULL,
	message VARCHAR(255)NOT NULL,
	datetime DATETIME,
	terms BOOL NOT NULL
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO client (nom, prenom, email, message, datetime, terms) values ('DUMOND', 'Patricia', 'dumondp@email.com', 'message test1', sysdate(), TRUE);
INSERT INTO client (nom, prenom, email, message, datetime, terms) values ('ORLANDO', 'Gabriel', 'orlando@email.com', 'message test2', sysdate(), TRUE);
INSERT INTO client (nom, prenom, email, message, datetime, terms) values ('PICARD', 'Patrick', 'picard@email.com', 'message test3', sysdate(), TRUE);
INSERT INTO client (nom, prenom, email, message, datetime, terms) values ('DINDON', 'Vanessa', 'dindon@email.com', 'message test4', sysdate(), TRUE);
