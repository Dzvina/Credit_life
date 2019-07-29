drop table if exists product;

create table product
(
  product_id    int auto_increment,
  product_name varchar(255),
  value        int,
  primary key (product_id)
);

insert into product values (1,'test product name 1',100);
insert into product values (2,'test product name 2',200);
insert into product values (3,'test product name 3',300);