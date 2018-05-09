package com.memtrip.ruleoflaw.model.reference;

import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Member {

    private final String name;
    private final List<Modifier2> modifiers;

    public List<Modifier2> modifiers() {
        return modifiers;
    }

    Member(Element element) {
        this(
                element.getSimpleName().toString(),
                modifiers(element.getModifiers().iterator())
        );
    }

    private Member(String name, List<Modifier2> modifiers) {
        this.name = name;
        this.modifiers = modifiers;
    }

    private static List<Modifier2> modifiers(Iterator<Modifier> internalModifiers) {

        List<Modifier2> modifiers = new ArrayList<>();

            if (internalModifiers.hasNext()) {
                for (; internalModifiers.hasNext(); ) {
                    switch (internalModifiers.next()) {
                        case PUBLIC:
                            modifiers.add(Modifier2.PUBLIC);
                            break;
                        case PROTECTED:
                            modifiers.add(Modifier2.PROTECTED);
                            break;
                        case PRIVATE:
                            modifiers.add(Modifier2.PRIVATE);
                            break;
                        case FINAL:
                            modifiers.add(Modifier2.FINAL);
                            break;
                        default:
                            modifiers.add(Modifier2.PACKAGE_PRIVATE);
                    }
                }
            } else {
                modifiers.add(Modifier2.PACKAGE_PRIVATE);
            }

        return modifiers;
    }

    static class Factory {

        static List<Member> create(TypeElement typeElement) {

            List<Member> members = new ArrayList<>();

            for (Element element1 : typeElement.getEnclosedElements()) {
                members.add(Member.Factory.create(element1));
            }

            return members;
        }

        private static Member create(Element element) {
            switch (element.getKind()) {
                case CONSTRUCTOR:
                    return new Constructor(element);
                case METHOD:
                    return new Method(element);
                case FIELD:
                    return new Field(element);
                default:
                    return new Member(element) {};
            }
        }
    }
}
