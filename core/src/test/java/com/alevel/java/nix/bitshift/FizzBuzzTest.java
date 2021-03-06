package com.alevel.java.nix.bitshift;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;


class FizzBuzzTest {

    private FizzBuzz fizzBuzz;

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    @BeforeEach
    void setUp() {
        fizzBuzz = new FizzBuzz();

        list1 = Arrays.asList(1, 2, 3, 4, 5);
        list2 = Arrays.asList(1, 2, 3, 4, 0);
    }

    @Test
    void getFizzBizz() {
        fizzBuzz = mock(FizzBuzz.class);
        doCallRealMethod().when(fizzBuzz).getFizzBuzz(any(Integer.class));
    }

    @Test
    public void digitsInNumberTest() {
        assertEquals(list1, fizzBuzz.digitsInNumber(12345));
        assertEquals(list1.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(ArrayList::new), lst -> {
                    Collections.reverse(lst);
                    return lst.stream();
                })).collect(Collectors.toCollection(ArrayList::new))
                , fizzBuzz.digitsInNumber(54321));
        assertEquals(list2, fizzBuzz.digitsInNumber(12340));
    }

    @Test
    public void digitsInNumberReverseTest() {
        assertNotEquals(list1.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(ArrayList::new), lst -> {
                    Collections.reverse(lst);
                    return lst.stream();
                })).collect(Collectors.toCollection(ArrayList::new))
                , fizzBuzz.digitsInNumberReverse(54321));
        assertNotEquals(list1, fizzBuzz.digitsInNumberReverse(12345));
        assertNotEquals(list2, fizzBuzz.digitsInNumberReverse(43210));
    }
}