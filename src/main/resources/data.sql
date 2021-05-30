INSERT INTO `coupon` (`id`, `use_min_amount`, `discount_amount`, `usable_from`, `usable_until`, `status`) VALUES
    (1001, 5000, 3000, PARSEDATETIME('2021-01-01 00:00:00','yyyy-MM-dd HH:mm:ss'), PARSEDATETIME('2021-11-30 23:59:59','yyyy-MM-dd HH:mm:ss'), 'NORMAL'),
    (1002, 5000, 5000, PARSEDATETIME('2021-01-01 00:00:00','yyyy-MM-dd HH:mm:ss'), PARSEDATETIME('2021-12-31 23:59:59','yyyy-MM-dd HH:mm:ss'), 'NORMAL'),
    (1003, 0, 1000, PARSEDATETIME('2021-01-01 00:00:00','yyyy-MM-dd HH:mm:ss'), PARSEDATETIME('2021-11-30 23:59:59','yyyy-MM-dd HH:mm:ss'), 'NORMAL'),
    (1004, 0, 1000, PARSEDATETIME('2021-01-01 00:00:00','yyyy-MM-dd HH:mm:ss'), PARSEDATETIME('2021-06-30 23:59:59','yyyy-MM-dd HH:mm:ss'), 'USED'),
    (1005, 0, 2000, PARSEDATETIME('2021-01-01 00:00:00','yyyy-MM-dd HH:mm:ss'), PARSEDATETIME('2021-12-31 23:59:59','yyyy-MM-dd HH:mm:ss'), 'NORMAL'),
    (1006, 3000, 5000, PARSEDATETIME('2021-07-01 00:00:00','yyyy-MM-dd HH:mm:ss'), PARSEDATETIME('2021-10-31 23:59:59','yyyy-MM-dd HH:mm:ss'), 'NORMAL');

