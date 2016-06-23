--test_stand_select_perf.sh jdbc:mysql://localhost:8066/TESTDB test test 10 100000 "file=mydata-select.sql"
sql=select * from travelrecord where id = ${int(1-1000000)}