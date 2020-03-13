import com.google.common.collect.HashMultiset;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class MyTest {

    @Test
    public void test1() {
        //集合中有多少元素 guava
        String[] str = {"1", "2", "3", "4", "2", "3", "6", "5", "2"};
        List<String> list = Arrays.asList(str);
        HashMultiset<String> multiset = HashMultiset.create();
        multiset.addAll(list);
        int count = multiset.count("2");
        System.out.println(count);
    }


}
