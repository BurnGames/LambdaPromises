package net.burngames.lp.types.tasks;

/**
 * Represents a task that accepts 3 arguments and returns an object
 *
 * @author PaulBGD
 */
public abstract class TripleTask<T, U, V> {

    public abstract Object task(T object, U object2, V object3);

}
