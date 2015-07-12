package net.burngames.lp.types;

import net.burngames.lp.types.tasks.QuadrupleTask;

/**
 * Represents a Promise that requires 4 arguments
 *
 * @author PaulBGD
 */
public class QuadruplePromise<A, B, C, D> implements PromiseInterface {

    private final QuadrupleTask<A, B, C, D> task;

    public QuadruplePromise(QuadrupleTask<A, B, C, D> task) {
        this.task = task;
    }

    public Object complete(Object... arguments) {
        if (arguments.length != 4) {
            throw new IllegalArgumentException("There must be 4 arguments");
        }
        return this.task.task((A) arguments[0], (B) arguments[1], (C) arguments[2], (D) arguments[3]);
    }

}
