create database lms;
go
use lms;
go
CREATE TABLE Employees (
  EmployeeId varchar(10) primary key,
  EmployeeName nvarchar(50) not null,
  BirthDate date not null,
  PhoneNumber varchar(50) not null,
  Role nvarchar(10) check (role = 'Admin' or role = 'Nhân viên'),
  Password nvarchar(200) not null
);

CREATE TABLE Categories (
  CategoryId varchar(6) primary key,
  CategoryName nvarchar(50) not null unique,
  description nvarchar(200)
);

CREATE TABLE Readers (
  ReaderId varchar(6) primary key,
  ReaderName nvarchar(50) not null,
  BirthDate date not null,
  PhoneNumber varchar(50) not null,
  Address nvarchar(50) not null
);
CREATE TABLE Books (
  BookId varchar(6) not null,
  BookName nvarchar(200) not null,
  CategoryId varchar(6),
  ProductionYear int not null,
  AuthorName nvarchar(50) not null,
  PublisherName varchar(50) not null,
  primary key (BookId),
  foreign key (CategoryId) references Categories (CategoryId)
);

CREATE TABLE Borrows (
  BorrowId int identity(1,1) primary key not null,
  BorrowDate date default getdate(),
  ReturnDueDate date,
  ReturnDate date default null,
  ReaderId varchar(6) not null,
  BookId varchar(6) not null,
  EmployeeId varchar(10) not null,
  foreign key (ReaderId) references Readers (ReaderId),
  foreign key (EmployeeId) references Employees (EmployeeId),
  foreign key (BookId) references Books (BookId)

);

INSERT INTO Employees (EmployeeId, EmployeeName, BirthDate, PhoneNumber, Role, Password) VALUES
('NV0001', N'Hồ Văn Minh', '1990-01-15', '0987654321', 'Admin', '123'),
('NV0002', N'Nguyễn Thị Hương', '1995-05-22', '0912345678', 'Nhân viên', '123'),
('NV0003', N'Trần Văn Tuấn', '1988-11-03', '0901122334', 'Nhân viên', '123');
INSERT INTO Categories (CategoryId, CategoryName, Description) VALUES
('CAT001', N'Tiểu thuyết', N'Loại sách chứa các tác phẩm văn học dài, tưởng tượng.'),
('CAT002', N'Khoa học', N'Loại sách liên quan đến khoa học tự nhiên và xã hội.'),
('CAT003', N'Trinh thám', N'Loại sách tập trung vào các câu chuyện hấp dẫn về trinh thám và giải quyết tội phạm.');

INSERT INTO Readers (ReaderId, ReaderName, BirthDate, PhoneNumber, Address) VALUES
('RD001', N'Nguyễn Văn An', '1995-01-01', '0123456789', N'Hà Nội'),
('RD002', N'Trần Thị Bình', '1998-03-15', '0987654321', N'Hồ Chí Minh'),
('RD003', N'Lê Văn Cường', '1990-07-20', '0912345678', N'Đà Nẵng');
INSERT INTO Books (BookId, BookName, CategoryId, ProductionYear, AuthorName, PublisherName) VALUES
('BK001', N'Tiếng Việt 1', 'CAT001', 2020, N'Nguyễn Thị Hương', N'NXB Trẻ'),
('BK002', N'Mathematics for Beginners', 'CAT002', 2019, N'John Smith', N'ABC Publisher'),
('BK003', N'Trinh thám kỳ bí', 'CAT003', 2021, N'Trần Văn Tuấn', N'NXB Kim Đồng');
INSERT INTO Borrows (BorrowDate, ReturnDueDate, ReturnDate, ReaderId, BookId, EmployeeId) VALUES
('2023-11-01', '2023-11-30', null, 'RD001', 'BK001', 'NV0002'),
('2023-12-05', '2023-12-31', null, 'RD002', 'BK002', 'NV0003'),
('2023-12-10', '2023-12-20', null, 'RD003', 'BK003', 'NV0002');
