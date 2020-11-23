package org.geekbang.time.commonmistakes.java8;

/**
 * TODO
 *
 * @date 2020/4/15 0:06
 */
public class Test {
    @org.junit.Test
    public void test() {
        Integer i1 = 127;
        Integer i2 = 127;
        System.err.println(i1 == i2);

        i1 = 128;
        i2 = 128;
        System.err.println(i1 == i2);
        
    }
}
