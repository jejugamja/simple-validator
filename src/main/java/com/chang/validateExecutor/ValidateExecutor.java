package com.chang.validateExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ValidateExecutor<T> {

    private T target;
    private List<Validator<T>> validators = new ArrayList<>();

    public ValidateExecutor(T target) {
        this.target = target;
    }

    public ValidateExecutor<T> validate(Validator<T> validator) {
        validators.add(validator);
        return this;
    }

    public void execute(Consumer<T> callback) {
        validators.stream()
                .forEach(v -> {
                    try {
                        if (!v.validate(target))
                            throw new ValidateException();
                    } catch (Exception e) {
                        throw new ValidateException(e);
                    }
                });
        callback.accept(target);
    }

    public static <V> ValidateExecutor<V> of(V target) {
        return new ValidateExecutor(target);
    }
}
