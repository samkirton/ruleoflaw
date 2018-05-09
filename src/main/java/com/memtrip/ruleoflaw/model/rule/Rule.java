package com.memtrip.ruleoflaw.model.rule;

import com.memtrip.ruleoflaw.model.reference.Class1;

public enum Rule {
    PACKAGE_PRIVATE_CONSTRUCTOR,
    FINAL_MEMBERS;

    public static class Enforcer {
        static boolean brokenRule(Rule rule, Class1 class1) {
            return class1.checkRule(rule);
        }
    }
}