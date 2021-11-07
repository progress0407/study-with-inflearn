package playgroundjava.honuxcalandar;

public enum Week {

    SU("su", 0),
    MO("mo", 1),
    TU("tu", 2),
    WE("we", 3),
    TH("th", 4),
    FR("fr", 5),
    SA("sa", 6);

    private String name;
    private int val;

    Week(String name, int val) {
        this.name = name;
        this.val = val;
    }

    /**
     *
     * @param name 요일명. 예) su
     * @return 0 ~ 6 (0 = Sunday, 6 = Saturday)
     */
    public static int of(String name) {
        return Week.valueOf(name.toUpperCase()).val;
    }

}
