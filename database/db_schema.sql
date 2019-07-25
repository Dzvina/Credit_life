# set default_storage_engine =InnoDB;
#
# use CCP;
#
# # CREATE USER 'dzvina'@'localhost' IDENTIFIED BY 'dzvina1';
# # GRANT ALL ON *.* TO 'dzvina'@'localhost'

drop table if exists credit;

create table credit
(
  credit_id   int auto_increment,
  customer_id int,
  product_id int,
  name_credit varchar(255),
  primary key (credit_id)
);

drop table if exists customer;

create table customer
(
  customer_id         int auto_increment,
  first_name_customer varchar(255),
  last_name_customer  varchar(255),
  pesel_customer      varchar(255),
  primary key (customer_id)
);

drop table if exists product;

create table product
(
  credit_id    int,
  product_name varchar(255),
  value        int,
  primary key (credit_id)
);