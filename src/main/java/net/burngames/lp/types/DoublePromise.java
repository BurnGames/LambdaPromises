package net.burngames.lp.types;

import net.burngames.lp.types.tasks.DoubleTask;

/**
 * @author PaulBGD
 */
public class DoublePromise<A, B> implements PromiseInterface {

    private final DoubleTask<A, B> task;

    public DoublePromise(DoubleTask<A, B> task) {
        this.task = task;
    }

    public Object complete(Object... arguments) {
        if (arguments.length != 2) {
            throw new IllegalArgumentException("There must be 2 arguments");
        }
        return this.task.task((A) arguments[0], (B) arguments[1]);
    }

}
