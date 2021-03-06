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

import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class LoggerLoadTester implements CommandLineRunner {

    private static final int ITERATIONS = 100_000;

    @Override
    public void run(String... args) throws Exception {
        final Logger logger = LogManager.getLogger();
        final long start = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            logger.info("Test log message #{}", i);
        }
        final long duration = System.nanoTime() - start;
        final BigDecimal average = BigDecimal.valueOf(duration).divide(BigDecimal.valueOf(ITERATIONS));
        System.out.append("Average time per operation: ").append(average.toPlainString()).append(" ns.\n");
    }
}
