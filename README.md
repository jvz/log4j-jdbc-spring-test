Set-Up
======

Run the following commands in MySQL:

    CREATE DATABASE log4j;
    GRANT ALL ON log4j.* TO 'log4j'@'localhost' IDENTIFIED BY 'log4j';
    CREATE TABLE `log_entries` (
      `entry_id` char(36) NOT NULL,
      `level_name` varchar(10) NOT NULL,
      `marker_name` varchar(30) DEFAULT NULL,
      `logger_name` varchar(255) NOT NULL,
      `entry_timestamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
      `entry_message` text NOT NULL,
      `entry_exception` longtext,
      PRIMARY KEY (`entry_id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

Then you can run the following command to test the JDBC appender:

    mvn spring-boot:run
