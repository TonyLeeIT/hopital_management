use
HospitalManagement;

select count(examination.id_examination) as time_diagnostic , examination.id_examination , doctor.name_doctor , patient.name_patient , examination.name_disease   from (
		(examination inner join doctor on examination.id_doctor = doctor.id_doctor ) inner join patient on examination.id_patient = patient.id_patient
) group  by examination.id_doctor , examination.id_patient , examination.name_disease ;

# Liệt kê danh sách các loại bệnh được các bệnh nhân mắc phải trong tháng 7/2020, các bệnh được sắp xếp theo thứ tự số bệnh nhân đến khám giảm dần
select distinct p.name_patient , e.name_disease , e.at_time  ,  count(e.id_examination) as numOfPatient
	from examination e inner join patient p on e.id_patient = p.id_patient  
	where DATEDIFF ('2020-07-31', e.at_time) < 31
    group by name_patient , name_disease 
    order by numOfPatient desc;
    
    
    
select e.id_examination , d.id_doctor , (select id_nurse from nurse )  from(
		examination e inner join doctor d on e.id_doctor = d.id_doctor
);

select p.name_patient , e.name_disease from patient p left join examination e  on p.id_patient  = e.id_patient ;


