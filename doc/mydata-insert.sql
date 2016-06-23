--test_stand_insert_perf.bat jdbc:mysql://localhost:8066/TESTDB test test 10 "file=mydata-insert.sql"
total=10000
batch=10000
autocommit
sql=insert into edu_educircle (username,eduCircleTopicID) values ('${char([0-9]6:6)}' ,${int(10-999)})