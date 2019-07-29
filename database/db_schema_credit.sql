drop table if exists credit;

create table credit
(
  credit_id   int auto_increment,
  customer_id int,
  product_id int,
  name_credit varchar(255),
  primary key (credit_id)
);

insert into credit values (1,1,1,'test Name 1');
insert into credit values (2,2,2,'test Name 2');
insert into credit values (3,3,3,'test Name 3');
insert into credit values (4,3,2,'test Name 4');