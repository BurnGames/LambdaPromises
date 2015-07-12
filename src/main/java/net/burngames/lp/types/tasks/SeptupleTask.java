package net.burngames.lp.types.tasks;

/**
 * Represents a task that accept 7 arguments and returns an object
 *
 * @author PaulBGD
 */
public abstract class SeptupleTask<T, U, V, W, X, Y, Z> {

    public abstract Object task(T object, U object2, V object3, W object4, X object5, Y object6, Z object7);

}
