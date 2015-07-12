package net.burngames.lp.types.tasks;

/**
 * Represents a task that accepts 2 arguments and returns an object
 *
 * @author PaulBGD
 */
public interface DoubleTask<T, U> {
    Object task(T object, U object2);
}
