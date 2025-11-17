package org.wedu.wdoa;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
public class JwtTest {

    @Test
    public void test1(){
        //jwt如何生成token（加密字符串）
        //例如：将信息“你好”生成一个token
        // 1. 创建一个加密算法对象(需要提供一个密钥，这里密钥为123456)
        Algorithm algorithm = Algorithm.HMAC256("123456");

        //2. 使用加密算法生成token
        String token = JWT.create()//创建token构建器
                            .withClaim("info", "你好")//放入一个信息（名值对象）
                            .withExpiresAt(new java.util.Date(System.currentTimeMillis()+1000*60))//设置60秒后过期
                            .sign(algorithm);//使用指定的加密算法签名生成一个token（密文）

        log.info(token);

    }
}
