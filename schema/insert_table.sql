use
HospitalManagement;

#doctor
insert into doctor value('BS01', 'Identity_Number01_BS', 'Ninh Xuan Huan', '1998-05-20','Ha Noi',5,'DaiHoc','Than Kinh','Bac Si');
insert into doctor value('BS02', 'Identity_Number02_BS', 'Nguyen HaiPhuong', '1994-07-31','Ha Noi',10,'DaiHoc','Tim','Truong Khoa');
insert into doctor value('BS03', 'Identity_Number03_BS', 'Bui Thi Thu Huong', '1994-12-31','Ha Noi',15,'DaiHoc','Phoi','Truong Phong');
insert into doctor value('BS04', 'Identity_Number04-BS', 'Nguyen Si Dinh', '1996-05-20','Ha Noi',4,'DaiHoc','Than Kinh','Bac Si');
insert into doctor value('BS05', 'Identity_Number05-BS', 'Vu Manh Cuong', '1996-07-31','Ha Noi',7,'DaiHoc','Tim','Truong Phong');
insert into doctor value('BS06', 'Identity_Number06-BS', 'Nguyen Huong Giang', '1991-12-31','Ha Noi',15,'DaiHoc','Phoi','Truong Khoa');
insert into doctor value('BS07', 'Identity_Number07-BS', 'Nguyen Duc Truong', '1994-05-20','Ha Noi',5,'DaiHoc','Than Kinh','Truong Khoa');
insert into doctor value('BS08', 'Identity_Number08-BS', 'Trinh Van Dai', '1999-07-31','Ha Noi',10,'DaiHoc','Tim','Bac Si');
insert into doctor value('BS09', 'Identity_Number09-BS', 'Nguyen Hong Thom', '1996-12-31','Ha Noi',15,'DaiHoc','Phoi','Bac Si');
insert into doctor value('BS10', 'Identity_Number10-BS', 'Le Duc Nam', '1998-12-31','Ha Noi',15,'DaiHoc','Tim','Bac Si');


#patient
insert into patient value('BN01', 'Identity_Number11_BN', 'Pham Phuong Nam ', '1997-12-31','Ha Noi','123456789');
insert into patient value('BN02', 'Identity_Number12_BN', 'Nguyen Dang Trua', '1999-12-31','Ha Noi','123456787');
insert into patient value('BN03', 'Identity_Number13_BN', 'Do Tien Dat', '1998-12-31','Ha Noi','123456788');
insert into patient value('BN04', 'Identity_Number14_BN', 'Tran Thanh Binh', '1996-12-31','Ha Noi','123456789');
insert into patient value('BN05', 'Identity_Number15_BN', 'Tran Van Phuong', '1998-12-31','Ha Noi','123456787');
insert into patient value('BN06', 'Identity_Number16_BN', 'Le Minh Tien', '1997-12-31','Ha Noi','123456788');
insert into patient value('BN07', 'Identity_Number17_BN', 'Vu Ngoc Sang', '1998-12-31','Ha Noi','123456789');
insert into patient value('BN08', 'Identity_Number18_BN', 'Tran Thu Nguyet', '1998-12-31','Ha Noi','123456787');
insert into patient value('BN09', 'Identity_Number19_BN', 'Pham The Duy', '1998-12-31','Ha Noi','123456788');
insert into patient value('BN10', 'Identity_Number20_BN', 'Nguyen Duc Hieu', '1998-12-31','Ha Noi','123456788');

#nurse
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone) values ("YT01","Identity_Number21_YT","Vu Van Minh","1993-09-01","Dong Da","3","Dai Hoc","0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone)
values ("YT02", "Identity_Number22_YT", "Nghiem Tuan Anh", "1993-09-01", "Hoan Kiem", "5", "Dai Hoc", "0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone)
values ("YT03", "Identity_Number23_YT", "Ha Van Chieu", "1993-09-01", "Ha Cau", "7", "Dai Hoc", "0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone)
values ("YT04", "Identity_Number24_YT", "Do Toan Thang", "1993-09-01", "Thanh Xuan", "4", "Dai Hoc", "0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone)
values ("YT05", "Identity_Number25_YT", "Luu Hai Son", "1993-09-01", "Van Khe", "2", "Dai Hoc", "0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone)
values ("YT06", "Identity_Number26_YT", "Vuong Dinh Bac", "1993-09-01", "Dong Da", "2", "Dai Hoc", "0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone)
values ("YT07", "Identity_Number27_YT", "Hoang Van Giap", "1993-09-01", "Hanoi", "6", "Dai Hoc", "0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone)
values ("YT08", "Identity_Number28_YT", "Duong Tuan Anh", "1993-09-01", "Van Khe", "2", "Dai Hoc", "0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone)
values ("YT09", "Identity_Number29_YT", "Hoang The Nam", "1993-09-01", "Dong Da", "2", "Dai Hoc", "0983000000");
insert into nurse(ID_Nurse, Identity_Number, Name_Nurse, DOB, Address, Exp, Diploma, Phone)
values ("YT10", "Identity_Number30_YT", "Hoang Anh Tu", "1993-09-01", "Hanoi", "6", "Dai Hoc", "0983000000");


#disease
insert into disease value('Tam than phan liet');
insert into disease value('Tim');
insert into disease value('Soi than');
insert into disease value('Tieu duong');
insert into disease value('Roi loan tien liet tuyen');
insert into disease value('Roi loan tien dinh');
insert into disease value('Tri');

#examination
insert into examination ( id_doctor , id_patient , name_disease , at_time) values ('BS01', 'BN01','Tam than phan liet','2020-07-31');
insert into examination (id_doctor, id_patient, name_disease, at_time)
values ('BS01', 'BN02', 'Soi than', '2020-07-03');
insert into examination (id_doctor, id_patient, name_disease, at_time)
values ('BS02', 'BN03', 'Tieu duong', '2020-07-31');
insert into examination (id_doctor, id_patient, name_disease, at_time)
values ('BS02', 'BN04', 'Tieu duong', '2020-07-03');
insert into examination (id_doctor, id_patient, name_disease, at_time)
values ('BS03', 'BN05', 'Soi than', '2020-07-31');
insert into examination (id_doctor, id_patient, name_disease, at_time)
values ('BS03', 'BN06', 'Soi than', '2020-07-03');
insert into examination (id_doctor, id_patient, name_disease, at_time)
values ('BS04', 'BN07', 'Roi loan tien liet tuyen', '2020-07-31');
insert into examination (id_doctor, id_patient, name_disease, at_time)
values ('BS04', 'BN08', 'Roi loan tien dinh', '2020-07-03');
insert into examination (id_doctor, id_patient, name_disease, at_time)
values ('BS01', 'BN01', 'Tri', '2020-07-05');
insert into examination (id_doctor, id_patient, name_disease, at_time)
values ('BS05', 'BN09', 'Tim', '2020-06-05');
insert into examination (id_doctor, id_patient, name_disease, at_time)
values ('BS05', 'BN05', 'Tim', '2020-05-05');
insert into examination (id_doctor, id_patient, name_disease, at_time)
values ('BS06', 'BN10', 'Tieu duong', '2020-04-05');
insert into examination (id_doctor, id_patient, name_disease, at_time)
values ('BS04', 'BN04', 'Tam than phan liet', '2020-06-15');
insert into examination (id_doctor, id_patient, name_disease, at_time)
values ('BS02', 'BN10', 'Tieu duong', '2020-06-05');

#med
insert into medicine values('ACB',12000,'uong');
insert into medicine
values ('DEF', 15000, 'uong');
insert into medicine
values ('GHI', 17000, 'tiem');
insert into medicine
values ('KLM', 11000, 'tiem');

#treatment
insert into treatment(id_examination,id_doctor_cure,id_nurse,at_time,status) value(1,'BS02','YT01','2020-08-12',0);
insert into treatment(id_examination, id_doctor_cure, id_nurse, at_time, status) value(1,'BS02','YT01','2020-08-12',0);
insert into treatment(id_examination, id_doctor_cure, id_nurse, at_time, status) value(1,'BS02','YT01','2020-08-12',1);
insert into treatment(id_examination, id_doctor_cure, id_nurse, at_time, status) value(1,'BS03','YT03','2020-08-12',1);
insert into treatment(id_examination, id_doctor_cure, id_nurse, at_time, status) value(3,'BS02','YT03','2020-08-12',1);
insert into treatment(id_examination, id_doctor_cure, id_nurse, at_time, status) value(3,'BS02','YT02','2020-08-12',0);
insert into treatment(id_examination, id_doctor_cure, id_nurse, at_time, status) value(3,'BS03','YT02','2020-08-14',1);


#medlist
insert into medicine_list(name_medicine,id_treatment,id_nurse) values('ACB',1,'YT01');
insert into medicine_list(name_medicine, id_treatment, id_nurse)
values ('DEF', 1, 'YT01');
insert into medicine_list(name_medicine, id_treatment, id_nurse)
values ('GHI', 2, 'YT01');
insert into medicine_list(name_medicine, id_treatment, id_nurse)
values ('KLM', 2, 'YT01');

#service
insert into service values('Chup X quang',120000);
insert into service
values ('Xet nghiem mau', 150000);

#servicelist
insert into service_list(name_service , id_treatment) values('Chup X quang',1);
insert into service_list(name_service, id_treatment)
values ('Xet nghiem mau', 1);

