package com.memtrip.ruleoflaw;

import static com.memtrip.ruleoflaw.model.rule.Rule.PACKAGE_PRIVATE_CONSTRUCTOR;

@Law(
        rules = PACKAGE_PRIVATE_CONSTRUCTOR,
        reasoning =
                "Repository classes must have a package private constructor, " +
                "new instances of repositories should only ever be created within a " +
                "Dagger module."
)
@interface Repository {

}