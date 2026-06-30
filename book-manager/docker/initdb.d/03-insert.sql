
USE book_manager;

INSERT INTO book
VALUES (100, 'Kotlin入門', 'コトリン太郎', '1950-10-01'),
       (200, 'Java入門', 'ジャヴァ太郎', '2005-08-29');

INSERT INTO user
VALUES (1, 'admin@test.com', '$argon2id$v=19$m=19456,t=2,p=1$MmphZVJ3ZjJsaU9POUZuaQ$KrYoiES3KGW+0E7mV562Q1EhAK6HI2TpX8OjVOEAKqI', '管理者', 'ADMIN'),
       (2, 'user@test.com', '$argon2id$v=19$m=19456,t=2,p=1$UU1malVUUHNrVnhCZisveg$CUVp9FGf1oACsnEM8uQhwyHWH/XslxCYs0iG6WW8FOM
', 'ユーザー', 'USER');
