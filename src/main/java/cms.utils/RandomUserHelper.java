package cms.utils;

import java.util.Random;

/**
 * Created by npletnyova on 14.06.2017.
 */
@SuppressWarnings("ALL")
public class RandomUserHelper {
   public int generateRandomUser() {
        Random r = new Random(System.currentTimeMillis());
        int userId = r.nextInt(1240000 - 1230000) + 1230000;
        System.out.print(userId);
        return userId;
    }

 }