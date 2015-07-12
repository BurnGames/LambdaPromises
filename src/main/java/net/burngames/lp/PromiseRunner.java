package net.burngames.lp;

import net.burngames.lp.types.DelayedPromise;
import net.burngames.lp.types.PromiseInterface;
import net.burngames.lp.types.tasks.TaskType;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * A separate object for running Promises
 *
 * @author PaulBGD
 */
public class PromiseRunner {

    private static final Executor EXECUTOR = Executors.newCachedThreadPool();
    private static final Object[] EMPTY_OBJECT = new Object[0];

    private final Promise promise;
    private Object[] previous = EMPTY_OBJECT;
    private int index = 0;

    public PromiseRunner(Promise promise) {
        this.promise = promise;
        if (promise.taskType == TaskType.ASYNC) {
            EXECUTOR.execute(this::next);
        } else if (promise.taskType == TaskType.SYNC) {
            next();
        } else {
            throw new IllegalArgumentException("Invalid Task Type " + promise.taskType);
        }
    }

    private void next() {
        if (!promise.dynamic.isEmpty()) {
            handle(promise.dynamic.remove(0));
        } else if (index < promise.interfaces.size()) {
            PromiseInterface promise = this.promise.interfaces.get(index++);
            handle(promise);
        } else {
            for (Runnable runnable : promise.finish) {
                try {
                    runnable.run();
                } catch (Throwable throwable) {
                    if (this.promise.exception != null) {
                        this.promise.exception.accept(throwable);
                    }
                }
            }
        }
    }

    private void handle(PromiseInterface promise) {
        if (promise instanceof DelayedPromise) {
            ((DelayedPromise) promise).complete((complete, throwable) -> {
                if (throwable != null) {
                    if (this.promise.exception != null) {
                        this.promise.exception.accept(throwable);
                    }
                    return;
                }
                handleResponse(complete);
            });
        } else {
            Object complete;
            try {
                complete = promise.complete(this.previous);
            } catch (Throwable throwable) {
                if (this.promise.exception != null) {
                    this.promise.exception.accept(throwable);
                }
                return;
            }
            handleResponse(complete);
        }
    }

    private void handleResponse(Object complete) {
        if (complete instanceof PromiseInterface) {
            this.promise.dynamic.add((PromiseInterface) complete);
        } else if (complete instanceof Object[]) {
            this.previous = (Object[]) complete; // sync return
        } else if (complete != null) {
            this.previous = new Object[]{complete}; // also sync return
        } else {
            this.previous = EMPTY_OBJECT;
        }
        next();
    }

}
