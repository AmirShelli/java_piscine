package ex04;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {

    private Integer length = 0;

    private final TransactionNode start = new TransactionNode(null, null, null);
    private final TransactionNode tail = new TransactionNode(null, null, null);

    public TransactionsLinkedList() {
        start.setNext(tail);
        tail.setPrevious(start);
    }

    @Override
    public void addTransaction(Transaction transaction) {
        start.setNext(new TransactionNode(start.getNext(), start, transaction));
        this.length++;
    }

    @Override
    public void deleteTransaction(UUID uuid) {
        TransactionNode tmp = start.getNext();
        while (tmp != tail)	{
            if (tmp.getData().getId().equals(uuid))	{
                tmp.getPrevious().setNext(tmp.getNext());
                tmp.setData(null);
                tmp.setPrevious(null);
                tmp.setNext(null);
                this.length--;
                return;
            }
            tmp = tmp.getNext();
        }
        try {
            throw new TransactionNotFoundException("Transaction not Found");
        } catch (TransactionNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] ret = new Transaction[this.length];
        TransactionNode tmp = this.start.getNext();

        if (tmp.getData() == null)	{
            try {
                throw new TransactionNotFoundException("List Empty");
            } catch (TransactionNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        for (int i = 0; i < this.length; i++) {
            ret[i] = tmp.getData();
        }
        return (ret);
    }

    class TransactionNode	{

        private TransactionNode	next;
        private TransactionNode	previous;
        private Transaction data;

        public TransactionNode(TransactionNode next, TransactionNode previous, Transaction data) {
            this.next = next;
            this.previous = previous;
            this.data = data;
        }

        public TransactionNode getNext() {
            return next;
        }

        public void setNext(TransactionNode next) {
            this.next = next;
        }

        public TransactionNode getPrevious() {
            return previous;
        }

        public void setPrevious(TransactionNode previous) {
            this.previous = previous;
        }

        public Transaction getData() {
            return data;
        }

        public void setData(Transaction data) {
            this.data = data;
        }
    }
}

