drop table if exists credit;

create table credit
(
  credit_id   int auto_increment,
  customer_id int,
  product_id int,
  name_credit varchar(255),
  primary key (credit_id)
);