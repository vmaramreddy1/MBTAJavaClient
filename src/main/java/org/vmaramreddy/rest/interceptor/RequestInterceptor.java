package org.vmaramreddy.rest.interceptor;

/**
 * Copyright 2021
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

import org.vmaramreddy.rest.request.RequestHeader;
import org.vmaramreddy.rest.request.RequestParameter;

import java.util.List;

/**
 * Interface that allows for making changes to the outbound API request prior to sending the request.
 */
public interface RequestInterceptor {
    /**
     * Passed a mutable Map of request parameters prior to sending the request.
     * Adding, removing, or modifying any members in this map will alter the values
     * sent in the request.
     *
     * @param requestParameters Mutable map representing request parameter values.
     * @param requestContext Contextual details about the request.
     * @return Modified list of RequestParameters.
     */
    default List<RequestParameter> modifyRequestParameters(
            final List<RequestParameter> requestParameters,
            final RequestContext requestContext
    ) {
        // Nothing to modify.
        return requestParameters;
    }

    /**
     * Passed a mutable Map of request headers prior to sending the request.
     * Adding, removing, or modifying any members in this list will alter the values
     * sent in the request headers.
     *
     * @param requestHeaders Mutable list representing request header values.
     * @param requestContext Contextual details about the request.
     * @return List of modified request headers.
     */
    default List<RequestHeader> modifyHeaders(final List<RequestHeader> requestHeaders, final RequestContext requestContext) {
        // Nothing to modify.
        return requestHeaders;
    }
}
