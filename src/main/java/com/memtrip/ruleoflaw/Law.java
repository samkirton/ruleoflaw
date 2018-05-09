package com.memtrip.ruleoflaw;

import com.memtrip.ruleoflaw.model.rule.Rule;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;

@Target(ANNOTATION_TYPE)
public @interface Law {
    String reasoning();
    Rule[] rules() default {};
}