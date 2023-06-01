/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */
package test.com.esanderson.kitFloatingPoint;

import static org.testng.Assert.*;

import com.esanderson.kitFloatingPoint.BDoubleDemux1;
import org.testng.annotations.Test;

/**
 * @author Eric Anderson on 01 Apr 2023
 * @since 1.0
 */
@Test
public class DoubleDemuxTest1a
{
  public void setValue_updatesBitsProperty()
  {
    // Given
    BDoubleDemux1 demux = new BDoubleDemux1();
    assertEquals(demux.getValue(), 0.0, "value property at start");
    assertEquals(demux.getBits(), 0L, "bits property at start");

    // When
    demux.setValue(1.0);

    // Then
    assertEquals(demux.getBits(), 0x3FF0_0000_0000_0000L, "bits property after updating value property");
  }
}
