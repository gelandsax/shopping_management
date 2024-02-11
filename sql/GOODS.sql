prompt PL/SQL Developer import file
prompt Created on 2024年2月11日 by 86188
set feedback off
set define off
prompt Disabling triggers for GOODS...
alter table GOODS disable all triggers;
prompt Deleting GOODS...
delete from GOODS;
commit;
prompt Loading GOODS...
insert into GOODS (gid, gname, gprice, gnum)
values (1000000000, '苹果', 12, 93);
insert into GOODS (gid, gname, gprice, gnum)
values (1000000001, '橘子', 7, 93);
insert into GOODS (gid, gname, gprice, gnum)
values (1000000004, '草莓', 8, 43);
commit;
prompt 3 records loaded
prompt Enabling triggers for GOODS...
alter table GOODS enable all triggers;
set feedback on
set define on
prompt Done.
