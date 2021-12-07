package de.its.fti;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Wrapper {

    /**
     * Extrahiert den Text zwischen den übergebenen Tags
     *
     * @param tag Tags
     * @param text Text noch mit Tags
     * @return Text ohne Tags
     */
    public static String deWrap(String tag, String text) {
        final Pattern tmpPattern = Pattern.compile("<" + tag + ">(.+?)</" + tag + ">", Pattern.DOTALL);
        final Matcher matcher = tmpPattern.matcher(text);
        matcher.find();
        return matcher.group(1);
    }

    /**
     * Hüllt den Text in die übergebenen Tags
     *
     * @param tag Tags
     * @param text Text ohne Tags
     * @return Text mit Tags
     */
    public static String wrap(String tag, String text) {
        return "<" + tag + ">" + text + "</" + tag + ">";
    }
}
