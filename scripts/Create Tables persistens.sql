use [DMA-CSD-S251_10632163];

CREATE TABLE Freight(
id int IDENTITY (1,1),
method varchar(20),
baseCost decimal (10,2),
freeThreshold decimal(10,2),
constraint pkFreight primary key(id)
);

CREATE TABLE Invoice(
id int IDENTITY (1,1),
invoiceNo int,
dueDate datetime,
paymentDate datetime,
constraint pkInvoice primary key(id)
);

CREATE TABLE Customer(
id INT IDENTITY (1,1),
name varchar(40),
address varchar(40),
zipcode int,
city varchar(40),
mail varchar(40),
type varchar(20),
constraint pkCustomer primary key(id)
);

CREATE TABLE SaleOrder(
id int IDENTITY (1,1),
orderNo int,
orderDate datetime,
deliveryStatus varchar(20),
deliveryDate datetime,
discountGiven bit,
freightID int,
customerID int,
invoiceID int,
constraint pkSaleOrder primary key(id),
constraint fkSOToFreight foreign key(freightID) references Freight(id) ON DELETE cascade,
constraint fkSOToCustomer foreign key(customerID) references Customer(id) ON DELETE cascade,
constraint fkSOToInvoice foreign key(invoiceID) references Invoice(id) ON DELETE cascade
);

CREATE TABLE Product(
id int IDENTITY (1,1),
type varchar(40),
productNumber int,
name varchar(40),
minStock int,
reservedStock int,
constraint pkProduct primary key(id)
);

CREATE TABLE Clothing(
id int,
size varchar(40),
colour varchar(40),
constraint pkClothing primary key(id),
constraint fkCToProduct foreign key(id) references Product(id) ON DELETE cascade
);

CREATE TABLE Equipment(
id int,
material varchar(40),
style varchar(40),
constraint pkEquipment primary key(id),
constraint fkEToProduct foreign key(id) references Product(id) ON DELETE cascade
);

CREATE TABLE GunReplica(
id int,
caliber varchar(40),
material varchar(40),
constraint pkGunReplica primary key(id),
constraint fkGPToProduct foreign key(id) references Product(id) ON DELETE cascade
);

CREATE TABLE OrderLineItem(
quantity int,
productID int,
orderID int, 
constraint pkOrderLineItem primary key(productID, orderID),
constraint fkOLIToProduct foreign key(productID) references Product(id) ON DELETE cascade,
constraint fkOLIToSaleOrder foreign key(orderID) references SaleOrder(id) ON DELETE cascade
);

CREATE TABLE Warehouse(
id int IDENTITY (1,1),
number int,
name varchar(40),
description varchar(255),
constraint pkWarehouse primary key(id)
);

CREATE TABLE Stock(
id int IDENTITY (1,1),
availableQty int,
productID int,
warehouseID int,
constraint pkStock primary key(id),
constraint fkSToProduct foreign key(productID) references Product(id) ON DELETE cascade,
constraint fkSToWarehouse foreign key(warehouseID) references Warehouse(id) ON DELETE cascade
);

CREATE TABLE Price(
id int IDENTITY (1,1),
timestamp datetime,
productID int,
constraint pkPrice primary key(id),
constraint fkPToProduct foreign key(productID) references Product(id) ON DELETE cascade
);

CREATE TABLE Supplier(
id int IDENTITY (1,1),
name varchar(40),
address varchar(40),
country varchar(40),
phoneNo varchar(40),
email varchar(255),
constraint pkSupplier primary key(id)
);

CREATE TABLE ProductSupplier(
id int IDENTITY (1,1),
productID int,
supplierID int,
constraint pkProductSupplier primary key(id),
constraint fkPSToProduct foreign key(productID) references Product(id) ON DELETE cascade,
constraint fkPSToSupplier foreign key(supplierID) references Supplier(id) ON DELETE cascade
);