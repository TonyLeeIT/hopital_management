
DELIMITER //
create definer=`root`@`localhost` procedure `PR_TREATMENT` (
		in id_nurse_value varchar(10),
   		in status_value bool,
		out  insert_message  varchar(20))
		language sql
        not deterministic
        contains sql
        sql security definer
        comment 'Automated insertion to treatment and examination tables'
begin
		DECLARE `_rollback` BOOL DEFAULT 0;
		DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
		START TRANSACTION;
              
		insert into treatment(
			id_examination ,
			id_doctor_cure,
			id_nurse,
			at_time, 
			status)
		select  e.id_examination , d.id_doctor , id_nurse_value ,
				now() ,status_value 
		from
			examination e inner join doctor d on e.id_doctor = d.id_doctor;
		set insert_message = 'insert success';
            
		IF `_rollback` THEN
			ROLLBACK;
		ELSE
			COMMIT;
		END IF;
    
end//
DELIMITER ;

drop procedure if exists PR_TREATMENT;

DELIMITER //
create definer=`root`@`localhost` procedure `PK_INSERT`
			(
			in id_doctor_value varchar(10) ,
			in id_patient_value varchar(10),
			in name_disease_value varchar(50),
            IN name_disease varchar(50),
			OUT a_message VARCHAR(50))
BEGIN
		DECLARE `_rollback` BOOL DEFAULT 0;
		DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET `_rollback` = 1;
		START TRANSACTION;
		
		insert into examination(
        id_doctor,
        id_patient,
        name_disease,
        at_time
        )values(id_doctor_value ,id_patient_value , name_disease_value , now() );
		
		INSERT INTO disease (name)
		values (name_disease);
        set a_message = 'Database updated';
        
	    IF `_rollback` THEN
			ROLLBACK;
		ELSE
			COMMIT;
		END IF;
    
end//
DELIMITER ;
drop procedure if exists PK_DISEASE;

call PK_INSERT('BS07','BN09','thoi tai','Liet duong', @a_message);
select @a_message;

call PR_TREATMENT( 'YT10','2020-08-02' ,'1',@insert_message);
select @insert_message;	
        