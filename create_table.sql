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
    id_doctor      varchar(10) not null,
    id_patient     varchar(10) not null,
    name_disease   varchar(50) not null,
    at_time date not null,
    primary key (id_examination),
    foreign key (name_disease) references disease (name),
    foreign key (id_doctor) references doctor (id_doctor),
    foreign key (id_patient) references patient (id_patient)
);



create table treatment
(
    id_treatment   int auto_increment,
    id_examination int         not null,
    id_doctor_cure varchar(10) not null,
    id_nurse       varchar(10) not null,
    at_time        date        not null,
    status         bool        not null,
    primary key (id_treatment),
    foreign key (id_examination) references examination (id_examination),
    foreign key (id_doctor_cure) references doctor (id_doctor),
    foreign key (id_nurse) references nurse (id_nurse)
);

create table medicine
(
    name     varchar(50),
    price    float       not null,
    used_for varchar(50) not null,
    primary key (name)
);

create table medicine_treatment
(
    name_medicine varchar(50),
    id_treatment  int,
    id_nurse      varchar(10),
    primary key (name_medicine, id_treatment, id_nurse),
    foreign key (name_medicine) references medicine (name),
    foreign key (id_treatment) references treatment (id_treatment),
    foreign key (id_nurse) references nurse (id_nurse)
);


create table `service`
(
    name_service varchar(50),
    price        float not null,
    primary key (name_service)
);

create table `service_treatment`
(
    name_service varchar(50),
    id_treatment int,
    primary key (name_service, id_treatment),
    foreign key (id_treatment) references `treatment` (id_treatment),
    foreign key (name_service) references `service` (name_service)
);







