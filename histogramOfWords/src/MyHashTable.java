public class MyHashTable {
    class ListNode {
        String word;
        int count;
        ListNode next;
        ListNode(String word, int count) {
            this.count = count;
            this.word = word;
        }
    }

    ListNode buckets[];
    MyHashTable(){
        buckets = new ListNode[1024];
    }
    int size;
    MyHashTable(int size) {
        buckets = new ListNode[size];
    }

    int get(String word){
        int hash = word.hashCode() % buckets.length;
        if (hash <0 ) hash = -hash;
        ListNode node = buckets[hash];
        while (node != null) {
            if(node.word.equals(word)){
                return node.count;
            }
            node = node.next;
        }
        return -1;
    }
    void put(String word, int count) {
        int hash = word.hashCode() % buckets.length;
        if (hash < 0) hash = -hash;
        ListNode node = buckets[hash];
        ListNode first = node;
        while (node != null){
            if(node.word.equals(word)){
                node.count = count;
                return;
            }
            node = node.next;
        }
        ListNode newNode = new ListNode(word, count);
        newNode.next = first;
        buckets[hash] = newNode;
        size++;
    }
    int size() {
        return size;
    }
    void printAll() {
        for (int i = 0; i < buckets.length; i++) {
            ListNode node = buckets[i];
            while (node != null) {
                System.out.println(node.word + " : " + node.count);
                node = node.next;
            }
        }
    }
}
