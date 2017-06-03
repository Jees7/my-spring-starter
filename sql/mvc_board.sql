create table mvc_board (
 bId int(4) PRIMARY KEY,
 bName varchar(20),
 bTitle varchar(100),
 bContext varchar(300),
 bDate timestamp DEFAULT now(),
 bHit int(4) DEFAULT 0,
 bGroup int(4),
 bStep int(4),
 bIndent int(4)
 );
 
commit;

alter table mvc_board modify bId int not null auto_increment;

insert into mvc_board (bName) values ('Jees');
insert into mvc_board (bName) values ('Cindy');