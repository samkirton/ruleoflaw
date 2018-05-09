package com.memtrip.ruleoflaw.model.rule;

import com.memtrip.ruleoflaw.Reporter;

public class RuleBroken implements RuleResult {

    private final String packageName;
    private final String reason;

    RuleBroken(String packageName, String reason) {
        this.packageName = packageName;
        this.reason = reason;
    }

    @Override
    public void report(Reporter reporter) {

        String sb = "!!!!" +
                "\n" +
                "## RULE BROKEN" +
                "\n" +
                "   " + packageName +
                "\n" +
                "   " + reason;

        reporter.terminate(sb);
    }
}
