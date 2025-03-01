CREATE DATABASE AGENDA_FINANCEIRA_PODOLOGIA_EXTENSAO;
USE AGENDA_FINANCEIRA_PODOLOGIA_EXTENSAO;

CREATE TABLE USUARIO_LOGIN(
	ID_USUARIO_LOGIN		INT				IDENTITY(1,1) PRIMARY KEY,	
	USUARIO					VARCHAR(80) 	NOT NULL,
	SENHA					VARCHAR(256) 	NOT NULL
);

CREATE TABLE PESSOA (
	ID_PESSOA		INT			   IDENTITY(1,1) PRIMARY KEY,
	NOME	  		VARCHAR(100)   NOT NULL,
	CELULAR_UM		VARCHAR(11)	   NOT NULL,
	CELULAR_DOIS	VARCHAR(11)	   NOT NULL,
);

CREATE TABLE PACIENTE(
	ID_PACIENTE	    INT				IDENTITY(1,1) PRIMARY KEY,
	OBSERVACOES		VARCHAR(500),
	ATIVO			BIT				NOT NULL,
	ID_PESSOA_FK    INT			    NOT NULL,
    FOREIGN KEY (ID_PESSOA_FK) REFERENCES PESSOA(ID_PESSOA)
);

CREATE TABLE PROFISSIONAL(
	ID_PROFISSIONAL   INT			 IDENTITY(1,1) PRIMARY KEY,
	COMISSAO_CLINICA  DECIMAL(10,2)	 NOT NULL,
	ATIVO			  BIT			 NOT NULL,
	ID_PESSOA_FK      INT			 NOT NULL,
    FOREIGN KEY (ID_PESSOA_FK) REFERENCES PESSOA(ID_PESSOA)
);

CREATE TABLE AGENDA(
	ID_AGENDAMENTO			INT				IDENTITY(1,1) PRIMARY KEY,
	DATA_MARCACAO			DATETIME		NOT NULL,
	DATA_AGENDAMENTO		DATE			NOT NULL,
	HORA_INICIO				TIME			NOT NULL,
	HORA_FINAL				TIME			NOT NULL,
	STATUS_ATUAL     		CHAR(1)		    NOT NULL,
	OBSERVACOES				VARCHAR(500),
	ID_PROFISSIONAL_FK		INT		  		NOT NULL,
	ID_PACIENTE_FK			INT		  		NOT NULL,
	FOREIGN KEY (ID_PROFISSIONAL_FK) REFERENCES PROFISSIONAL(ID_PROFISSIONAL),
	FOREIGN KEY (ID_PACIENTE_FK) REFERENCES PACIENTE(ID_PACIENTE)
);

CREATE TABLE CHECKOUT(
	ID_CHECKOUT					INT				IDENTITY(1,1) PRIMARY KEY,
	DATA_FECHAMENTO				DATE			NOT NULL,
	VALOR_DESCONTO				DECIMAL(10,2) 	NOT NULL,
	VALOR_TOTAL					DECIMAL(10,2) 	NOT NULL,
	VALOR_COMISSAO_CLINICA		DECIMAL(10,2) 	NOT NULL,
	OBSERVACOES				    VARCHAR(500),
	ID_AGENDAMENTO_FK			INT		  		NOT NULL,
	FOREIGN KEY (ID_AGENDAMENTO_FK)  REFERENCES AGENDA(ID_AGENDAMENTO),
);

CREATE TABLE DESPESA(
	ID_DESPESA					INT			    IDENTITY(1,1) PRIMARY KEY,
	DATA_LANCAMENTO				DATETIME		NOT NULL,	
	VALOR_DESPESA				DECIMAL(10,2) 	NOT NULL,
	DESCRICAO					VARCHAR(100)	NOT NULL,
	OBSERVACOES					VARCHAR(500),
	ID_PROFISSIONAL_FK			INT		  		NOT NULL,
	FOREIGN KEY (ID_PROFISSIONAL_FK) REFERENCES PROFISSIONAL(ID_PROFISSIONAL)
);