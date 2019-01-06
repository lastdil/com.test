package cms.utils;

public class GenerateEmail {
    public String generate() {
        String email = "autotest" + System.currentTimeMillis();
        email += "@cloudbridge.ru";
        returшn email;
    }
}