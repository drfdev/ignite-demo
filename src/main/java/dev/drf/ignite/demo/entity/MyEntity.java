package dev.drf.ignite.demo.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class MyEntity implements Serializable {
    private static final long serialVersionUID = -2449153578482089585L;

    private final long id;
    private String name;
    private String description;
    private String value;
}
