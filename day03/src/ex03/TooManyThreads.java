package ex03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TooManyThreads{
    ArrayList<Thread> threads = new ArrayList<>();
    private static final AtomicInteger count = new AtomicInteger(0);
    private Map<Integer, Boolean> files = getFileInfo();
    private final int _threadCount;

    TooManyThreads(int _threadCount) {
        this._threadCount = _threadCount;
    }
    private Map<Integer, Boolean> getFileInfo() {
        Map<Integer, Boolean> files = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("file_urls.txt"))) {
            String line;
            int i = 0;
            while ((line = reader.readLine()) != null)
                files.put(i++, false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return files;
    }
    public void startThreads() {
        for(int i = 0; i < _threadCount; i++)
            threads.add(new Downloader());
    }
    public void joinThreads() throws InterruptedException {
        for(Thread e : threads)
            e.join();
    }
    class Downloader extends Thread {

        private final int _threadNum;

        Downloader(){
            _threadNum = count.incrementAndGet();
            this.start();
        }
        @Override
        public void run() {

            while(files.values().stream().allMatch(Boolean::booleanValue)) {
                synchronized (this) {
                    Integer _fileNumber = files.entrySet().stream()
                            .filter(Map.Entry::getValue)
                            .map(Map.Entry::getKey)
                            .findFirst().get();
                    System.out.println("thread-" + _threadNum + " start download file number " + 0);
                    files.put(_fileNumber, true);
                }
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("thread-" + _threadNum + " finish download file number " + 0);
            }
        }
    }

}
