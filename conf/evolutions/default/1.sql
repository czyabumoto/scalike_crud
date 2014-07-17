# --- !Ups
create table campaigns (
	campaign_id int not null auto_increment,
	campaign_name varchar(100),
	daily_budget int,
	total_budget int,
	status int not null default 0,
	primary key (campaign_id)
);
# --- !Downs
drop table campaigns;