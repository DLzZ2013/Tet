package cn.edu.tetcouponmanager.utils;

import com.alibaba.druid.sql.visitor.functions.Char;
import org.apache.ibatis.reflection.ArrayUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:DLzZ2013
 * @Description:
 * @Date:Create in 10:50 2019/12/28
 * @Modified By:
 */
@Component
public class IdUtil {

    private static final String[] chars={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","d"
    ,"u","v","w","x","y","z","1","2","3","4","5","6","7","8","9","0"};
   @Async("getAsyncExecutor")
    public Future<String> generateId(String cMerchantId) {
        //取商户id前三位后和后三位创建优惠券id
       StringBuilder stringBuilder = new StringBuilder(cMerchantId);
       String start = stringBuilder.substring(0, 3);
        String end = stringBuilder.substring(cMerchantId.length() - 4);
        //组合
       //前六位  第七位+第八位*第九位/3 作为放库的依据
       Random random = new Random();
       int r1 = random.nextInt(10);
       int r2 = random.nextInt(10);
       int r3 = random.nextInt(10);
       List<String> collect = Stream.of(chars).collect(Collectors.toList());
       Collections.shuffle(collect);
       String str = collect.stream().collect(Collectors.joining());
       StringBuilder builder = new StringBuilder().append(start).append(end).append(r1).append(r2).append(r3)
               .append(str);
       return new AsyncResult(builder.toString());

   }

    public String generateIdNoAsync(String cMerchantId) {
        //取商户id前三位后和后三位创建优惠券id
        StringBuilder stringBuilder = new StringBuilder(cMerchantId);
        String start = stringBuilder.substring(0, 3);
        String end = stringBuilder.substring(cMerchantId.length() - 4);
        //组合
        //前六位  第七位+第八位*第九位/3 作为放库的依据
        Random random = new Random();
        int r1 = random.nextInt(10);
        int r2 = random.nextInt(10);
        int r3 = random.nextInt(10);
        List<String> collect = Stream.of(chars).collect(Collectors.toList());
        Collections.shuffle(collect);
        String str = collect.stream().collect(Collectors.joining());
        StringBuilder builder = new StringBuilder().append(start).append(end).append(r1).append(r2).append(r3)
                .append(str);
        return builder.toString();
    }
}
