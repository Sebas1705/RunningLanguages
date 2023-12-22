package MergeStringChecker;

public class StringMerger {
    public static boolean isMerge(String s, String part1, String part2) {
      if(!(s.contains(part1)&&s.contains(part2))) return false;
      String[] split1 = s.split(part1);
      String[] split2 = s.split(part2);
      System.out.println(split1[1]);
      System.out.println(split2[0]);
      return true;
    }
    public static void main(String[] args) {
        StringMerger.isMerge("codewars", "code", "wars");
    }
}
