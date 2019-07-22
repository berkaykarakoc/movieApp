create table movie (id bigint not null auto_increment, comment varchar(255), name varchar(255), rating varchar(255), movie_list_id bigint, primary key (id)) engine=InnoDB;
create table movie_list (id bigint not null auto_increment, name varchar(255), primary key (id)) engine=InnoDB;
alter table movie add constraint FKqrln8h6xp7d4mwl9a35kpko85 foreign key (movie_list_id) references movie_list (id);
