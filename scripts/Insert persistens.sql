use [DMA-CSD-S251_10632163];

insert into Customer (name, address, zipcode, city, mail, type) 
values('Aksel', 'Aalborgvej 1', 9000, 'Aalborg', 'aksel@mail', 'PRIVATE');

insert into Customer (name, address, zipcode, city, mail, type) 
values('Thimm', 'Aalborgvej 2', 9000, 'Aalborg', 'Thimm@mail', 'CLUB');

insert into Customer (name, address, zipcode, city, mail, type) 
values('Mathias', 'Aalborgvej 3', 9000, 'Aalborg', 'mathias@mail', 'PRIVATE');

insert into Customer (name, address, zipcode, city, mail, type) 
values('Christian', 'Aalborgvej 99', 9000, 'Aalborg', 'christian@mail', 'CLUB');

insert into Customer (name, address, zipcode, city, mail, type) 
values('Lau', 'Aalborgvej 50', 9000, 'Aalborg', 'LauErBatman@mail', 'PRIVATE');


insert into Freight (method, baseCost, freeThreshold)
values ('DAO', 49.95, 1500);

insert into Freight (method, baseCost, freeThreshold)
values ('Post Nord', 39.50, 2000);

insert into Freight (method, baseCost, freeThreshold)
values ('GLS', 69.69, 2500);

insert into Invoice (invoiceNo, dueDate, paymentDate)
values (1, '2026-03-12', '2026-04-12');

insert into Invoice (invoiceNo, dueDate, paymentDate)
values (2, '2026-02-10', '2026-03-10');

insert into Invoice (invoiceNo, dueDate, paymentDate)
values (3, '2026-01-01', '2026-02-01');


-- ACCEPTABLE TYPES > CLOTHING, EQUIPMENT, GUNREPLICA
insert into Product (type, productNumber, name, minStock, reservedStock)
values ('GunReplica', 1, 'Revolver', 5, 1);

insert into Product (type, productNumber, name, minStock, reservedStock)
values ('GunReplica', 2, 'Desert Eagle', 3, 0);

insert into Product (type, productNumber, name, minStock, reservedStock)
values ('Equipment', 3, 'Leather Belt', 5, 0);

insert into Product (type, productNumber, name, minStock, reservedStock)
values ('Equipment', 4, 'Boots', 6, 0);

insert into Product (type, productNumber, name, minStock, reservedStock)
values ('Clothing', 5, 'Blue Shirt', 10, 2);

insert into Product (type, productNumber, name, minStock, reservedStock)
values ('Clothing', 6, 'Cowboy Pants', 15, 4);


insert into GunReplica (id, caliber, material)
values (1 ,'45', 'Steel');

insert into GunReplica (id, caliber, material)
values (2, '100', 'Gold');


insert into Equipment (id, material, style)
values (3, 'Leather', 'Old');

insert into Equipment (id, material, style)
values (4, 'Leather', 'Old');


insert into Clothing (id, size, colour)
values (5, 'Medium', 'Blue');

insert into Clothing (id, size, colour)
values (6, 'Large', 'Brown');


select * from Freight;
select * from Customer;
select * from Invoice;
select * from Product;
select * from GunReplica;
select * from Equipment;
select * from Clothing;
