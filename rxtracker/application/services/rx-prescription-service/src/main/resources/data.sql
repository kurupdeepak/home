truncate table prescription;
truncate table unit_type;
truncate table usage_interval;

insert into prescription (prescription_id, active, date_of_purchase, prescribed_by, rx_name, rx_prescribed_unit, rx_unit_type, rx_usage_interval, user_id) values (1, true, CURRENT_TIMESTAMP(), 'Family Doctor','Januvia', 100, 'mg', '1', 1);
insert into prescription (prescription_id, active, date_of_purchase, prescribed_by, rx_name, rx_prescribed_unit, rx_unit_type, rx_usage_interval, user_id) values (2, true, CURRENT_TIMESTAMP(), 'Family Doctor','Metaformin', 1000, 'mg', '2',1);

insert into unit_type values (1,'MG');
insert into unit_type values (2,'ML');
insert into unit_type values (3,'G');

insert into usage_interval values (1,'DAILY_ONCE');
insert into usage_interval values (2,'DAILY_TWICE');
insert into usage_interval values (3,'DAILY_THRICE');
insert into usage_interval values (4,'MORNING_ONLY');
insert into usage_interval values (5,'AFTERNOON_ONLY');
insert into usage_interval values (6,'EVERY_4HOURS');
insert into usage_interval values (7,'EVERY_8HOURS');
insert into usage_interval values (8,'EVERY_null2HOURS');
insert into usage_interval values (9,'FASTING_MORNING');
insert into usage_interval values (10,'BEFORE_SLEEP');

commit;