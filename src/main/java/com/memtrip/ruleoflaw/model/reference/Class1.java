package com.memtrip.ruleoflaw.model.reference;

import com.memtrip.ruleoflaw.model.reference.check.ImmutableLocalVariables;
import com.memtrip.ruleoflaw.model.reference.check.PackagePrivateConstructor;
import com.memtrip.ruleoflaw.model.rule.Rule;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.List;

public class Class1 {

    private final String packageName;
    private final List<Member> members;

    public String packageName() {
        return packageName;
    }

    public Class1(Element element) {
        this((TypeElement) element);
    }

    private Class1(TypeElement typeElement) {
        this(
                typeElement.getQualifiedName().toString(),
                Member.Factory.create(typeElement)
        );
    }

    private Class1(String annotationName, List<Member> members) {
        this.packageName = annotationName;
        this.members = members;
    }

    public boolean checkRule(Rule rule) {
        switch (rule) {
            case PACKAGE_PRIVATE_CONSTRUCTOR:
                return new PackagePrivateConstructor(members).check();
            case FINAL_MEMBERS:
                return new ImmutableLocalVariables(members).check();
            default:
                return true;
        }
    }
}
