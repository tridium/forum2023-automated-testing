/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */
package com.esanderson.kitFloatingPoint;

import javax.baja.alarm.ext.offnormal.BTwoStateAlgorithm;
import javax.baja.control.BNumericPoint;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.status.BStatusNumeric;
import javax.baja.status.BStatusValue;
import javax.baja.sys.BComponent;
import javax.baja.sys.Context;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

/**
 * @author Eric Anderson on 27 Apr 2023
 * @since 1.0
 */
@NiagaraType
public class BDoubleAlarmAlgorithm
  extends BTwoStateAlgorithm
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.esanderson.kitFloatingPoint.BDoubleAlarmAlgorithm(2979906276)1.0$ @*/
/* Generated Wed May 10 21:55:50 CEST 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDoubleAlarmAlgorithm.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public boolean isGrandparentLegal(BComponent grandparent)
  {
    return grandparent instanceof BNumericPoint;
  }

  @Override
  public void changed(Property p, Context cx)
  {
    super.changed(p, cx);

    if (!isRunning())
    {
      return;
    }

    executePoint();
  }

  @Override
  protected boolean isNormal(BStatusValue out)
  {
    double value = ((BStatusNumeric)out).getValue();
    return !Double.isNaN(value);
  }
}
