package ex03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TooManyThreads extends Thread{

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

    private int getAccess() {
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
