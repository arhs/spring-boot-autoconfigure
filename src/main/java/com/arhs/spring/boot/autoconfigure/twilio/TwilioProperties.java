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

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for {@code TwilioRestClient}.
 *
 * @author Cyril Schumacher
 * @version 1.0
 * @since 2015-01-06
 */
@ConfigurationProperties(prefix = "twilio")
public class TwilioProperties {

    //<editor-fold desc="Fields section.">

    /**
     * Account SID.
     */
    private String accountSID;

    /**
     * Authentication Token.
     */
    private String authToken;

    /**
     * End point.
     */
    private String endPoint;

    //</editor-fold>

    //<editor-fold desc="Properties section.">

    /**
     * Sets the account SID.
     *
     * @param accountSID The account SID.
     */
    public void setAccountSID(String accountSID) {
        this.accountSID = accountSID;
    }

    /**
     * Sets the authentication token.
     *
     * @param authToken The authentication token.
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    /**
     * Sets the end point.
     *
     * @param endPoint The end point.
     */
    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    /**
     * Gets the account SID.
     *
     * @return The account SID.
     */
    public String getAccountSID() {
        return accountSID;
    }

    /**
     * Gets the authentication token.
     *
     * @return The authentication token.
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * Gets the end point.
     *
     * @return The end point.
     */
    public String getEndPoint() {
        return endPoint;
    }

    //</editor-fold>

}
