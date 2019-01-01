package com.zty;

import com.zty.util.RandomSaltUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZtyCmfzApplicationTests {

    @Test
    public void test() {
        //   String uid, String type, String sub_type
        for (int i = 0; i < 5; i++) {
            String realpassword = DigestUtils.md5Hex("123456");
            String salt = RandomSaltUtil.generetRandomSaltCode();
            System.out.println(salt);
            System.out.println(realpassword + salt);
        }
    }

}

