package net.burngames.lp;

import net.burngames.lp.types.EmptyPromise;
import net.burngames.lp.types.PromiseInterface;
import net.burngames.lp.types.tasks.TaskType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author PaulBGD
 */
public class Promise {

    protected final List<PromiseInterface> interfaces = new ArrayList<>();
    protected final List<PromiseInterface> dynamic = new ArrayList<>();
    protected final List<Runnable> finish = new ArrayList<>();
    protected final TaskType taskType;
    protected Consumer<Throwable> exception;

    public Promise() {
        this(TaskType.SYNC);
    }

    public Promise(TaskType taskType) {
        this.taskType = taskType;
    }

    public Promise(TaskType taskType, EmptyPromise initital) {
        this.taskType = taskType;
        this.interfaces.add(initital);
    }

    public Promise(EmptyPromise initial) {
        this(TaskType.SYNC, initial);
    }

    public Promise then(PromiseInterface promise) {
        this.interfaces.add(promise);
        return this;
    }

    public Promise exception(Consumer<Throwable> exception) {
        this.exception = exception;
        return this;
    }

    public Promise finish(Runnable runnable) {
        this.finish.add(runnable);
        return this;
    }

    public void run() {
        new PromiseRunner(this);
    }

}
