SELECT * FROM ROLE
SELECT * FROM USERS
SELECT * FROM USER_roles

--INGRESAR EN ESE ORDEN PARA MANTENER EL MISMO ID
INSERT INTO ROLE VALUES ('Estudiante')
INSERT INTO ROLE VALUES ('Administrador')
INSERT INTO ROLE VALUES ('OrgSocial')
INSERT INTO ROLE VALUES ('Emprendimiento')
INSERT INTO ROLE VALUES ('Coordinador')
INSERT INTO ROLE VALUES ('Docente')
INSERT INTO ROLE VALUES ('Preinscrito')

USE [AANTIK]
GO

INSERT INTO [dbo].[user_roles]
           ([usuario_id]
           ,[role_id])
     VALUES
           (1,2)
GO

INSERT INTO USERS VALUES ('123','ESTUDIANTE@PRUEBA')
INSERT INTO USERS VALUES ('123','admin@PRUEBA')
INSERT INTO USERS VALUES ('111','OrgSocial@PRUEBA')
INSERT INTO USERS VALUES ('111','emprendimiento@PRUEBA')
INSERT INTO USERS VALUES ('111','docente@PRUEBA')
INSERT INTO USERS VALUES ('000','preinscrito@PRUEBA')
INSERT INTO USERS VALUES ('124','user@holi.com')

--primera columna es el id del usuario, segunda columna es el id del rol
INSERT INTO user_roles VALUES ('10','1')
INSERT INTO user_roles VALUES ('11','2')
INSERT INTO user_roles VALUES ('12','3')
INSERT INTO user_roles VALUES ('13','4')
INSERT INTO user_roles VALUES ('14','6')
INSERT INTO user_roles VALUES ('15','7')

--Ejemplo de update
update user_roles set role_id='5' where usuario_id='1'




------SQL GABRIEL
INSERT INTO ROLEs_gabo VALUES ('Estudiante')
INSERT INTO ROLEs_gabo VALUES ('Administrador')
INSERT INTO ROLEs_gabo VALUES ('OrgSocial')
INSERT INTO ROLEs_gabo VALUES ('Emprendimiento')
INSERT INTO ROLEs_gabo VALUES ('Coordinador')
INSERT INTO ROLEs_gabo VALUES ('Docente')
INSERT INTO ROLEs_gabo VALUES ('Preinscrito')

INSERT INTO ROLEs_gabo VALUES ('ROLE_STUDIANTE')
INSERT INTO ROLEs_gabo VALUES ('ROLE_ADMIN')
INSERT INTO ROLEs_gabo VALUES ('ROLE_ORGANIZACION')
INSERT INTO ROLEs_gabo VALUES ('ROLE_EMP')
INSERT INTO ROLEs_gabo VALUES ('ROLE_COORDINADOR')
INSERT INTO ROLEs_gabo VALUES ('ROLE_DOCENTE')
INSERT INTO ROLEs_gabo VALUES ('ROLE_PREINSCRITO')


DROP TABLE PROFESOR_USER
DROP TABLE ADMIN_USER
DROP TABLE COORDINADOR_USER
DROP TABLE EMPRENDIMIENTO_USER
DROP TABLE ESTUDIANTE_USER
DROP TABLE ORGSOCIAL_USER
DROP TABLE PROFESOR 
DROP TABLE USER_ROLES
DROP TABLE USERS 
DROP TABLE ADMIN
DROP TABLE COORDINADOR
DROP TABLE EMPRENDIMIENTO
DROP TABLE ESTUDIANTE
DROP TABLE ORG_SOCIAL





DROP TABLE PROFESOR 
DROP TABLE USERS 
DROP TABLE ADMIN
DROP TABLE COORDINADOR
DROP TABLE emprendimiento_user
DROP TABLE EMPRENDIMIENTO
DROP TABLE ESTUDIANTE
DROP TABLE ORG_SOCIAL
DROP TABLE PREGUNTAS_DIG
DROP TABLE rubrica_preg_dg

SELECT * FROM PROFESOR
SELECT * FROM USERS
SELECT * FROM preguntas_dig
SELECT * FROM rubrica_preg_dg

rollback

SELECT * FROM ROLE
delete from role where id=10007

EXEC sp_help rubrica_preg_dg

delete from USERS where id>10
