package amazon;

public class AmazonUtil {
    public static float convertStrToFloat(String str) throws AmazonException {
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException e) {
            throw new AmazonException("Invalid number format");
        }
    }

    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }

    public static boolean isValidPhoneNumber(String phone) {
        return phone.matches("\\d{10}");
    }

    public static boolean isValidString(String str) {
        return str != null && !str.isEmpty();
    }
}
