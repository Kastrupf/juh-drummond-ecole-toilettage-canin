CREATE TABLE user (
	id BIGINT(20) PRIMARY KEY,
	email VARCHAR(50) NOT NULL,
	prenom VARCHAR(100) NOT NULL,
    nom VARCHAR(100) NOT NULL,
	password VARCHAR(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE role (
	id BIGINT(20) PRIMARY KEY,
	name VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE users_roles (
	user_id BIGINT(20) NOT NULL,
	role_id BIGINT(20) NOT NULL,
	PRIMARY KEY (user_id, role_id),
	FOREIGN KEY (user_id) REFERENCES user(id),
	FOREIGN KEY (role_id) REFERENCES role(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user (id, email, prenom, nom, password) values (1, 'admin@modula.com', 'Admin', 'Modula', '$2a$10$X607ZPhQ4EgGNaYKt3n4SONjIv9zc.VMWdEuhCuba7oLAL5IvcL5.');
INSERT INTO user (id, email, prenom, nom, password) values (2, 'maria@modula.com', 'Maria', 'Silva', '$2a$10$Zc3w6HyuPOPXamaMhh.PQOXvDnEsadztbfi6/RyZWJDzimE8WQjaq');

INSERT INTO role (id, name) values (1, 'ROLE_LISTER_CLIENTS');
INSERT INTO role (id, name) values (2, 'ROLE_CHERCHER_CLIENT');

-- admin
INSERT INTO users_roles (user_id, role_id) values (1, 1);
INSERT INTO users_roles (user_id, role_id) values (1, 2);
