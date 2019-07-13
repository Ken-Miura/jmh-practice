package com.example;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class MyUtilBenchmark {

    @State(Scope.Benchmark)
    public static class Holder {
        private static final long SEED = 1234L;
        private static final Random r = new Random(SEED);
        public long value = 0;

        @Setup(Level.Trial)
        public void setUp () {
            value = r.nextLong();
            System.out.print(String.format("(evaluated value: %d) ", value));
        }
    }

    @Benchmark
    public void benchmarkStdLibBitCount(Holder h) {
        Long.bitCount(h.value);
    }

    @Benchmark
    public void benchmarkMyUtilBitCount(Holder h) {
        MyUtil.bitCount(h.value);
    }
}
