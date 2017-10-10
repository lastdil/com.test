package cms.utils.objects


import com.fasterxml.jackson.annotation.JsonInclude

/**
 * Created by lastdil on 28/06/2017.
 */
//@JsonInclude(JsonInclude.Include.NON_EMPTY)
class User {

    String first_name
    String last_name
    String email
    String phone
    String password
    String code

    User(String first_name, String last_name, String email, String phone, String password, String code) {
        this.first_name = first_name
        this.last_name = last_name
        this.email = email
        this.phone = phone
        this.password = password
        this.code = code
    }


}
