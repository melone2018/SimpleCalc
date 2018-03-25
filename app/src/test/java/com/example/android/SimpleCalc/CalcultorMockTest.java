package com.example.android.SimpleCalc;

/**
 * Created by Rui Liu on 3/25/2018.
 */

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import android.content.Context;
import android.content.SharedPreferences;

import junit.framework.Assert;


@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class CalcultorMockTest {

    @Mock Calculator mCalculator;

    @Test
    public void addTwoNumbersTest(){
        //Calculator mCalculator = Mockito.mock(Calculator.class);
        Mockito.doReturn(12.0).when(mCalculator).add(3, 9);
        Assert.assertEquals(12.0, mCalculator.add(3, 9));
        verify(mCalculator).add(3, 9);
    }

    @Test
    public void subTwoNumbersTest(){
        when(mCalculator.sub(90, 89.3)).thenReturn(0.7);
        assertThat(mCalculator.sub(90, 89.3), is(equalTo(0.7)));
        verify(mCalculator).sub(90, 89.3);
    }

    @Test
    public void mulTwoNumbersTest(){
        when(mCalculator.mul(8.3, 4)).thenReturn(33.2);
        assertThat(mCalculator.mul(8.3, 4), is(equalTo(33.2)));
        verify(mCalculator).mul(8.3, 4);
    }

    @Test
    public void divTwoNumbersTest(){
        when(mCalculator.div(8.4, 2.1)).thenReturn(4.0);
        assertThat(mCalculator.div(8.4, 2.1), is(equalTo(4.0)));
        verify(mCalculator).div(8.4, 2.1);
    }

    @Test(expected = ArithmeticException.class)
    public void divByZeroTest(){
        when(mCalculator.div(4.9, 0)).thenThrow(new ArithmeticException());
        mCalculator.div(4.9, 0);
    }
}
