package net.burngames.lp.types;

import java.util.function.BiConsumer;

/**
 * Represents a promise that occurs later
 *
 * @author PaulBGD
 */
public abstract class DelayedPromise implements PromiseInterface {

    protected final PromiseInterface promise;

    public DelayedPromise(PromiseInterface promise) {
        this.promise = promise;
    }

    @Override
    public Object complete(Object... arguments) {
        return null;
    }

    /**
     * This method should call the BiConsumer BACK ON THE MAIN THREAD
     */
    public abstract void complete(BiConsumer<Object, Throwable> finished, Object... arguments);

}
