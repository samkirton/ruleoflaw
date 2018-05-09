package com.memtrip.ruleoflaw.model.reference.check;

import com.memtrip.ruleoflaw.model.reference.Constructor;
import com.memtrip.ruleoflaw.model.reference.Member;
import com.memtrip.ruleoflaw.model.reference.Modifier2;

import java.util.List;

public class PackagePrivateConstructor {

    private final List<Member> members;

    public PackagePrivateConstructor(List<Member> members) {
        this.members = members;
    }

    public boolean check() {
        for (Member member : members) {
            if (member instanceof Constructor && !allConstructorsArePackagePrivate(member.modifiers())) {
                return true;
            }
        }

        return false;
    }

    private boolean allConstructorsArePackagePrivate(List<Modifier2> modifiers) {

        for (Modifier2 modifier : modifiers) {
            if (modifier != Modifier2.PACKAGE_PRIVATE) {
                return false;
            }
        }

        return true;
    }
}