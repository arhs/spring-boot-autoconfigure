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

import com.arhs.spring.boot.autoconfigure.UnitTestBase;
import com.twilio.sdk.TwilioRestClient;
import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@code TwilioAutoConfiguration} class.
 *
 * @author Cyril Schumacher
 * @version 1.0
 * @since 2014-01-29
 */
public class TwilioAutoConfigurationTest extends UnitTestBase {

    //<editor-fold desc="Constants section.">

    /**
     * Account SID.
     */
    private final static String ACCOUNT_SID = "AC123456789azertyuiopqsdfghjklmwxc";

    /**
     * Authentication token.
     */
    private final static String AUTH_TOKEN = "abcdefghijklmnopqrstuvwxyz012345";

    /**
     * Endpoint.
     */
    private final static String ENDPOINT = "endpoint";

    //</editor-fold>

    //<editor-fold desc="Methods section.">

    /**
     * Executes before the execution of tests.
     */
    public void load() {
        context = load(
                new Class<?>[]{TwilioAutoConfiguration.class},
                "twilio.accountSID:" + ACCOUNT_SID,
                "twilio.authToken:" + AUTH_TOKEN,
                "twilio.endPoint:" + ENDPOINT
        );
    }

    /**
     * Test for using of Twilio class instance.
     */
    @Test
    public void testInstance() {
        // Loads the application context.
        load();

        final TwilioRestClient twilioRestClient = context.getBean(TwilioRestClient.class);
        Assert.assertNotNull("Any instance of the class has been created TwilioRestClient", twilioRestClient);
    }

    /**
     * Test for properties of Twilio class instance.
     */
    @Test
    public void testProperties() {
        // Loads the application context.
        load();

        assertBeanExists(TwilioRestClient.class);

        final TwilioRestClient twilioRestClient = context.getBean(TwilioRestClient.class);
        Assert.assertNotNull("Any instance of the class has been created TwilioRestClient", twilioRestClient);
        Assert.assertEquals("The account security identifier has not been defined when creating the object.", ACCOUNT_SID, twilioRestClient.getAccountSid());
        Assert.assertEquals("The authentication token has not been defined when creating the object.", AUTH_TOKEN, twilioRestClient.getAccount().getAuthToken());
        Assert.assertEquals("The end point has not been defined when creating the object.", ENDPOINT, twilioRestClient.getEndpoint());
    }

    //</editor-fold>
}
