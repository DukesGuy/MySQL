drop table if exists comment;
drop table if exists post;
drop table if exists user;

create table user (
	username varchar(20) not null,
    first_name varchar(20) not null,
    last_name varchar (20) not null,
    email varchar(128) not null,
    password varchar(20) not null,
    phone_number varchar(10),
    primary key (username)
);

create table post (
	post_id int not null auto_increment,
    username varchar(20) not null,
    content varchar(255) not null,
    time_posted datetime not null default current_timestamp,
    primary key (post_id),
    foreign key (username) references user (username)
);

create table comment (
	comment_id int not null auto_increment,
    username varchar(20) not null,
    post_id int not null,
    comment varchar(255) not null,
    time_posted datetime not null default current_timestamp,
    primary key (comment_id),
    foreign key (username) references user (username),
    foreign key (post_id) references post (post_id)
);
