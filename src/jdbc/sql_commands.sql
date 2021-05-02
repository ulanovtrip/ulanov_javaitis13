-- создаём таблицу
create table account
(
    -- идентификатор строки,первичный ключ, по-умолчанию он уникальный, bigserial - значит, что генерится самой БД
    id         bigserial primary key,
    first_name varchar(20)        not null,
    last_name  varchar(20)        not null,
    email      varchar(20) unique not null,
    experience integer default 3 check ( experience >= 3 ),
    is_active  boolean default false
);

-- изменить тип данных столбца
alter table account
    alter column email type varchar(30);

-- добавить новую колонку в таблицу
alter table account
    add column phone varchar(15);

-- добавить новое ограничение
alter table account
    add constraint check_max_experience check ( experience < 60 );

-- вносим данные в таблицу, добавление данных в таблицу
insert into account(first_name, last_name, email)
values ('Ivan', 'Ulanov', 'ulanovis@gmail.com');

-- id bigserial primary key позволяет не указывать id
insert into account(id, first_name, last_name, email, experience)
values (2, 'Isaak', 'Salimov', 'isaak@gmail.com', 4);

insert into account(first_name, last_name, email, experience)
values ('Marsel', 'Kabanov', 'kabanov@gmail.com', 59);

insert into account(first_name, last_name, email, experience)
values ('Maxim', 'Pozdeev', 'poz@gmail.com', 10);

-- добавить телефон по id, т.е. это бновление данных в таблице
update account
set phone ='+79817486835'
where id = 1;
-- можно обновить состояние is_active
update account
set is_active = true
where id = 4;

-- создать дочернюю таблицу
create table car
(
    id       bigserial primary key,
    color    varchar(20),
    model    varchar(20),
    number   varchar(20),
    owner_id bigint,
    -- внешний ключ
    foreign key (owner_id) references account (id)
);

-- добавить в таблицу car машину
insert into car (color, model, number, owner_id)
values ('White', 'Skoda', 'o476am178', 1);

insert into car (color, model, number, owner_id)
values ('Красный', 'Largus', 'o476am178', 1);

insert into car (color, model, number, owner_id)
values ('Серый', 'Renault', 'o476am178', 1);

insert into car (color, model, number, owner_id)
values ('Голубой', 'Bugatti', 'o001am01', 4);

-- без владельца
insert into car (color, model, number)
values ('White', 'Solaris', 'o896aa116');

-- можно добавить владельца машине
update car
set owner_id = 5
where id = 5;

-- пример связи многие ко многим, нужна третья таблица
create table driver_car
(
    driver_id bigint,
    car_id    bigint,
    foreign key (driver_id) references account (id),
    foreign key (car_id) references car (id)
);

-- заполнение табилцы driver_car
insert into driver_car(driver_id, car_id)
values (1, 2);
insert into driver_car(driver_id, car_id)
values (4, 4);
insert into driver_car(driver_id, car_id)
values (5, 3);
insert into driver_car(driver_id, car_id)
values (2, 5);
insert into driver_car(driver_id, car_id)
values (2, 3);
insert into driver_car(driver_id, car_id)
values (1, 5);
insert into driver_car(driver_id, car_id)
values (4, 5);
insert into driver_car(driver_id, car_id)
values (5, 5);

-- вывпод всех колонок всех пользьвателей
select *
from account;

-- получение только имен из таблицы
select first_name
from account;

-- получение колонки с её переименованием
select first_name as name
from account;

--получение имени и фамилии пользователей, у которых нет номер телефона
select first_name, last_name
from account
where phone isnull;

-- получить всех пользователей со стажем более 3-х лет
select first_name, last_name
from account
where experience > 4;

-- получить имена владельцев у которых есть хотя бы одна машина
select first_name
from account
where id in (select distinct owner_id from car where owner_id notnull);

-- получить имена владельцев машин, у которых более одного водителя

-- 1. сначала нужно получить машину и сколько у нее водителей
select car_id,
       count(driver_id)
           as drivers_count
from driver_car
group by car_id;

-- 2. теперь нужно получить имена владельцев машин
select *
from (
         -- подселект
         select car_id,
                count(driver_id)
                    as drivers_count
         from driver_car
         group by car_id) cd
where cd.drivers_count > 1;

-- cd - название для выборки, которая получится внутри круглых скобок

-- следующая выборка
select first_name from account a where a.id in (
    select owner_id -- id владельцев, у машин которых более 1-го водителя
    from car c
    where c.id in (
        select car_id -- id машин, у которых более 1-го водителя
        from (
                 -- id машин и кол-во пользователей
                 select car_id,
                        count(driver_id)
                            as drivers_count
                 from driver_car
                 group by car_id) cd
        where cd.drivers_count > 1));

--left join
select * from account a left join car c on a.id = c.owner_id;

-- right join
select * from account a right join car c on a.id = c.owner_id;

--удалить constraint
alter table account alter column email set default 'default@email.com'