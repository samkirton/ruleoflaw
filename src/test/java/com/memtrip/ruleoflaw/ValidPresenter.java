package com.memtrip.ruleoflaw;

@Presenter
public class ValidPresenter {

    private final String string;
    private final byte[] data;

    ValidPresenter(String string, byte[] data) {
        this.string = string;
        this.data = data;
    }
}
