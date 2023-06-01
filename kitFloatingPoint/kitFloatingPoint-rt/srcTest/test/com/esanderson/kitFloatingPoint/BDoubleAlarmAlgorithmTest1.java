/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */
package test.com.esanderson.kitFloatingPoint;

import static org.testng.Assert.*;

import javax.baja.alarm.ext.BAlarmSourceExt;
import javax.baja.alarm.ext.BAlarmState;
import javax.baja.control.BNumericWritable;
import javax.baja.control.util.BNumericOverride;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BDouble;
import javax.baja.sys.BStation;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNgStation;
import javax.baja.test.TestHelper;
import javax.baja.util.BFolder;

import com.esanderson.kitFloatingPoint.BDoubleAlarmAlgorithm;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * @author Eric Anderson on 28 Apr 2023
 * @since 1.0
 */
@NiagaraType
@Test
public class BDoubleAlarmAlgorithmTest1
  extends BTestNgStation
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.esanderson.kitFloatingPoint.BDoubleAlarmAlgorithmTest1(2979906276)1.0$ @*/
/* Generated Fri Apr 28 15:00:30 CDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDoubleAlarmAlgorithmTest1.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  protected void configureTestStation(BStation station, String stationName, int webPort, int foxPort)
    throws Exception
  {
    super.configureTestStation(station, stationName, webPort, foxPort);

    station.add(null, folder);
  }

  @AfterMethod
  public void afterMethod()
  {
    folder.removeAll();
  }

  public void raisesOffnormalWhenOutIsNaN()
  {
    // Given
    BDoubleAlarmAlgorithm algorithm = new BDoubleAlarmAlgorithm();

    BAlarmSourceExt doubleAlarmExt = new BAlarmSourceExt();
    doubleAlarmExt.setOffnormalAlgorithm(algorithm);

    BNumericWritable point = new BNumericWritable();
    point.add(null, doubleAlarmExt);
    point.set(BDouble.make(1.0));

    folder.add(null, point);

    TestHelper.assertWillBeTrue(
      () -> Double.compare(point.getNumeric(), 1.0) == 0,
      () -> "At start of test, out is " + point.getNumeric() + " instead of 1.0");
    assertEquals(doubleAlarmExt.getAlarmState(), BAlarmState.normal, "alarmState at start of test");

    // When
    point.override(new BNumericOverride(Double.NaN));
    TestHelper.assertWillBeTrue(
      () -> Double.compare(point.getNumeric(), Double.NaN) == 0,
      () -> "After override, out is " + point.getNumeric() + " instead of " + Double.NaN);

    // Then
    assertEquals(doubleAlarmExt.getAlarmState(), BAlarmState.offnormal, "alarmState at end of test");
  }

  private final BFolder folder = new BFolder();
}
