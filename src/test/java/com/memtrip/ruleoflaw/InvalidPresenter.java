package com.memtrip.ruleoflaw;

@Presenter
public class InvalidPresenter {

    private final String string;
    private byte[] data;
    private int number;

    InvalidPresenter(String string, byte[] data, int number) {
        this.string = string;
        this.data = data;
        this.number = number;
    }
}
