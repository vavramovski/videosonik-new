select *
from product

select *
from wishlist

select * 
from users

select * 
from cart

select * 
from review


alter table cart drop constraint fkaa9qhq6fvvem83i229mh67c2k cascade


create table admin(
	username varchar references users(username),
	privileges int	
);