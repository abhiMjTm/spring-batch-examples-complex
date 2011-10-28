/**
 * Copyright 2011 Michael R. Lange <michael.r.lange@langmi.de>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.langmi.spring.batch.examples.complex.crosscutting.autothreadconf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * Factory creates a taskexecutor and sets its concurrency limit to
 * the count of available cpu.
 *
 * @author Michael R. Lange <michael.r.lange@langmi.de>
 */
public class AsyncTaskExecutorFactory {

    private static final Logger LOG = LoggerFactory.getLogger(AsyncTaskExecutorFactory.class);

    public static SimpleAsyncTaskExecutor createInstance() {
        SimpleAsyncTaskExecutor instance = new SimpleAsyncTaskExecutor();

        // set concurrencyLimit according to available processors
        Runtime runtime = Runtime.getRuntime();
        int nrCpu = runtime.availableProcessors();
        instance.setConcurrencyLimit(nrCpu);

        LOG.info("TaskExecutor ConcurrencyLimit:" + String.valueOf(nrCpu));

        return instance;
    }
}
