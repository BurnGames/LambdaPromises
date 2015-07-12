package net.burngames.lp.types;

import net.burngames.lp.types.tasks.EmptyTask;

/**
 * @author PaulBGD
 */
public class EmptyPromise implements PromiseInterface {

    private final EmptyTask task;

    public EmptyPromise(EmptyTask task) {
        this.task = task;
    }

    @Override
    public Object complete(Object... arguments) {
        return this.task.task();
    }

}
