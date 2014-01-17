package inc.nishi.avatars.utils;

import inc.nishi.avatars.models.Email;
import org.apache.commons.lang3.StringUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Nishi Inc
 * @since v0.0.1
 */
public abstract class AvatarsUtils {

    public static final String AT   = "@";
    public static final String MD5  = "MD5";

    /**
     *
     * @return 'true' if seemingly valid e-mail address otherwise 'false'
     */
    public static boolean isValidEmail(String email) {
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String hash(Email email) {
        return AvatarsUtils.hash(email.toString());
    }

    /**
     *
     * @param string
     * @return hexHash of given string
     */
    public static String hash(String string) {
        if(StringUtils.isNotBlank(string)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(AvatarsUtils.MD5);
                messageDigest.update(string.getBytes());
                byte byteData[] = messageDigest.digest();

                // Convert the byte to hex format
                StringBuffer hexString = new StringBuffer();
                for (int i = 0; i < byteData.length; i++) {
                    hexString.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
                }

                return hexString.toString();

            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
