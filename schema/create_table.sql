create
database HospitalManagement;
use
HospitalManagement;

create table doctor
(
    id_doctor       varchar(10),
    identity_number varchar(20)  not null unique,
    name_doctor     varchar(50)  not null,
    dob             date         not null,
    address         varchar(255) not null,
    exp             int          not null,
    diploma         varchar(20)  not null,
    field           varchar(50)  not null,
    position        varchar(20)  not null,
    primary key (id_doctor)
);

create table nurse
(
    id_nurse        varchar(10),
    identity_number varchar(20)  not null unique,
    name_nurse      varchar(50)  not null,
    dob             date         not null,
    address         varchar(255) not null,
    exp             int          not null,
    diploma         varchar(20)  not null,
    phone           varchar(20)  not null,
    primary key (id_nurse)
);

create table patient
(
    id_patient      varchar(10),
    identity_number varchar(20)  not null unique,
    name_patient    varchar(50)  not null,
    dob             date         not null,
    address         varchar(255) not null,
    phone           varchar(20)  not null,
    primary key (id_patient)
);

create table disease
(
    name varchar(50),
    primary key (name)
);

create table examination
(
    id_examination int auto_increment,
    id_doctor      varchar(10),
    id_patient     varchar(10),
    name_disease   varchar(50),
    primary key (id_examination),
    foreign key (id_doctor) references doctor (id_doctor),
    foreign key (id_patient) references patient (id_patient)
);

alter table examination
    add at_time date;

create table treatment
(
    id_treatment   int auto_increment,
    id_examination int,
    id_doctor_cure varchar(10) not null,
    at_time        date        not null,
    status         bool        not null,
    primary key (id_treatment),
    foreign key (id_examination) references examination (id_examination),
    foreign key (id_doctor_cure) references doctor (id_doctor)
);


