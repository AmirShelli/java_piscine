package ex00;

class Dispute extends Thread {
    public String str;
    public int count;
    Dispute(String str, int count) {
        this.str = str;
        this.count = count;
    }
    @Override
    public void run() {
        while (count-- > 0)
            System.out.println(this.str);
    }
}

