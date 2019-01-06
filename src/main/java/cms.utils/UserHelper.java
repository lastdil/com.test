package cms.utils;

import cms.utils.objects.User;

public class UserHelper {
    public Object createUser(String firstName, String lastName, String email, String phone, String password, String code){
        User user = new User();
        user.setFirst_name(firstName);
        user.setLast_name(lastName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setPassword(password);
        user.setCode(code);
        return user;
    }

}
