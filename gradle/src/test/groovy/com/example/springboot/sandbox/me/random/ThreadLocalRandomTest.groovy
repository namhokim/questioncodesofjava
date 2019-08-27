package com.example.springboot.sandbox.me.random

import spock.lang.Shared
import spock.lang.Specification

import java.util.concurrent.ThreadLocalRandom

class ThreadLocalRandomTest extends Specification {
    @Shared
    private int[] count

    def setupSpec() {
        count = new int[100]
    }

    def cleanupSpec() {
        println count
        println standardDeviation(count, 0)
    }

    def "test using ThreadLocalRandom"() {
        when:
        for (int i = 0; i < 100; i++) {
            int nextint = ThreadLocalRandom.current().nextInt(100)
            count[nextint]++
        }

        then:
        count.length > 0
    }

    def "test using random"() {
        given:
        def random = new Random()

        when:
        for (int i = 0; i < 100; i++) {
            int nextint = random.nextInt(100)
            count[nextint]++
        }

        then:
        count.length > 0
    }

    static double standardDeviation(int[] array, int option) {
        if (array.length < 2) return Double.NaN

        double sum = 0.0
        double diff
        double meanValue = mean(array)

        for (int i = 0; i < array.length; i++) {
            diff = array[i] - meanValue
            sum += diff * diff
        }

        Math.sqrt(sum / (array.length - option))
    }
    /**
     * 산술 평균
     */
    static double mean(int[] array) {
        int sum = 0

        for (int i = 0; i < array.length; i++) {
            sum += array[i]
        }

        (double) sum / array.length
    }
}
