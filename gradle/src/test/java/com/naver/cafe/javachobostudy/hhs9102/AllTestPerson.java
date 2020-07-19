package com.naver.cafe.javachobostudy.hhs9102;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class AllTestPerson {
    List<Person> list1;
    List<Person> list2;

    @Before
    public void before(){
        list1 = Arrays.asList(new Person("철수","김"), new Person("길동","홍"));
        list2 = Arrays.asList(new Person("철수","방"));
    }

    @Test
    public void test(){
        for(Person p1 : list1){
            for(Person p2 : list2){
                if(p1.getFirstName().equals(p2.firstName)){
//p1, p2의 객체 활용
                    assertEquals("김철수", p1.getLastName()+p2.getFirstName());
                }
            }
        }
    }

    public class Person{
        String firstName;
        String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }
}
