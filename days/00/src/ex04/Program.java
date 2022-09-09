package ex04;
import java.util.*;
public class Program {

    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<Char, Integer>();

        Scanner s = new Scanner(System.in);
        String string = s.nextLine();

        while(!string.isEmpty()) {
            Character current = string.charAt(0);
            int count = string.length() - string.replaceAll(String.valueOf(current), "").length();
            map.put(current, count);
        }
    }
    public static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Character, Integer> > list =
                new LinkedList<Map.Entry<Character, Integer> >(hm.entrySet());

        // Sort the list
        list.sort(new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> o1,
                               Map.Entry<Character, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Character, Integer> temp = new LinkedHashMap<Character, Integer>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static void show_res(HashMap<Character, Integer> map) {
        HashMap<Character, Integer> sortedMap = sortByValue(map);
        Integer max_value= map.values().iterator().next();
        int i = 0;
        while(i < 10)
        {
            Iterator<Integer> it = map.values().iterator();
            while(j < 10) {
                if (it.next() * 10 / max_value == i)
                    System.out.print("#");
            }
            i++;
        }
    }
}
