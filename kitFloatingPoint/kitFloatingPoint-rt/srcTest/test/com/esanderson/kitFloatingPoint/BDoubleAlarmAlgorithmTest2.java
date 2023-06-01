/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */
package test.com.esanderson.kitFloatingPoint;

import static org.testng.Assert.*;

import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatusNumeric;
import javax.baja.status.BStatusValue;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.esanderson.kitFloatingPoint.BDoubleAlarmAlgorithm;
import junit.extensions.PA;
import org.testng.annotations.Test;

/**
 * @author Eric Anderson on 28 Apr 2023
 * @since 1.0
 */
@NiagaraType
@Test
public class BDoubleAlarmAlgorithmTest2
  extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.esanderson.kitFloatingPoint.BDoubleAlarmAlgorithmTest2(2979906276)1.0$ @*/
/* Generated Sun Apr 30 00:08:26 CDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDoubleAlarmAlgorithmTest2.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void isNormal_returnFalseWhenOutIsNaN()
    throws Throwable
  {
    // Given
    BDoubleAlarmAlgorithm algorithm = new BDoubleAlarmAlgorithm();
    BStatusValue out = new BStatusNumeric(Double.NaN);

    // When
    boolean actual = (boolean) PA.invokeMethod(algorithm, "isNormal(javax.baja.status.BStatusValue)", out);

    // Then
    assertFalse(actual);
  }
}
