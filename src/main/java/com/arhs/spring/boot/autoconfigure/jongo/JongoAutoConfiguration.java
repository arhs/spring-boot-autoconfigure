package com.arhs.spring.boot.autoconfigure.jongo;

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

import com.mongodb.DB;
import com.mongodb.Mongo;
import org.jongo.Jongo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration Auto configuration} for {@code Jongo} support.
 *
 * @author Cyril Schumacher
 * @version 1.0
 * @since 2014-12-23
 */
@Configuration
@ConditionalOnClass({Jongo.class})
public class JongoAutoConfiguration {

    //<editor-fold desc="Fields section.">

    /**
     * Mongo
     */
    @Autowired
    protected Mongo mongo;

    /**
     * Jongo properties.
     */
    @Autowired
    protected MongoProperties properties;

    //</editor-fold>

    //<editor-fold desc="Methods section.">

    /**
     * Create a instance of the {@code Jongo} class.
     *
     * @return The instance of {@code Jongo} class.
     */
    @Bean
    public Jongo jongo() {
        final DB database = mongo.getDB(properties.getDatabase());
        return new Jongo(database);
    }

    //</editor-fold>

}