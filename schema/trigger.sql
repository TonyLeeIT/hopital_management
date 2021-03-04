use
`HospitalManagement`;

#Trigger
cho rang buoc *Mot benh nhan chi duoc dieu tri duy nhat boi 1 y ta trong 1 qua trinh dieu tri*
DELIMITER //
create trigger checkNurseTreatment
    before insert
    on treatment
    for each row
begin
    declare id_nurse_existed varchar(10);
				set id_nurse_existed := '';

    select distinct id_nurse
    into id_nurse_existed
    from treatment
    where id_examination = new.id_examination
      and new.status = 0 limit 1;

    if new.id_nurse != id_nurse_existed and id_nurse_existed != ''
        then begin signal sqlstate '45000' set message_text ='*A patient has to stick to ONLY ONE NURSE during the treatment process*';
end;
end if;
end
//

drop trigger checkNurseTreatment;

#Trigger
cho rang buoc *Mot benh nhan chi duoc dieu tri duy nhat boi 1 bac si trong 1 qua trinh dieu tri*
DELIMITER //
create trigger checkDoctorTreatment
    before insert
    on treatment
    for each row
begin
    declare id_doctor_cure_existed varchar(10);
				set id_doctor_cure_existed := '';

    select distinct id_doctor_cure
    into id_doctor_cure_existed
    from treatment
    where id_examination = new.id_examination
      and new.status = 0 limit 1;

    if new.id_doctor_cure != id_doctor_cure_existed  and id_doctor_cure_existed != ''
        then begin signal sqlstate '45000' set message_text ='*A patient has to stick to ONLY ONE DOCTOR during the treatment process*';
end;
end if;
end
//

drop trigger checkDoctorTreatment;

