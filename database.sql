DROP DATABASE IF EXISTS `book_management`;
CREATE DATABASE `book_management`;
USE `book_management`;
CREATE TABLE `books` (
`id` int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
`name` varchar(50) NOT NULL,
`author` varchar(50) NOT NULL,
`publisher` varchar(50) NOT NULL,
`type` varchar(50) NOT NULL,
`language` varchar(50) NOT NULL,
`quantity` int(11) NOT NULL,
`image` varchar(200) NOT NULL)

ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `books` (`name`, `author`, `publisher`, `type`, `language`, `quantity`, `image`)
VALUES ('Mắt biếc', 'Nguyễn Nhật Ánh', 'NXB Trẻ', 'Truyện ngắn', 'Tiếng Việt',  10, 'matbiecImage'),
('Sự Im Lặng Của Bầy Cừu', 'Thomas Harris', 'NXB Hội Nhà Văn', 'Tiểu thuyết', 'Tiếng Việt', 15, 'SuimlangcuabaycuuImage'),
('Đắc nhân tâm', 'Dale Carnegie', 'NXB tổng hợp TP.HCM', 'Sách tự lực', 'Tiếng Việt',  20, 'dacnhantamImage'),
('Hành trình về phương đông', 'Baird T. Spalding', 'NXB Thế Giới', 'Tài liệu tham khảo', 'Tiếng Việt', 100, 'hanhtrinhvephuongdongImage'),
('Need To Know: A Novel', 'Karen Cleveland', 'Penguin Random House', 'Truyện ngắn', 'English',  30, 'needtoknowImage'),
('Đừng Chạy Theo Số Đông', 'Kiên Trần', 'NXB Thế Giới', 'Sách tự lực', 'Tiếng Việt',  60, 'dungchaytheosodongImage'),
('Nhà Giả Kim', 'Paulo Coelho', 'NXB Văn Học', 'Tiểu thuyết', 'Bồ Đào Nha',  200, 'nhagialkimImage'),
('Đừng Bao Giờ Đi Ăn Một Mình', 'Keith Ferrazzi', 'NXB Trẻ', 'Sách tự lực', 'Tiếng Việt', 100, 'dungbaogiodianmotminhImage'),
('Payback Time', 'Phil Town', 'NXB Văn hóa văn nghệ', 'Sách kinh tế', 'Tiếng Việt', 500, 'paybacktimeImage'),
('Dám Bị Ghét', 'Koga Fumitake', 'NXB Dân Trí', 'Sách kinh tế', 'Tiếng Việt',  70, 'dambighetImage');

CREATE TABLE `users` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`username` varchar(50) NOT NULL UNIQUE,
`password` varchar(50) NOT NULL,
`role` varchar(10) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `users` (`username`, `password`, `role`)
VALUES ('user', '123456','user'),
('admin', '123456','admin');

insert into `users` (`username`, `password`, `role`)
values ('minhvu',md5('minhvu'),'user');
