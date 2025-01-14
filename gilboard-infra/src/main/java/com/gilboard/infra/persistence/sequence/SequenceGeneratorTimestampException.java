package com.gilboard.infra.persistence.sequence;

public class SequenceGeneratorTimestampException extends RuntimeException {
    public SequenceGeneratorTimestampException(String message) {
        super(message);
    }
}
