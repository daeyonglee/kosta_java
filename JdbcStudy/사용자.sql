/* 유저 생성 */
CREATE TABLE users(
     id VARCHAR2(8),
     name VARCHAR2(20) NOT NULL,
     passwd VARCHAR2(8) NOT NULL,
     email  VARCHAR2(40) NOT NULL,
     CONSTRAINT users_id_pk PRIMARY KEY(id)
);