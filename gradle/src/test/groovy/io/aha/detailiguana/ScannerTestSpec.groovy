package io.aha.detailiguana

import spock.lang.Specification
import spock.lang.Unroll

class ScannerTestSpec extends Specification {
    @Unroll
    def '입력을 "#input" 을 받을 경우 결과는 "#expectedResult" 가 된다.'() {
        given:

        when:
        def result = ScannerTest.wrap(input)

        then:
        result == expectedResult

        where:
        input                || expectedResult
        null                 || null
        ''                   || ''
        '안녕?'                || '[안녕?]'
        ' 안녕?'               || ' [안녕?]'
        '안녕? '               || '[안녕?] '
        '가야 한다.'             || '[가야] [한다.]'
        ' 가야 한다.'            || ' [가야] [한다.]'
        '가야 한다. '            || '[가야] [한다.] '
        '가야  한다.'            || '[가야]  [한다.]'
        '나는 오늘도 회사에 가야 한다.'  || '나는 오늘도 회사에 [가야] [한다.]'
        '나는  오늘도 회사에 가야 한다.' || '나는  오늘도 회사에 [가야] [한다.]'
        '나는 오늘도  회사에 가야 한다.' || '나는 오늘도  회사에 [가야] [한다.]'
        '나는 오늘도 회사에 가야  한다.' || '나는 오늘도 회사에 [가야]  [한다.]'
        '나는 오늘도 회사에 가야 한다. ' || '나는 오늘도 회사에 [가야] [한다.] '
    }
}
