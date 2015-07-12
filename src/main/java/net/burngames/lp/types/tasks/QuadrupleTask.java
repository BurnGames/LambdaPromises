package net.burngames.lp.types.tasks;

/**
 * Represents a task that accepts 4 arguments and returns an object
 *
 * @author PaulBGD
 */
public abstract class QuadrupleTask<T, U, V, W> {
    public abstract Object task(T object, U object2, V object3, W object4);
}
