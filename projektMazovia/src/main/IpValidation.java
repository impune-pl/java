package main;
import java.util.Arrays;
/**
 * Created by Krzysztof 'impune_pl' on 2017-02-15.
 */
public class IpValidation {

    /**
     * Check that a string consists of only numbers
     * @param string The string to check
     * @return true if string consits of only numbers, false otherwise
     */
    public static boolean isNumeric(String string) {
        for(char c : string.toCharArray()) {
            if(c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isIp(String string) {
        String[] parts = string.split("\\.", -1);
        return parts.length == 4 // 4 parts
                && Arrays.stream(parts)
                .filter(IpValidation::isNumeric) // Only numbers
                .map(Integer::parseInt)
                .filter(i -> i <= 255 && i >= 0) // Must be inside [0, 255]
                .count() == 4; // 4 numerical parts inside [0, 255]
    }
}
