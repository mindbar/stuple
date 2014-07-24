-- Table
create table stuple.factorial (
  id numeric not null,
  value text not null,
  constraint pk_factorial primary key (id)
);

-- Data
insert into stuple.factorial values (0, 1);

-- Imbored
create table stuple.imbored (
  title text not null,
  image text not null
);
