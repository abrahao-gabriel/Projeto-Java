CREATE TABLE IF NOT EXISTS musica (
	id serial PRIMARY KEY,
	nome varchar(80),
	artista varchar(80),
	gravadora varchar(80),
	estilo varchar(30)
);

CREATE TABLE IF NOT EXISTS artista (
	id serial PRIMARY KEY,
	nome varchar(80),
	email varchar(60)
);

CREATE TABLE IF NOT EXISTS gravadora (
	id serial PRIMARY KEY,
	nome varchar(80),
	email varchar(60)
);