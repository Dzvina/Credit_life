drop table if exists productDto;

create table productDto
(
  product_id    int auto_increment,
  product_name varchar(255),
  value        int,
  primary key (product_id)
);