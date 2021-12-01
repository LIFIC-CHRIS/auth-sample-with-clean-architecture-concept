package com.example.demo.common.ds;

public class Tuple <A, B> {
    public final A first;
    public final B second;

    public Tuple(A first, B second) {
        this.first = first;
        this.second = second;
    }
}
