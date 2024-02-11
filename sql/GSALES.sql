prompt PL/SQL Developer import file
prompt Created on 2024Äê2ÔÂ11ÈÕ by 86188
set feedback off
set define off
prompt Disabling triggers for GSALES...
alter table GSALES disable all triggers;
prompt Disabling foreign key constraints for GSALES...
alter table GSALES disable constraint FK_GOODS;
alter table GSALES disable constraint FK_SALESMAN;
prompt Deleting GSALES...
delete from GSALES;
commit;
prompt Loading GSALES...
insert into GSALES (gsid, gid, sid, sdate, snum)
values (1000000004, 1000000004, 1000000000, to_timestamp('11-02-2024 10:51:52.310000', 'dd-mm-yyyy hh24:mi:ss.ff'), 7);
insert into GSALES (gsid, gid, sid, sdate, snum)
values (1000000002, 1000000001, 1000000000, to_timestamp('26-01-2024 13:27:23.973000', 'dd-mm-yyyy hh24:mi:ss.ff'), 7);
insert into GSALES (gsid, gid, sid, sdate, snum)
values (1000000003, 1000000000, 1000000000, to_timestamp('06-02-2024 14:06:05.039000', 'dd-mm-yyyy hh24:mi:ss.ff'), 7);
commit;
prompt 3 records loaded
prompt Enabling foreign key constraints for GSALES...
alter table GSALES enable constraint FK_GOODS;
alter table GSALES enable constraint FK_SALESMAN;
prompt Enabling triggers for GSALES...
alter table GSALES enable all triggers;
set feedback on
set define on
prompt Done.
