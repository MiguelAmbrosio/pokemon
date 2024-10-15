DROP TABLE IF EXISTS BITACORA_POKEMON_API;

CREATE TABLE BITACORA_POKEMON_API (
                          ID_BITACORA_POKEMON LONG AUTO_INCREMENT  PRIMARY KEY,
                          IP_ORIGEN VARCHAR(10) NOT NULL,
                          FECHA TIMESTAMP NOT NULL,
                          METODO VARCHAR(250) NOT NULL,
                          TIEMPO_MILISEGUNDOS 	VARCHAR(500)  NOT NULL,
                          REQUEST VARCHAR(500) NOT NULL
                          );


