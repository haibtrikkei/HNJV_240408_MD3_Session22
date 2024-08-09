package ra.rekkei.demo_springsecurity.common;

import org.mindrot.jbcrypt.BCrypt;

public class GenPass {
    public static void main(String[] args) {
        System.out.println(BCrypt.hashpw("123",BCrypt.gensalt(12)));
    }
}
