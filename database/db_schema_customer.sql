drop table if exists customerDto;

create table customerDto
(
  customer_id         int auto_increment,
  first_name_customer varchar(255),
  last_name_customer  varchar(255),
  pesel_customer      varchar(255),
  primary key (customer_id)
);