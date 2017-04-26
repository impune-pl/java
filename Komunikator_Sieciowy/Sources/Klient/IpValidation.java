package main;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.net.Inet4Address;
public class IpValidation
{
    public static Boolean isIPv4Address(String address) {
        if (address.isEmpty()) {
            return false;
        }
        try {
            Object res = InetAddress.getByName(address);
            return res instanceof Inet4Address;
        } catch (final UnknownHostException ex) {
            return false;
        }
    }
}
