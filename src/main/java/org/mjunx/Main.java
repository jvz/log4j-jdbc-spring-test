/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package org.mjunx;

import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Main {
    public static void main(final String... args) throws Exception {
        setUpJndi();
        setUpDataSource();
        SpringApplication.run(Main.class, args);
    }

    private static void setUpJndi() {
        System.setProperty(Context.INITIAL_CONTEXT_FACTORY, DataSourceContextFactory.class.getName());
        System.setProperty(Context.PROVIDER_URL, "file:///tmp");
    }

    private static void setUpDataSource() throws SQLException, NamingException {
        final Context ctx = new InitialContext();
        ctx.bind("java:comp/env/jdbc/log4j", createDataSource());
    }

    private static DataSource createDataSource() {
        final MysqlDataSource ds = new MysqlDataSource();
        ds.setUrl("jdbc:mysql://localhost/log4j");
        ds.setUser("log4j");
        ds.setPassword("log4j");
        return ds;
    }
}
