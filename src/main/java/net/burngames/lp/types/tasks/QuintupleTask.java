package net.burngames.lp.types.tasks;

/**
 * Represents a task that accepts 5 arguments and returns an object
 *
 * @author PaulBGD
 */
public abstract class QuintupleTask<T, U, V, W, X> {
    public abstract Object task(T object, U object2, V object3, W object4, X object5);
}
