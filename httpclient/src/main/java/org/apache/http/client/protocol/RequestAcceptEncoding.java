/*
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */
package org.apache.http.client.protocol;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.annotation.Immutable;
import org.apache.http.protocol.HttpContext;

/**
 * Class responsible for handling Content Encoding requests in HTTP.
 * <p>
 * Instances of this class are stateless, therefore they're thread-safe and immutable.
 *
 * @see "http://www.w3.org/Protocols/rfc2616/rfc2616-sec3.html#sec3.5"
 *
 * @since 4.1
 */
@Immutable
public class RequestAcceptEncoding implements HttpRequestInterceptor {

    /**
     * Adds the header {@code "Accept-Encoding: gzip,deflate"} to the request.
     */
    @Override
    public void process(
            final HttpRequest request,
            final HttpContext context) throws HttpException, IOException {

        /* Signal support for Accept-Encoding transfer encodings. */
        if (!request.containsHeader("Accept-Encoding")) {
            request.addHeader("Accept-Encoding", "gzip,deflate");
        }
    }

}
