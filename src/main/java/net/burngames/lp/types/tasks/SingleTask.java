package net.burngames.lp.types.tasks;

/**
 * Represents a task that accepts 1 argument and returns an object
 *
 * @author PaulBGD
 */
public abstract class SingleTask<T> {
    public abstract Object task(T object1);
}
