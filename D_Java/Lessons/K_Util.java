
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class K_Util {
    
    public static void main(String[] args) {
        
        //Lists (unique type & multiple same values)\\
        List<Integer> list;

        list = new ArrayList<Integer>(); //Sequential list
        list = new LinkedList<Integer>(); //Linked list
        list = new Vector<Integer>(); //Vector list (synchronized)
        list = new Stack<Integer>(); //LIFO list
        list = new CopyOnWriteArrayList<Integer>(); //Secure for writers and lectures threads with copies (affect memory and time)
        System.out.println(list);


        //Sets (unique type & unique same value)\\
        Set<Integer> set;

        set = new HashSet<Integer>(); //Hash table as a set (no add order)
        set = new LinkedHashSet<Integer>(); //HashSet with order of addition
        set = new TreeSet<Integer>(); //Tree (red-black) as a set with a natural ordering or with a comparator personalized
        System.out.println(set);

        //Queue (FIFO)\\
        Queue<Integer> queue;

        queue = new ArrayDeque<Integer>(); //Array list as a queue
        queue = new PriorityQueue<Integer>(); //PriorityQueue with a heap
        System.out.println(queue);


        //Others\\
        HashMap<Integer,String> map = new HashMap<Integer,String>();//Typically hash map (not order)
        System.out.println(map);

        LinkedHashMap<Integer,String> map2 = new LinkedHashMap<Integer,String>();//Hash map with order (adding)
        System.out.println(map2);

        TreeMap<Integer,String> map3 = new TreeMap<Integer,String>(); //order map in a tree structure
        System.out.println(map3);

        WeakHashMap<Integer,String> map4 = new WeakHashMap<Integer,String>(); //hash map with keys that jdk can delete
        System.out.println(map4);

        IdentityHashMap<Integer,String> map5 = new IdentityHashMap<Integer,String>(); //key instance equal, it's identity
        System.out.println(map5);

        Properties properties = new Properties();
        properties.setProperty("name","Pedro");
        System.out.println(properties.getProperty("name"));

        Calendar cal = Calendar.getInstance();
        System.out.println(cal);

        Date date = new Date();
        System.out.println(date);
    }
}
