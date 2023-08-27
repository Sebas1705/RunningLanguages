package VersionsChanges;
public class Java13 {
    
    public static void main(String[] args) {
        
        ///Enhanced switches\\\
        String day = "TUESDAY";
        String result = switch (day) {
            case "MONDAY", "FRIDAY", "SUNDAY" -> "Start of the workweek";
            case "TUESDAY" -> {
                yield "Second day of the workweek";//"Return" in switches
            }
            default -> {
                String a="///"+day+"\\\\\\";
                yield a;
            }
        };
        System.out.println(result);


        ///Text Block\\\
        String text="""
            Last
            Day
            On
            Earth
            """;
        System.out.println(text);

    }
}
