package ex03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TooManyThreads extends Thread{

    private final Map<Integer, Boolean> files = getFileInfo();
    private Map<Integer, Boolean> getFileInfo() {
        Map<Integer, Boolean> files = new HashMap<>();
        try (FileReader file = new FileReader("file_urls.txt")) {
            int i = 0;
            while(file.read() > 0) files[i++] = false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return files;
    }
    private int getAccess() {
        while()
    }
    @Override
    public void run() {

        synchronized (this) {
            boolean isDownloading = files.values().stream().allMatch(Boolean::booleanValue);
            while(isDownloading) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        System.out.println("thread-" + _threadNum + " start download file number " + _fileNumber);
        try {
            files[_fileNumber] = true;
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("thread-" + _threadnum + " finish download file number " + _fileNumber);
        files[_fileNumber] = false;
    }
}
