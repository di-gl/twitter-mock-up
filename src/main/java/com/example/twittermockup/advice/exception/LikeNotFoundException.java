package com.example.twittermockup.advice.exception;

public class LikeNotFoundException extends RuntimeException {
        public LikeNotFoundException(String message) {
            super(message);
        }
}