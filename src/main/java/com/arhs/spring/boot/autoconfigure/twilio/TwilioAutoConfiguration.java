package com.arhs.spring.boot.autoconfigure.twilio;

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

import com.twilio.sdk.TwilioRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@link org.springframework.boot.autoconfigure.EnableAutoConfiguration Auto configuration} for {@code TwilioRestClient} support.
 *
 * @author Cyril Schumacher
 * @version 1.0
 * @since 2015-01-06
 */
@Configuration
@ConditionalOnClass({TwilioProperties.class, TwilioRestClient.class})
@ConditionalOnProperty(prefix = "twilio", value = {"accountSID", "authToken"})
@EnableConfigurationProperties(TwilioProperties.class)
public class TwilioAutoConfiguration {

    //<editor-fold desc="Fields section.">

    /**
     * Twilio properties.
     */
    @Autowired
    private TwilioProperties properties;

    //</editor-fold>

    //<editor-fold desc="Methods section.">

    /**
     * Create a instance of the {@code TwilioRestClient} class.
     *
     * @return Instance of {@code TwilioRestClient} class.
     */
    @Bean
    public TwilioRestClient twilioRestClient() {
        return new TwilioRestClient(properties.getAccountSID(), properties.getAuthToken(), properties.getEndPoint());
    }

    //</editor-fold>

}
