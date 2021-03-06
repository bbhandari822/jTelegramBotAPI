package com.jtelegram.api.chat;

import lombok.Getter;

@Getter
public class PrivateChat extends Chat {
    private String firstName;
    private String lastName;

    public String getFullName() {
        return firstName + " " + lastName;
    }
}
