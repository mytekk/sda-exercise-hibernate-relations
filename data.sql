create table if not exists address(
	id int primary key auto_increment,
	city varchar(64),
	street varchar(64),
	number int
);

create table if not exists person(
	id int primary key auto_increment,
	first_name varchar(64),
	last_name varchar(64),
	address_id int,
	foreign key (address_id) references address(id)
);

create table if not exists identity_card(
	id int primary key auto_increment,
	series varchar(64),
	number varchar(64),
	person_id int,
	foreign key (person_id) references person(id)
);

create table if not exists bank_account(
	id int primary key auto_increment,
	bank varchar(64),
	number varchar(64),
	person_id int,
	foreign key (person_id) references person(id)
);

create table if not exists skill(
	id int primary key auto_increment,
	name varchar(64),
	level varchar(64)
);

create table if not exists person_skill(
	id int primary key auto_increment,
	person_id int,
	skill_id int,
	foreign key (person_id) references person(id),
	foreign key (skill_id) references skill(id)
);

insert into address values(1, "Poznań", "Głogowska", 3);
insert into address values(2, "Warszawa", "Marszałkowska", 5);

insert into person values(1, "Adam", "Borkowski", 1);
insert into person values(2, "Cezary", "Dąbrowski", 1);
insert into person values(3, "Eustachy", "Frąckowiak", 1);
insert into person values(4, "Grzegorz", "Hazak", 2);
insert into person values(5, "Ireneusz", "Jóźwiak", 2);
insert into person values(6, "Karol", "Linda", 2);

insert into identity_card values(1, "ATF", "205717", 1);
insert into identity_card values(2, "AKU", "042932", 2);
insert into identity_card values(3, "AHG", "356333", 3);
insert into identity_card values(4, "AUY", "922809", 4);
insert into identity_card values(5, "AXY", "388088", 5);
insert into identity_card values(6, "AKC", "177715", 6);

insert into bank_account values(1, "Idea Bank", "65 1950 0001 0254 5119 2764 7324", 1);
insert into bank_account values(2, "ING Bank Śląski", "41 1050 1025 7125 8081 4875 10404", 1);
insert into bank_account values(3, "Kredyt Bank", "18 1500 1070 6938 4249 4886 9977", 2);
insert into bank_account values(4, "BNP Paribas", "34 1600 1172 4686 8736 2413 1730", 2);
insert into bank_account values(5, "Bank Zachodni WBK", "70 1090 2734 5289 9301 9295 3532", 3);
insert into bank_account values(6, "Bank Handlowy", "31 1030 1465 9076 4487 7427 8547", 3);

insert into skill values(1, "język angielski", "biegle w mowie i piśmie");
insert into skill values(2, "język francuski", "biegle w mowie i piśmie");
insert into skill values(3, "język hiszpański", "biegle w mowie i piśmie");
insert into skill values(4, "język niemiecki", "biegle w mowie i piśmie");
insert into skill values(5, "język rosyjski", "biegle w mowie i piśmie");

insert into person_skill values(1, 1, 1);
insert into person_skill values(2, 1, 2);
insert into person_skill values(3, 2, 2);
insert into person_skill values(4, 2, 3);
insert into person_skill values(5, 3, 3);
insert into person_skill values(6, 3, 4);
insert into person_skill values(7, 4, 4);
insert into person_skill values(8, 4, 5);
insert into person_skill values(9, 5, 5);
insert into person_skill values(10, 5, 1);
insert into person_skill values(11, 6, 1);
insert into person_skill values(12, 6, 2);
insert into person_skill values(13, 6, 3);
