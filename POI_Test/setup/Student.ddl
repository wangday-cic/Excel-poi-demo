  CREATE TABLE "ROOT"."STUDENT" 
   (	"S_NO" NUMBER NOT NULL ENABLE, 
	"S_NAME" VARCHAR2(20 BYTE), 
	"S_AGE" NUMBER, 
	"S_SEX" VARCHAR2(20 BYTE), 
	"S_GRADE" FLOAT(126)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
