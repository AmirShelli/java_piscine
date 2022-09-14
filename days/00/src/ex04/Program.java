package ex04;
import java.util.*;
public class Program {

    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();

        Scanner s = new Scanner(System.in);
        String string = s.nextLine();

        while(!string.isEmpty()) {
            Character current = string.charAt(0);
            int count = string.length();
            string = string.replaceAll(String.valueOf(current), "");
            count -= string.length();
            map.put(current, count);
        }
        show_res(map);
    }
    public static HashMap<Character, Integer> sortByValue(HashMap<Character, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Character, Integer> > list =
                new LinkedList<>(hm.entrySet());

        // Sort the list
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // put data from sorted list to hashmap
        HashMap<Character, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static void show_res(HashMap<Character, Integer> map) {
        HashMap<Character, Integer> sortedMap = sortByValue(map);
        Integer max_value= sortedMap.values().iterator().next();
        int i = 11;

        while(i >= 0)
        {
            Iterator<Integer> it_val = sortedMap.values().iterator();
            Iterator<Character> it_key = sortedMap.keySet().iterator();
            int j = 0;
            while(j < sortedMap.size() && j < 10) {
                int current_val = it_val.next();
                int current_key = it_key.next();
                if ((current_val * 10 / max_value) == i - 1)
                    System.out.printf("%-2d",current_val);
                else if(i == 0)
                    System.out.printf("%-2c", (char)current_key);
                else if (current_val * 10 / max_value >= i)
                    System.out.printf("%-2s","#");
                j++;
            }
            System.out.println();
            i--;
        }
    }
}
