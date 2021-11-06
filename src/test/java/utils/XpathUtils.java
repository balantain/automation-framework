package utils;

public class XpathUtils {
    public static String createSpecialXpath(String basicXpath, String specialTerm) {
        return basicXpath.replace("''", "'" + specialTerm + "'");
    }
}
