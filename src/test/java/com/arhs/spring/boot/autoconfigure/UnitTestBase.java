package com.arhs.spring.boot.autoconfigure;

/**
 * The MIT License (MIT)
 * Copyright (c) 2015 ARHS Developments SA
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import junit.framework.Assert;
import org.junit.After;
import org.springframework.boot.test.EnvironmentTestUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public abstract class UnitTestBase {

    //<editor-fold desc="Fields section.">

    /**
     * Application context.
     */
    protected AnnotationConfigApplicationContext context;

    //</editor-fold>


    //<editor-fold desc="Methods section.">

    //<editor-fold desc="Protected methods section.">

    /**
     * Asserts that the bean exists in the current context.
     *
     * @param bean The name of bean.
     */
    protected void assertBeanExists(Class<?> bean) {
        Assert.assertNotNull("The bean does not exist in the context.", context.containsBean(bean.getName()));
    }

    /**
     * Loads the configuration application context.
     *
     * @param configs     The configuration class.
     * @param environment The environment.
     * @return A configuration application context.
     */
    protected AnnotationConfigApplicationContext load(Class<?>[] configs, String... environment) {
        // Creates a instance of the "AnnotationConfigApplicationContext" class that represents
        // the application context.
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // Adds environment.
        EnvironmentTestUtils.addEnvironment(applicationContext, environment);

        // Registers the configuration class and auto-configuration classes.
        applicationContext.register(ConfigurationTest.class);
        applicationContext.register(configs);
        applicationContext.refresh();

        return applicationContext;
    }

    //</editor-fold>

    /**
     * Closes the context.
     */
    @After
    public void close() {
        if (context != null) {
            context.close();
        }
    }

    //</editor-fold>

}
