package com.acme.edu.message;

import java.util.Objects;

public class StringMessage implements Message {
    private String message;
    private int amount = 1;
    public StringMessage (String message) {
        this.message = message;
    }
    @Override
    public Message log(Message message) {
        return null;
    }
    @Override
    public boolean isSameTypeOf(Message message) {
        return message instanceof StringMessage;
    }
    @Override
    public void flush() {

    }

    @Override
    public void accumulate(Message message) {
        String value = ((StringMessage)message).message;
        if (Objects.equals(value, this.message)) {
            this.amount++;
        } else {
            this.flush();
            this.message = value;
            this.amount = 1;
        }

    }
    public String fetch() {
        return message + (this.amount == 1 ? "" : "(x" + Integer.toString(amount) + ")");
    }
}