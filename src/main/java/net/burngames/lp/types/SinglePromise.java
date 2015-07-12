package net.burngames.lp.types;

import net.burngames.lp.types.tasks.SingleTask;

/**
 * Represents a Promise that requires a single argument
 *
 * @author PaulBGD
 */
public class SinglePromise<A> implements PromiseInterface {

    private final SingleTask<A> task;

    public SinglePromise(SingleTask<A> task) {
        this.task = task;
    }

    public Object complete(Object... arguments) {
        if (arguments.length != 1) {
            throw new IllegalArgumentException("There must be 1 argument");
        }
        return this.task.task((A) arguments[0]);
    }

}
