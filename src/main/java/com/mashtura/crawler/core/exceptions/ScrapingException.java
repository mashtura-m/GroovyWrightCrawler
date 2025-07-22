package com.mashtura.crawler.core.exceptions;

import java.io.IOException;

public class ScrapingException extends Exception {
    public ScrapingException(String message, IOException e) {
        super(message, e);
    }
}
