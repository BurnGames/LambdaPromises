package net.burngames.lp.types;

import net.burngames.lp.types.tasks.TripleTask;

/**
 * Represents a Promise that requires 3 arguments
 *
 * @author PaulBGD
 */
public class TriplePromise<A, B, C> implements PromiseInterface {

    private final TripleTask<A, B, C> task;

    public TriplePromise(TripleTask<A, B, C> task) {
        this.task = task;
    }

    public Object complete(Object... arguments) {
        if (arguments.length != 3) {
            throw new IllegalArgumentException("There must be 3 arguments");
        }
        return this.task.task((A) arguments[0], (B) arguments[1], (C) arguments[2]);
    }

}
