package com.memtrip.ruleoflaw.model;


import com.memtrip.ruleoflaw.Reporter;
import com.memtrip.ruleoflaw.model.reference.Class1;
import com.memtrip.ruleoflaw.model.rule.AnnotationRule;

import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Source {

    private final Reporter reporter;

    private final List<ClassForAnnotationRule> classForAnnotationRules = new ArrayList<>();

    public Source(Reporter reporter) {
        this.reporter = reporter;
    }

    public void verify(Element annotationElement, RoundEnvironment env) {
        TypeElement typeElement = (TypeElement) annotationElement;
        AnnotationRule annotationRule = new AnnotationRule(typeElement);
        Set<? extends Element> nextElements = env.getElementsAnnotatedWith(typeElement);
        for (Element next : nextElements) {
            classForAnnotationRules.add(new ClassForAnnotationRule(new Class1(next), annotationRule));
        }
    }

    public void checkResults() {
        for (ClassForAnnotationRule classForAnnotationRule : classForAnnotationRules) {
            classForAnnotationRule.result().report(reporter);
        }
    }
}