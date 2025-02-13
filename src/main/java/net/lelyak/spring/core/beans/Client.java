package net.lelyak.spring.core.beans;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Client {
    private String id;
    private String fullName;
    private String greeting;

    public Client(String id, String fullName) {
        this.id = id;
        this.fullName = fullName;
    }

}
