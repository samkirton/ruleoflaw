# ruleoflaw
Self documenting annotations that protect the integrity of your coding standards. Use annotations to define rules that a class should adhere by and fail-fast at compile if these rules are broken.

## Example
The `@Law` interface is used to define rules that a particular class must adhere by. The `@Presenter` annotation below can 
only contain final member variables and its constructor must be package private. Each `@Law` must have a `reasoning` which is
used at compile time to notify the developer that a rule has been broken.
```java
@Law(
        rules = { FINAL_MEMBERS, PACKAGE_PRIVATE_CONSTRUCTOR },
        reasoning =
                "Presenters should only ever be instantiated through Dagger constructor injection." +
                "We should think carefully before introducing mutable objects."
)
public @interface Presenter {

}
```

The class is annotated with the `@Presenter` law and must adhere to the rules.
```java
@Presenter
public class ValidPresenter {

    private final String string;
    private final byte[] data;

    ValidPresenter(String string, byte[] data) {
        this.string = string;
        this.data = data;
    }
}
```

The above example can be found in the `test` package.