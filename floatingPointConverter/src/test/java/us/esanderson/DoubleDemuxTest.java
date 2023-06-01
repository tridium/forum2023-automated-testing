/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */
package us.esanderson;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author Eric Anderson on 01 Apr 2023
 * @since 1.0
 */
@Test
public class DoubleDemuxTest
{
  @DataProvider
  private static Object[] doubleDemuxTestCases()
  {
    return DoubleDemuxTestCase.testCases;
  }

  @Test(dataProvider = "doubleDemuxTestCases")
  public void setValue_updatesBits(DoubleDemuxTestCase testCase)
  {
    // Given
    DoubleDemux demux = new DoubleDemux();

    // When
    demux.setValue(testCase.value);

    // Then
    assertEquals(demux.getBits(), testCase.bits, "value: " + testCase.value);
  }

  @Test(dataProvider = "doubleDemuxTestCases")
  public void setValue_updatesIsNegative(DoubleDemuxTestCase testCase)
  {
    // Given
    DoubleDemux demux = new DoubleDemux();

    // When
    demux.setValue(testCase.value);

    // Then
    assertEquals(demux.getIsNegative(), testCase.isNegative, "value: " + testCase.value);
  }

  @Test(dataProvider = "doubleDemuxTestCases")
  public void setValue_updatesBiasedExponent(DoubleDemuxTestCase testCase)
  {
    // Given
    DoubleDemux demux = new DoubleDemux();

    // When
    demux.setValue(testCase.value);

    // Then
    assertEquals(demux.getBiasedExponent(), testCase.biasedExponent, "value: " + testCase.value);
  }

  @Test(dataProvider = "doubleDemuxTestCases")
  public void setValue_updatesFraction(DoubleDemuxTestCase testCase)
  {
    // Given
    DoubleDemux demux = new DoubleDemux();

    // When
    demux.setValue(testCase.value);

    // Then
    assertEquals(demux.getFraction(), testCase.fraction, "value: " + testCase.value);
  }

  @Test(dataProvider = "doubleDemuxTestCases")
  public void setValue_updatesExponent(DoubleDemuxTestCase testCase)
  {
    // Given
    DoubleDemux demux = new DoubleDemux();

    // When
    demux.setValue(testCase.value);

    // Then
    assertEquals(demux.getExponent(), testCase.exponent, "value: " + testCase.value);
  }

  @Test(dataProvider = "doubleDemuxTestCases")
  public void setValue_updatesSignificand(DoubleDemuxTestCase testCase)
  {
    // Given
    DoubleDemux demux = new DoubleDemux();

    // When
    demux.setValue(testCase.value);

    // Then
    assertEquals(demux.getSignificand(), testCase.significand, "value: " + testCase.value);
  }

  @Test(dataProvider = "doubleDemuxTestCases")
  public void setValue_updatesIsZero(DoubleDemuxTestCase testCase)
  {
    // Given
    DoubleDemux demux = new DoubleDemux();

    // When
    demux.setValue(testCase.value);

    // Then
    assertEquals(demux.getIsZero(), testCase.isZero, "value: " + testCase.value);
  }

  @Test(dataProvider = "doubleDemuxTestCases")
  public void setValue_updatesIsSubnormal(DoubleDemuxTestCase testCase)
  {
    // Given
    DoubleDemux demux = new DoubleDemux();

    // When
    demux.setValue(testCase.value);

    // Then
    assertEquals(demux.getIsSubnormal(), testCase.isSubnormal, "value: " + testCase.value);
  }

  @Test(dataProvider = "doubleDemuxTestCases")
  public void setValue_updatesIsInfinity(DoubleDemuxTestCase testCase)
  {
    // Given
    DoubleDemux demux = new DoubleDemux();

    // When
    demux.setValue(testCase.value);

    // Then
    assertEquals(demux.getIsInfinity(), testCase.isInfinity, "value: " + testCase.value);
  }

  @Test(dataProvider = "doubleDemuxTestCases")
  public void setValue_updatesIsNaN(DoubleDemuxTestCase testCase)
  {
    // Given
    DoubleDemux demux = new DoubleDemux();

    // When
    demux.setValue(testCase.value);

    // Then
    assertEquals(demux.getIsNaN(), testCase.isNaN, "value: " + testCase.value);
  }
}
