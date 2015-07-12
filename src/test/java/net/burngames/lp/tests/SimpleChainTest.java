package net.burngames.lp.tests;

import com.mscharhag.oleaster.runner.OleasterRunner;
import net.burngames.lp.Promise;
import net.burngames.lp.types.DoublePromise;
import net.burngames.lp.types.EmptyPromise;
import net.burngames.lp.types.tasks.TaskType;
import org.junit.runner.RunWith;

import static com.mscharhag.oleaster.matcher.Matchers.expect;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.describe;
import static com.mscharhag.oleaster.runner.StaticRunnerSupport.it;

/**
 * @author PaulBGD
 */
@RunWith(OleasterRunner.class)
public class SimpleChainTest {{
    describe("Chains", () -> {
        it("can do a simple chain", () -> {
            new Promise(new EmptyPromise(() -> {
                return new Object[]{true, 0.4};
            })).then(new DoublePromise<Boolean, Double>((bool, doub) -> {
                expect((boolean) bool).toBeTrue();
                expect((double) doub).toEqual(0.4);
                return null;
            })).run();
        });

        it("can handle exceptions", () -> {
            final boolean[] called = {false};
            new Promise(new EmptyPromise(() -> {
                throw new IllegalArgumentException("Bah");
            })).exception(throwable -> called[0] = true).run();
            expect(called[0]).toBeTrue();
        });

        it("stops execution when an exception occurs", () -> {
            final boolean[] called = {false};

            new Promise(new EmptyPromise(() -> {
                throw new IllegalArgumentException("Bah");
            })).then(new EmptyPromise(() -> called[0] = true)).run();
            expect(called[0]).toBeFalse();
        });

        it("can run tasks async", () -> {
            Thread current = Thread.currentThread();

            new Promise(TaskType.ASYNC, new EmptyPromise(() -> {
                // fixme async test is not detected
                expect(current != Thread.currentThread()).toBeFalse();
                return null;
            })).run();
        });

        it("requires the exact amount of arguments", () -> {
            final Throwable[] exception = {null};
            new Promise(new EmptyPromise(() -> {
                return null; // no arguments
            })).then(new DoublePromise<>((object, object2) -> { // expecting 2
                return null;
            })).exception((throwable) -> exception[0] = throwable).run();

            expect(exception[0]).toBeNotNull();
        });
    });
}}
