package id.boenkkk.app.util;

import java.util.Random;

public class StringUtil {

    public String generateString(){
        String SALTCHARS = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghjklmnpqrstuvwxyz123456789";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }

        String generatedString = salt.toString();

        return generatedString;
    }

}
