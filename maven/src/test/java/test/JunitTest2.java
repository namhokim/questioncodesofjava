package test;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class JunitTest2 {

    private static JunitTest2 testObject;

    @Test
    public void test1() {
        assertThat(this).isNotSameAs(testObject);
        testObject = this;
    }

    @Test
    public void test2() {
        assertThat(this).isNotSameAs(testObject);
        testObject = this;
    }

    @Test
    public void test3() {
        assertThat(this).isNotSameAs(testObject);
        testObject = this;
    }
}
