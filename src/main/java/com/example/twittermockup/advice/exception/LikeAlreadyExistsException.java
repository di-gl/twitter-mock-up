package com.example.twittermockup.advice.exception;

public class LikeAlreadyExistsException extends RuntimeException {
    public LikeAlreadyExistsException(String message) {
            super(message);
    }
}