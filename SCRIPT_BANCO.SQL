/*
DROP TABLE t_bttf_cachorro;
DROP TABLE t_bttf_carro;
DROP TABLE t_bttf_pessoa;
DROP TABLE t_bttf_endereco;

DROP SEQUENCE SQ_CACHORRO;
DROP SEQUENCE SQ_CARRO;
DROP SEQUENCE SQ_PESSOA;
DROP SEQUENCE SQ_ENDERECO;
*/


--SCRIPT PARA CRIAR AS TABELAS

--CRIAR A TABELA T_BTTF_CACHORRO
CREATE TABLE t_bttf_cachorro (
    cd_cachorro        NUMERIC(3) NOT NULL,
    cd_pessoa          NUMERIC(3),
    nm_cachorro        VARCHAR(30) NOT NULL,
    ds_raca            VARCHAR(30) NOT NULL,
    nr_ano_nascimento  NUMERIC(4) NOT NULL,
    ds_sexo            CHAR(1) NOT NULL,
    ds_cor_pelo        VARCHAR(20) NOT NULL,
    ds_cor_olho        VARCHAR(20) NOT NULL
);

ALTER TABLE t_bttf_cachorro
    ADD CONSTRAINT ck_bttf_cachorro_sexo CHECK ( upper(ds_sexo) IN (
        'M',
        'F'
    ) );

ALTER TABLE t_bttf_cachorro ADD CONSTRAINT pk_bttf_cachorro PRIMARY KEY ( cd_cachorro );

CREATE SEQUENCE SQ_CACHORRO START WITH 6 INCREMENT BY 1 MAXVALUE 999;


--CRIAR A TABELA T_BTTF_CARRO
CREATE TABLE t_bttf_carro (
    cd_carro           NUMERIC(3) NOT NULL,
    cd_pessoa          NUMERIC(3) NOT NULL,
    nm_fabricante      VARCHAR(30) NOT NULL,
    nm_modelo          VARCHAR(30) NOT NULL,
    nr_ano_fabricacao  NUMERIC(4) NOT NULL,
    ds_cor             VARCHAR(20) NOT NULL
);

ALTER TABLE t_bttf_carro ADD CONSTRAINT pk_bttf_carro PRIMARY KEY ( cd_carro );

CREATE SEQUENCE SQ_CARRO START WITH 6 INCREMENT BY 1 MAXVALUE 999;


--CRIAR A TABELA T_BTTF_ENDERECO
CREATE TABLE t_bttf_endereco (
    cd_endereco    NUMERIC(3) NOT NULL,
    sg_estado      CHAR(2) NOT NULL,
    nm_cidade      VARCHAR(30) NOT NULL,
    nm_bairro      VARCHAR(30) NOT NULL,
    ds_logradouro  VARCHAR(40) NOT NULL,
    nr_residencia  NUMERIC(5) NOT NULL
);

ALTER TABLE t_bttf_endereco ADD CONSTRAINT ck_bttf_endereco_residencia CHECK ( nr_residencia >= 0 );

ALTER TABLE t_bttf_endereco ADD CONSTRAINT pk_bttf_endereco PRIMARY KEY ( cd_endereco );

CREATE SEQUENCE SQ_ENDERECO START WITH 6 INCREMENT BY 1 MAXVALUE 999;


--CRIAR A TABELA T_BTTF_PESSOA
CREATE TABLE t_bttf_pessoa (
    cd_pessoa          NUMERIC(3) NOT NULL,
    cd_endereco        NUMERIC(3) NOT NULL,
    nm_pessoa          VARCHAR(50) NOT NULL,
    nr_ano_nascimento  NUMERIC(4) NOT NULL,
    ds_sexo            CHAR(1) NOT NULL,
    ds_cor_pele        VARCHAR(20) NOT NULL,
    ds_cor_cabelo      VARCHAR(20) NOT NULL,
    ds_cor_olho        VARCHAR(20) NOT NULL
);

ALTER TABLE t_bttf_pessoa
    ADD CONSTRAINT ck_bttf_pessoa_sexo CHECK ( upper(ds_sexo) IN (
        'M',
        'F'
    ) );

ALTER TABLE t_bttf_pessoa ADD CONSTRAINT pk_bttf_pessoa PRIMARY KEY ( cd_pessoa );

CREATE SEQUENCE SQ_PESSOA START WITH 6 INCREMENT BY 1 MAXVALUE 999;


--CHAVES ESTRANGEIRAS
ALTER TABLE t_bttf_cachorro
    ADD CONSTRAINT fk_bttf_cachorro_pessoa FOREIGN KEY ( cd_pessoa )
        REFERENCES t_bttf_pessoa ( cd_pessoa );

ALTER TABLE t_bttf_carro
    ADD CONSTRAINT fk_bttf_carro_pessoa FOREIGN KEY ( cd_pessoa )
        REFERENCES t_bttf_pessoa ( cd_pessoa );

ALTER TABLE t_bttf_pessoa
    ADD CONSTRAINT fk_bttf_pessoa_endereco FOREIGN KEY ( cd_endereco )
        REFERENCES t_bttf_endereco ( cd_endereco );





--SCRIPT PARA POPULAR O BD

/*
DELETE FROM T_BTTF_CACHORRO;
DELETE FROM T_BTTF_CARRO;
DELETE FROM T_BTTF_PESSOA;
DELETE FROM T_BTTF_ENDERECO;
*/


--POPULAR A TABELA ENDERECO;
INSERT INTO T_BTTF_ENDERECO VALUES(1, 'CA', 'Hill Valley', 'Lyon Estates', 'Lyon Drive', 9303);
INSERT INTO T_BTTF_ENDERECO VALUES(2, 'CA', 'Hill Valley', 'Desconhecido', 'Riverside Drive', 1640);
INSERT INTO T_BTTF_ENDERECO VALUES(3, 'CA', 'Hill Valley', 'Desconhecido', 'Mason Street', 1809);
INSERT INTO T_BTTF_ENDERECO VALUES(4, 'CA', 'Hill Valley', 'Hilldale', 'Oakhurst Street', 3793);
INSERT INTO T_BTTF_ENDERECO VALUES(5, 'CA', 'Hill Valley', 'Desconhecido', 'Sycamore Street ', 5874);



--POPULAR A TABELA PESSOA
INSERT INTO T_BTTF_PESSOA VALUES(1, 1, 'Marty McFly', 1968, 'M', 'Branca', 'Castanho', 'Azul');
INSERT INTO T_BTTF_PESSOA VALUES(2, 2, 'Emmett Brown', 1908, 'M', 'Branca', 'Branco', 'Castanho');
INSERT INTO T_BTTF_PESSOA VALUES(3, 1, 'George McFly', 1938, 'M', 'Branca', 'Castanho', 'Azul');
INSERT INTO T_BTTF_PESSOA VALUES(4, 1, 'Lorraine Baines', 1938, 'F', 'Branca', 'Castanho', 'Castanho');
INSERT INTO T_BTTF_PESSOA VALUES(5, 3, 'Biff Tannen', 1937, 'M', 'Branca', 'Castanho', 'Azul');



--POPULAR A TABELA CARRO
INSERT INTO T_BTTF_CARRO VALUES( 1, 2, 'DeLorean Motor Company', 'DeLorean DMC-12', 1982, 'Aço');
INSERT INTO T_BTTF_CARRO VALUES( 2, 1, 'Ford', 'F-350', 1984, 'Preto');
INSERT INTO T_BTTF_CARRO VALUES( 3, 3, 'Chevrolet', 'Nova', 1979, 'Branco');
INSERT INTO T_BTTF_CARRO VALUES( 4, 5, 'Ford', 'Super DeLuxe Convertible', 1946, 'Preto');
INSERT INTO T_BTTF_CARRO VALUES( 5, 3, 'BMW', '733i', 1984, 'Azul Escuro');



--POPULAR A TABELA CACHORRO
INSERT INTO T_BTTF_CACHORRO VALUES(1, 2, 'Einstein', 'Pastor-catalão', 1980, 'M', 'Castanho', 'Castanho');
INSERT INTO T_BTTF_CACHORRO VALUES(2, NULL, 'Mel', 'Husky siberiano', 1977, 'F', 'Preto', 'Azul');
INSERT INTO T_BTTF_CACHORRO VALUES(3, NULL, 'Pingo', 'Chihuahua', 1979, 'M', 'Preto', 'Preto');
INSERT INTO T_BTTF_CACHORRO VALUES(4, NULL, 'Maggie', 'Poodle', 1983, 'F', 'Branco', 'Castanho');
INSERT INTO T_BTTF_CACHORRO VALUES(5, NULL, 'Thor', 'Golden Retriever', 1981, 'M', 'Dourado', 'Preto');