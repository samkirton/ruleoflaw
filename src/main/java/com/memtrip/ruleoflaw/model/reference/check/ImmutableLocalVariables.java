package com.memtrip.ruleoflaw.model.reference.check;

import com.memtrip.ruleoflaw.model.reference.Field;
import com.memtrip.ruleoflaw.model.reference.Member;
import com.memtrip.ruleoflaw.model.reference.Modifier2;

import java.util.List;

public class ImmutableLocalVariables {

    private final List<Member> members;

    public ImmutableLocalVariables(List<Member> members) {
        this.members = members;
    }

    public boolean check() {
        for (Member member : members) {
            if (member instanceof Field && !fieldUsesFinalModifier(member.modifiers())) {
                return true;
            }
        }

        return false;
    }

    private boolean fieldUsesFinalModifier(List<Modifier2> modifiers) {

        for (Modifier2 modifier : modifiers) {
            if (modifier == Modifier2.FINAL) {
                return true;
            }
        }

        return false;
    }
}