prompt PL/SQL Developer import file
prompt Created on 2024年2月11日 by 86188
set feedback off
set define off
prompt Disabling triggers for SALESMAN...
alter table SALESMAN disable all triggers;
prompt Deleting SALESMAN...
delete from SALESMAN;
commit;
prompt Loading SALESMAN...
insert into SALESMAN (sid, spassword, sname)
values (1000000000, '111111', '张三');
insert into SALESMAN (sid, spassword, sname)
values (1000000001, '111111', '王五');
commit;
prompt 2 records loaded
prompt Enabling triggers for SALESMAN...
alter table SALESMAN enable all triggers;
set feedback on
set define on
prompt Done.
