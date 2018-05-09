package com.memtrip.ruleoflaw;

import static com.memtrip.ruleoflaw.model.rule.Rule.FINAL_MEMBERS;
import static com.memtrip.ruleoflaw.model.rule.Rule.PACKAGE_PRIVATE_CONSTRUCTOR;

@Law(
        rules = { FINAL_MEMBERS, PACKAGE_PRIVATE_CONSTRUCTOR },
        reasoning =
                "Presenters should only ever be instantiated through Dagger constructor injection." +
                "We should think carefully before introducing mutable objects."
)
@interface Presenter {

}