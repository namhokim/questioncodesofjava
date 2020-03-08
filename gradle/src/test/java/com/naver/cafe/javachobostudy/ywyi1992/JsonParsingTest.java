package com.naver.cafe.javachobostudy.ywyi1992;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class JsonParsingTest {
    @Test
    public void testParsing() throws Exception {
        List<Object> list = Arrays.asList(
                new AccountDTO(), new AccountDTO(), new MemberVO()
        );
        List<Object> list2 = Arrays.asList(
                new MemberDTO(0, "tester1", "123", "tester1", 'a', "2014/02/03", 7, "12345", "서울 강서구", "1020번지 12호", "ywyi92@gmail.coom", "010-2571-3495", '1', "123", "tester"),
                new MemberDTO(1, "tester2", "123", "tester1", 'a', "2014/02/03", 7, "12345", "서울 강서구", "1020번지 12호", "ywyi92@gmail.coom", "010-2571-3495", '1', "123", "tester"),
                new MemberDTO(2, "tester3", "123", "tester1", 'a', "2014/02/03", 7, "12345", "서울 강서구", "1020번지 12호", "ywyi92@gmail.coom", "010-2571-3495", '1', "123", "tester"),
                new AccountDTO(), new AccountDTO(), new MemberVO());
        String test = null;
        test = new JsonParsing().parsingList(list);
        assertNotNull(test);
        test = new JsonParsing().parsingList(list2);
        assertNotNull(test);
    }
}
