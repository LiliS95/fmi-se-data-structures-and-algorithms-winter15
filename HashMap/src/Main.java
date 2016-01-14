
import com.fmi.dsa.hashmap.MyMap;
import com.fmi.dsa.hashmap.StringHashMap;
import java.util.NoSuchElementException;

/**
 *
 * @author Dimitar
 */
public class Main {

    public static void main(String[] args) {
        MyMap<Integer> map = new StringHashMap<>();

        map.insert("one", 1);
        map.insert("two", 2);
        map.insert("three", 3);

        map.delete("three");

        System.out.println(map.get("one"));
        System.out.println(map.get("two"));

        try {
            System.out.println(map.get("three"));
        } catch (NoSuchElementException ex) {
            System.out.println("null");
        }
    }
}
