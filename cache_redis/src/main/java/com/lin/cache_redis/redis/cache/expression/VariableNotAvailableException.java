package com.lin.cache_redis.redis.cache.expression;

import org.springframework.expression.EvaluationException;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: LinZiYu
 * \* Date: 2020/8/5
 * \* Time: 9:34
 * \* Description:
 * \
 */

// * A specific {@link EvaluationException} to mention that a given variable
// * used in the expression is not available in the context.
public class VariableNotAvailableException extends EvaluationException {

    private final String name;

    public VariableNotAvailableException(String name) {
        super("Variable '" + name + "' is not available");
        this.name = name;
    }


    public String getName() {
        return this.name;
    }


}
