package ex02;

import java.util.ArrayList;

class RealMultithreading {
    private int ARRAY_SIZE = -1;
    private int THREADS_COUNT = -1;

    private final String[] _args;
    private int[] _array;

    private int _threadSum = 0;

    public RealMultithreading(String[] _args) {
        this._args = _args;
        validateFlag();
    }

    private int error () {
        System.err.println("ERROR:\n\t" + "Wrong arguments");
        return -1;
    }

    private void validateFlag()
    {
        int len = _args.length;
        if (len != 2) {
            System.exit(error());
        }

        for (String arg : _args) {
            if (arg.startsWith("--arraySize=")) {
                try {
                    ARRAY_SIZE = Integer.parseInt(arg.substring(12));
                } catch (NumberFormatException e) {
                    return;
                }
            } else if (arg.startsWith("--threadsCount=")) {
                try {
                    THREADS_COUNT = Integer.parseInt(arg.substring(15));
                } catch (NumberFormatException e) {
                    return;
                }
            } else {
                System.exit(error());
            }
        }
    }

    public void createArray() {
        _array = new int[ARRAY_SIZE];

        for (int i = 0; i < ARRAY_SIZE; i++) {
            int _arrayMinValue = 1;
            int _arrayMaxValue = 30;
            _array[i] = (_arrayMinValue + (int)(Math.random() * (_arrayMaxValue - _arrayMinValue)));
        }
    }

    public void printBaseSum() {
        int sum = 0;
        for (int i = 0; i < ARRAY_SIZE; i++) {
            sum += _array[i];
        }
        System.out.println("Sum: " + sum);
    }

    public void startThreads() throws InterruptedException {

        int arrayDist = ARRAY_SIZE / THREADS_COUNT;
        int from = 0;
        int to = arrayDist - 1;

        ArrayList<CountSum> list = new ArrayList<>();

        for (int i = 1; i <= THREADS_COUNT; i++) {
            if (i == THREADS_COUNT) {
                to = _array.length - 1;
            }
            CountSum thread = new CountSum(i, from, to);
            thread.start();
            list.add(thread);

            from = to + 1;
            to = from + arrayDist - 1;

            if (to > _array.length - 1) {
                to = _array.length - 1;
            }
        }

        for (int i = 0; i < THREADS_COUNT; i++) {
            list.get(i).join();
        }
    }

    class CountSum extends Thread {

        int _from;
        int _to;
        int _threadNmb;

        public CountSum(int threadNmb, int startPos, int finishPos) {
            this._threadNmb = threadNmb;
            this._from = startPos;
            this._to = finishPos;
        }

        @Override
        public void run() {
            int sum = 0;

            synchronized (this) {
                for (int i = _from; i <= _to; i++) {
                    sum += _array[i];
                }
                System.out.println("Thread " + _threadNmb + ": from " + _from + " to " + _to + " sum is " + sum);
                _threadSum += sum;
            }
        }
    }

    public void printThreadSum() {
        System.out.println("Sum by threads: " + _threadSum);
    }
}
