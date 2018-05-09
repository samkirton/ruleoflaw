package com.memtrip.ruleoflaw.model.rule;

import com.memtrip.ruleoflaw.Law;
import com.memtrip.ruleoflaw.model.reference.Class1;

import javax.lang.model.element.TypeElement;

public class AnnotationRule {

    private final String reasoning;
    private final Rule[] rules;

    public AnnotationRule(TypeElement typeElement) {
        this(typeElement.getAnnotation(Law.class));
    }

    private AnnotationRule(Law law) {
       this(law.reasoning(), law.rules());
    }

    private AnnotationRule(String reasoning, Rule[] rules) {
        this.reasoning = reasoning;
        this.rules = rules;
    }

    public RuleResult enforce(Class1 class1) {

        for (Rule rule : rules) {
            if (Rule.Enforcer.brokenRule(rule, class1)) {
                return new RuleBroken(class1.packageName(), reasoning);
            }
        }

        return new RuleEnforced();
    }
}
