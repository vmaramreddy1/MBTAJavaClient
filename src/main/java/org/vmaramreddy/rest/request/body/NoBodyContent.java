package org.vmaramreddy.rest.request.body;

public class NoBodyContent implements RequestBodyContent{
    public static final RequestBodyContent INSTANCE = new NoBodyContent();

    public NoBodyContent() {
    }

    @Override
    public String toString() {
        return null;
    }
}
