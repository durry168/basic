package priv.wwb.sodis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Demo {
    private final static int MAX = 0x10000;
    private final static int MIN = 0x0;
    private final static int SEED = 0xFFFF;
    public static void main(String[] args) {

        List lists = new ArrayList(){{
            add(MIN);
            add(MAX);
        }};
        Random random = new Random();
        for(int i = 1; i <= SEED; i ++){
            lists.add(random.nextInt(SEED));
        }

        System.out.println(Collections.max(lists));
        System.out.println(Collections.min(lists));
    }
}
