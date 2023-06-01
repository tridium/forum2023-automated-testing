/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */
package test.com.esanderson.kitFloatingPoint;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.esanderson.kitFloatingPoint.BDoubleDemux1;
import org.mockito.Mockito;
import org.testng.annotations.Test;

/**
 * @author Eric Anderson on 01 Apr 2023
 * @since 1.0
 */
@NiagaraType
@Test
public class BDoubleDemuxTest2
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.esanderson.kitFloatingPoint.BDoubleDemuxTest2(2979906276)1.0$ @*/
/* Generated Mon May 08 15:25:01 BST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDoubleDemuxTest2.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void setValue_updatesBitsPropertyWhenRunning()
  {
    // Given
    BDoubleDemux1 demux = Mockito.spy(BDoubleDemux1.class);
    Mockito.doReturn(true).when(demux).isRunning();
    assertTrue(demux.isRunning(), "demux isRunning at start");
    assertEquals(demux.getValue(), 0.0, "value property at start");
    assertEquals(demux.getBits(), 0L, "bits property at start");

    // When
    demux.setValue(1.0);

    // Then
    assertEquals(demux.getBits(), 0x3FF0_0000_0000_0000L, "bits property after updating value property");
  }

  public void setValue_doesNotUpdateBitsPropertyWhenNotRunning()
  {
    // Given
    BDoubleDemux1 demux = new BDoubleDemux1();
    assertFalse(demux.isRunning(), "demux isRunning at start");
    assertEquals(demux.getValue(), 0.0, "value property at start");
    assertEquals(demux.getBits(), 0L, "bits property at start");

    // When
    demux.setValue(1.0);

    // Then
    assertEquals(demux.getBits(), 0L, "value: 1.0");
  }
}
