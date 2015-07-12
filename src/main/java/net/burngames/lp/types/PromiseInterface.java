package net.burngames.lp.types;

/**
 * Represents a promise that can be completed with any amount of arguments
 *
 * @author PaulBGD
 */
public interface PromiseInterface {

    Object complete(Object... arguments);

}
