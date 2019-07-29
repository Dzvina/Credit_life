drop table if exists customer;

create table customer
(
  customer_id         int auto_increment,
  first_name_customer varchar(255),
  last_name_customer  varchar(255),
  pesel_customer      varchar(255),
  primary key (customer_id)
);


insert into customer values (1,'test first name 1','test last name 1','12345678910');
insert into customer values (2,'test first name 2','test last name 2','12345678911');
insert into customer values (3,'test first name 3','test last name 3','12345678912');