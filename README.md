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

Then you can run the following commands to test the JDBC appender:

    mvn clean package
    java -jar target/log4j-jdbc-spring-1.0-SNAPSHOT.jar

Note that you should build the latest Log4j 2 trunk to really test this. The
point of this demo is to test the SQL batch statement support recently added
in the trunk. An older version wouldn't be using batch inserts in this demo.
