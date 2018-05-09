package com.memtrip.ruleoflaw;

@Repository
public class InvalidRepository {

    String hello;

    private String why;

    public String never;

    // The class does not confirm to the repository rules
    public InvalidRepository() {

    }

    InvalidRepository(String t) {

    }

    private InvalidRepository(String p, boolean t) {

    }

    void test() {

    }

    public void test1() {

    }
}
