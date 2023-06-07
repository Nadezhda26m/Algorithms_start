package seminar4;

public class Seminar4 {
    public static void main(String[] args) {
        Mapa<String, String> mapa = new Mapa<>();
        for (int i = 0; i < 15; i++) {
            mapa.put(Integer.toString(i + 10), Integer.toString(i));
        }
        System.out.println("> K 10-24, V 0-14\n");
        System.out.println("size = " + mapa.size());
        System.out.println("get K 11 = V " + mapa.get("11"));
        System.out.println("get K 28 = V " + mapa.get("28"));
        System.out.println("remove last 13 = " + mapa.remove("13"));
        System.out.println("size = " + mapa.size());
        System.out.println("remove first 23 = " + mapa.remove("23"));
        System.out.println("size = " + mapa.size());
        System.out.println("remove middle 16 = " + mapa.remove("16"));
        System.out.println("size = " + mapa.size());
        System.out.println("get K 13 = V " + mapa.get("13"));
        System.out.println("replays K 11 V 101 = " + mapa.replays("11", "101"));
        System.out.println("get K 11 = V " + mapa.get("11"));
        System.out.println("containsKey 13 = " + mapa.containsKey("13"));
        System.out.println("containsKey 11 = " + mapa.containsKey("11"));
        System.out.println("containsValue 12 = " + mapa.containsValue("12"));
        System.out.println("containsValue 454tr = " + mapa.containsValue("454tr"));
    }
}
