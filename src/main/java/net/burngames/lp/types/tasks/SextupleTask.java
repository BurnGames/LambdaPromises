package net.burngames.lp.types.tasks;

/**
 * Represents a task that accepts 6 arguments and returns an object
 *
 * @author PaulBGD
 */
public abstract class SextupleTask<T, U, V, W, X, Y> {

    public abstract Object task(T object, U object2, V object3, W object4, X object5, Y object6);

}
