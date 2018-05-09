package com.memtrip.ruleoflaw.model;

import com.memtrip.ruleoflaw.model.reference.Class1;
import com.memtrip.ruleoflaw.model.rule.AnnotationRule;
import com.memtrip.ruleoflaw.model.rule.RuleResult;

class ClassForAnnotationRule {

    private final Class1 class1;
    private final AnnotationRule annotationRule;

    ClassForAnnotationRule(Class1 class1, AnnotationRule annotationRule) {
        this.class1 = class1;
        this.annotationRule = annotationRule;
    }

    RuleResult result() {
        return annotationRule.enforce(class1);
    }
}