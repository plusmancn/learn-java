package Exercise.classes;

import com.sun.tools.javac.util.StringUtils;

public class IpAddress {
    public boolean isValidIpAddressV1(String ipAddress) {
        if(ipAddress.isEmpty()) {
            return false;
        }

        String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\." +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|\\d{1,2})\\." +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|\\d{1,2})\\." +
                "(1\\d{2}|2[0-4]\\d|25[0-5]|\\d{1,2})$";

        return ipAddress.matches(regex);
    }

    public boolean isValidIpAddressV2(String ipAddress) {
        if(ipAddress.isEmpty()) {
            return false;
        }

        String[] ipArrsStr = ipAddress.split("\\.");

        if(ipArrsStr.length != 4) {
            return false;
        }

        int[] ipArrsNum = new int[4];
        for(int i = 0; i < 4; i++) {
            try {
                ipArrsNum[i] = Integer.parseInt(ipArrsStr[i]);

                if(ipArrsNum[i] < 0 && ipArrsNum[i] > 255) {
                    return false;
                }

                if(i == 0 && ipArrsNum[i] == 0) {
                    return false;
                }

            } catch (NumberFormatException err) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        IpAddress ipAddress = new IpAddress();
        System.out.println(ipAddress.isValidIpAddressV2("127.1.1.0"));
        System.out.println(ipAddress.isValidIpAddressV2("0.1.1.0"));
    }
}
