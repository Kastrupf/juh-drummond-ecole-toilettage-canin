CREATE TABLE client (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nom VARCHAR(60) NOT NULL,
	prenom VARCHAR(60),
	email VARCHAR(60) NOT NULL,
	message VARCHAR(255)NOT NULL,
	date_envoie_message DATE NOT NULL,
	ip_adresse VARCHAR(255)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO client (nom, prenom, email, message, date_envoie_message) values ('DUMOND', 'Patricia', 'dumondp@email.com', 'message test', NOW());
