package cms.utils;

import java.util.Random;

/**
 * Created by npletnyova on 14.06.2017.
 */

public class RandomIdHelper {
    public String generateRandomId() {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String id = "";
        //String rule = "";
        Random random = new Random();
        int randomLen = 1 + random.nextInt(9);
        for (int i = 0; i < randomLen; i++)

        {
            char c = alphabet.charAt(random.nextInt(26));
            id += c;
            //   char w = alphabet.charAt(random.nextInt(26));
            //   rule+=w;

            System.out.println(id);
        }
        return id;
    }
}
