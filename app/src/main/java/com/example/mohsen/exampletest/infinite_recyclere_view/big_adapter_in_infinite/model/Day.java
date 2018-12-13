package com.example.mohsen.exampletest.infinite_recyclere_view.big_adapter_in_infinite.model;

import java.util.Random;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Day {
    private int id;
    private String condition;
    private int max;
    private int min;
    private String name;
    public Day() {
        Random random = new Random();
        this.id = random.nextInt();
    }


}
