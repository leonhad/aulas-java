/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     20/05/2020 16:31:27                          */
/*==============================================================*/


/*==============================================================*/
/* Table: ALUNO                                                 */
/*==============================================================*/
create table ALUNO (
   ID_ALUNO             SERIAL               not null,
   NM_ALUNO             VARCHAR(200)         not null,
   NR_CPF               NUMERIC(11)          not null,
   DT_NASCIMENTO        DATE                 null,
   constraint PK_ALUNO primary key (ID_ALUNO)
);

/*==============================================================*/
/* Index: ALUNO_PK                                              */
/*==============================================================*/
create unique index ALUNO_PK on ALUNO (
ID_ALUNO
);

/*==============================================================*/
/* Table: ALUNO_DISCIPLINA                                      */
/*==============================================================*/
create table ALUNO_DISCIPLINA (
   ID_DISCIPLINA        INT4                 not null,
   ID_ALUNO             INT4                 not null,
   constraint PK_ALUNO_DISCIPLINA primary key (ID_DISCIPLINA, ID_ALUNO)
);

/*==============================================================*/
/* Index: ALUNO_DISCIPLINA_PK                                   */
/*==============================================================*/
create unique index ALUNO_DISCIPLINA_PK on ALUNO_DISCIPLINA (
ID_DISCIPLINA,
ID_ALUNO
);

/*==============================================================*/
/* Index: FK_ALUNO_DISCIPLINA_FK                                */
/*==============================================================*/
create  index FK_ALUNO_DISCIPLINA_FK on ALUNO_DISCIPLINA (
ID_ALUNO
);

/*==============================================================*/
/* Index: FK_DISCIPLINA_ALUNO_FK                                */
/*==============================================================*/
create  index FK_DISCIPLINA_ALUNO_FK on ALUNO_DISCIPLINA (
ID_DISCIPLINA
);

/*==============================================================*/
/* Table: CURSO                                                 */
/*==============================================================*/
create table CURSO (
   ID_CURSO             SERIAL               not null,
   NM_CURSO             VARCHAR(100)         not null,
   constraint PK_CURSO primary key (ID_CURSO)
);

/*==============================================================*/
/* Index: CURSO_PK                                              */
/*==============================================================*/
create unique index CURSO_PK on CURSO (
ID_CURSO
);

/*==============================================================*/
/* Table: DISCIPLINA                                            */
/*==============================================================*/
create table DISCIPLINA (
   ID_DISCIPLINA        SERIAL               not null,
   ID_CURSO             INT4                 null,
   NM_DISCIPLINA        VARCHAR(100)         not null,
   NR_CARGA_HORARIA     DECIMAL(5,2)         not null,
   constraint PK_DISCIPLINA primary key (ID_DISCIPLINA)
);

/*==============================================================*/
/* Index: DISCIPLINA_PK                                         */
/*==============================================================*/
create unique index DISCIPLINA_PK on DISCIPLINA (
ID_DISCIPLINA
);

/*==============================================================*/
/* Index: FK_DISCIPLINA_CURSO_FK                                */
/*==============================================================*/
create  index FK_DISCIPLINA_CURSO_FK on DISCIPLINA (
ID_CURSO
);

alter table ALUNO_DISCIPLINA
   add constraint FK_ALUNO_DI_FK_ALUNO__ALUNO foreign key (ID_ALUNO)
      references ALUNO (ID_ALUNO)
      on delete restrict on update restrict;

alter table ALUNO_DISCIPLINA
   add constraint FK_ALUNO_DI_FK_DISCIP_DISCIPLI foreign key (ID_DISCIPLINA)
      references DISCIPLINA (ID_DISCIPLINA)
      on delete restrict on update restrict;

alter table DISCIPLINA
   add constraint FK_DISCIPLI_FK_DISCIP_CURSO foreign key (ID_CURSO)
      references CURSO (ID_CURSO)
      on delete restrict on update restrict;

