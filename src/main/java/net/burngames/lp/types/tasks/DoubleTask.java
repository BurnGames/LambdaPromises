package net.burngames.lp.types.tasks;

/**
 * @author PaulBGD
 */
public interface DoubleTask<T, U> {

    Object task(T object, U object2);

}
