/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */
package com.esanderson.kitFloatingPoint;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.sys.Property;

/**
 * See <a href="https://en.wikipedia.org/wiki/Double-precision_floating-point_format">Double-precision floating-point format - Wikipedia</a>
 * See <a href="https://floating-point-gui.de">The Floating-Point Guide - What Every Programmer Should Know About Floating-Point Arithmetic</a>
 * See <a href="https://gregstoll.com/~gregstoll/floattohex">Floating Point to Hex Converter (gregstoll.com)</a>
 * See <a href="https://calculla.com/floating_point_numbers">CALCULLA - Floating point numbers explorer</a>
 * 
 * @author Eric Anderson on 01 Apr 2023
 * @since 1.0
 */
@NiagaraType
@NiagaraProperty(
  name = "value",
  type = "double",
  defaultValue = "0.0",
  flags = Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR
)
@NiagaraProperty(
  name = "bits",
  type = "long",
  defaultValue = "0L",
  flags = Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR
)
public class BDoubleDemux1
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.esanderson.kitFloatingPoint.BDoubleDemux1(954813887)1.0$ @*/
/* Generated Wed May 31 15:17:18 CDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Property "value"

  /**
   * Slot for the {@code value} property.
   * @see #getValue
   * @see #setValue
   */
  public static final Property value = newProperty(Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR, 0.0, null);

  /**
   * Get the {@code value} property.
   * @see #value
   */
  public double getValue() { return getDouble(value); }

  /**
   * Set the {@code value} property.
   * @see #value
   */
  public void setValue(double v) { setDouble(value, v, null); }

  //endregion Property "value"

  //region Property "bits"

  /**
   * Slot for the {@code bits} property.
   * @see #getBits
   * @see #setBits
   */
  public static final Property bits = newProperty(Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR, 0L, null);

  /**
   * Get the {@code bits} property.
   * @see #bits
   */
  public long getBits() { return getLong(bits); }

  /**
   * Set the {@code bits} property.
   * @see #bits
   */
  public void setBits(long v) { setLong(bits, v, null); }

  //endregion Property "bits"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDoubleDemux1.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public void changed(Property property, Context context)
  {
    super.changed(property, context);

    if (!isRunning())
    {
      return;
    }

    setBits(Double.doubleToRawLongBits(getValue()));
  }
}
