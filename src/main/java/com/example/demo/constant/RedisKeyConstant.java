package com.example.demo.constant;

public interface RedisKeyConstant {

    interface user {
        String USER_CHECKIN = "user:checkin:";

        String USER_CHECKIN_RANK = "user:checkin:rank:";
    }


    interface captcha {
        String CAPTCHA_UUID = "captcha:uuid:";

        String CAPTCHA_EMAIL_ADDRESS = "captcha:email_address:";
    }

    interface token {
        String TOKEN_USERNAME = "token:username:";
    }

    interface limiter {
        String IP_URL_BLOCK = "ip:url:block:";

        String IP_URL_TIMES = "ip:url:times:";

        /*
        Allowing 10 times max of same request uri within 2 second, otherwise ip get locked for 60 seconds.
         */
        long LIMIT_TIMES = 10;

        int IP_LOCK_TIME = 60;

        int LIMIT_SECOND = 2;
    }

    interface url {
        String SHORT_URL_PREFIX = "short:prefix:";
    }
}
