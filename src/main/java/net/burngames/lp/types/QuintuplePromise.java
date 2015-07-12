package net.burngames.lp.types;

import net.burngames.lp.types.tasks.QuintupleTask;

/**
 * Represents a Promise that requires 5 arguments
 *
 * @author PaulBGD
 */
public class QuintuplePromise<A, B, C, D, E> implements PromiseInterface {

    private final QuintupleTask<A, B, C, D, E> task;

    public QuintuplePromise(QuintupleTask<A, B, C, D, E> task) {
        this.task = task;
    }

    public Object complete(Object... arguments) {
        if (arguments.length != 5) {
            throw new IllegalArgumentException("There must be 5 arguments");
        }
        return this.task.task((A) arguments[0], (B) arguments[1], (C) arguments[2], (D) arguments[3], (E) arguments[4]);
    }

}
