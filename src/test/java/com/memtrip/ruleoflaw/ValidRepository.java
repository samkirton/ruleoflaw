package com.memtrip.ruleoflaw;

@Repository
class ValidRepository {

    private final String value;

    ValidRepository(String value) {
        this.value = value;
    }

    public void print() {
        System.out.print(value);
    }
}