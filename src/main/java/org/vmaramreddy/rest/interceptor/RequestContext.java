package org.vmaramreddy.rest.interceptor;

/**
 * Copyright 2019
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


import org.vmaramreddy.rest.request.RequestMethod;

/**
 * Defines details about the request.
 */
public class RequestContext {
    private final String url;
    private final RequestMethod requestMethod;

    /**
     * Constructor.
     * @param url The url to be requested/
     * @param requestMethod the type of request.
     */
    public RequestContext(final String url, final RequestMethod requestMethod) {
        this.url = url;
        this.requestMethod = requestMethod;
    }

    public String getUrl() {
        return url;
    }

    public RequestMethod getRequestMethod() {
        return requestMethod;
    }

    @Override
    public String toString() {
        return "RequestContext{"
                + "url='" + url + '\''
                + ", requestMethod=" + requestMethod
                + '}';
    }
}
