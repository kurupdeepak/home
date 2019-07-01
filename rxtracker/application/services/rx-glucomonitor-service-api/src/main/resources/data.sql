truncate table gluco_monitor_entry;
insert into gluco_monitor_entry (entry_id, level_entered, level_entry_time, notes, user_id) values (1, 4.5, current_timestamp(), 'Test Entry 1', 1);
insert into gluco_monitor_entry (entry_id, level_entered, level_entry_time, notes, user_id) values (2, 5.5, current_timestamp(), 'Test Entry 2', 1);
commit;