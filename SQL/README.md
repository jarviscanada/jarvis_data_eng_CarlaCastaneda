##### Part 1: Data Modeling
##### Exercise 1: Please write SQL statements to create the following tables

``` create Table members {
memid int primarykey NOT NULL,
surname varchar(200) NOT NULL,
firstname varchar(200) NOT NULL,
address varchar(300) NOT NULL,
zipcode int NOT NULL,
telephone varchar(20) NOT NULL,
recommendedby in Foreign Key references members(memid) NOT NULL,
joindate timestamp NOT NULL
}
```

``` create Table cd.facilities{
facid int serial primary key NOT NULL,
name varchar(100) NOT NULL,
membercost numeric NOT NULL,
guestcost numeric NOT NULL,
initaloutlay numeric NOT NULL,
monthlymaintencance numeric NOT NULL


}

```

``` create Table cd.bookings{
facid int serial primary key NOT NULL,
memid in foreign key references members(memid),
starttime timestamp NOT NULL,
slots int NOT NULL

}
```

##### Part 2: Practice SQL Queries
##### Modifying Data

#####Question 1:insert

``` INSERT into cd.facilities (facid,name,membercost,guestcost,initialoutlay, monthlymaintenance) values (9,'Spa',20,30,100000,800)
```
##### Question 2: insert
``` INSERT into cd.facilities (facid, name,membercost,guestcost,initialoutlay,monthlymaintenance) values ((SELECT COUNT(*) FROM cd.facilities,'Spa',20,30,100000,800)
```
##### Question 3 :Update
``` UPDATE cd.facilities SET initialoutlay = 10000 WHERE facid = 1 ```

#####Question 4
```creat ```

##### Question 5

##### Question 6

