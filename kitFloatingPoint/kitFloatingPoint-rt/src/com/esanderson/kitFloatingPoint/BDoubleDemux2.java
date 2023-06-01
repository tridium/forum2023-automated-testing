/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */
package com.esanderson.kitFloatingPoint;

import java.util.regex.Pattern;

import javax.baja.nre.annotations.NiagaraProperty;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.sys.BComponent;
import javax.baja.sys.Context;
import javax.baja.sys.Flags;
import javax.baja.sys.Property;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;

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
@NiagaraProperty(
  name = "isNegative",
  type = "boolean",
  defaultValue = "false",
  flags = Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR
)
@NiagaraProperty(
  name = "biasedExponent",
  type = "int",
  defaultValue = "0",
  flags = Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR
)
@NiagaraProperty(
  name = "exponent",
  type = "int",
  defaultValue = "0",
  flags = Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR
)
@NiagaraProperty(
  name = "fraction",
  type = "long",
  defaultValue = "0L",
  flags = Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR
)
@NiagaraProperty(
  name = "significand",
  type = "double",
  defaultValue = "0.0",
  flags = Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR
)
@NiagaraProperty(
  name = "isZero",
  type = "boolean",
  defaultValue = "false",
  flags = Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR
)
@NiagaraProperty(
  name = "isSubnormal",
  type = "boolean",
  defaultValue = "false",
  flags = Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR
)
@NiagaraProperty(
  name = "isInfinity",
  type = "boolean",
  defaultValue = "false",
  flags = Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR
)
@NiagaraProperty(
  name = "isNaN",
  type = "boolean",
  defaultValue = "false",
  flags = Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR
)
public class BDoubleDemux2
  extends BComponent
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $com.esanderson.kitFloatingPoint.BDoubleDemux2(2619689332)1.0$ @*/
/* Generated Thu May 04 15:41:26 CDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

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

  //region Property "isNegative"

  /**
   * Slot for the {@code isNegative} property.
   * @see #getIsNegative
   * @see #setIsNegative
   */
  public static final Property isNegative = newProperty(Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR, false, null);

  /**
   * Get the {@code isNegative} property.
   * @see #isNegative
   */
  public boolean getIsNegative() { return getBoolean(isNegative); }

  /**
   * Set the {@code isNegative} property.
   * @see #isNegative
   */
  public void setIsNegative(boolean v) { setBoolean(isNegative, v, null); }

  //endregion Property "isNegative"

  //region Property "biasedExponent"

  /**
   * Slot for the {@code biasedExponent} property.
   * @see #getBiasedExponent
   * @see #setBiasedExponent
   */
  public static final Property biasedExponent = newProperty(Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR, 0, null);

  /**
   * Get the {@code biasedExponent} property.
   * @see #biasedExponent
   */
  public int getBiasedExponent() { return getInt(biasedExponent); }

  /**
   * Set the {@code biasedExponent} property.
   * @see #biasedExponent
   */
  public void setBiasedExponent(int v) { setInt(biasedExponent, v, null); }

  //endregion Property "biasedExponent"

  //region Property "exponent"

  /**
   * Slot for the {@code exponent} property.
   * @see #getExponent
   * @see #setExponent
   */
  public static final Property exponent = newProperty(Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR, 0, null);

  /**
   * Get the {@code exponent} property.
   * @see #exponent
   */
  public int getExponent() { return getInt(exponent); }

  /**
   * Set the {@code exponent} property.
   * @see #exponent
   */
  public void setExponent(int v) { setInt(exponent, v, null); }

  //endregion Property "exponent"

  //region Property "fraction"

  /**
   * Slot for the {@code fraction} property.
   * @see #getFraction
   * @see #setFraction
   */
  public static final Property fraction = newProperty(Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR, 0L, null);

  /**
   * Get the {@code fraction} property.
   * @see #fraction
   */
  public long getFraction() { return getLong(fraction); }

  /**
   * Set the {@code fraction} property.
   * @see #fraction
   */
  public void setFraction(long v) { setLong(fraction, v, null); }

  //endregion Property "fraction"

  //region Property "significand"

  /**
   * Slot for the {@code significand} property.
   * @see #getSignificand
   * @see #setSignificand
   */
  public static final Property significand = newProperty(Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR, 0.0, null);

  /**
   * Get the {@code significand} property.
   * @see #significand
   */
  public double getSignificand() { return getDouble(significand); }

  /**
   * Set the {@code significand} property.
   * @see #significand
   */
  public void setSignificand(double v) { setDouble(significand, v, null); }

  //endregion Property "significand"

  //region Property "isZero"

  /**
   * Slot for the {@code isZero} property.
   * @see #getIsZero
   * @see #setIsZero
   */
  public static final Property isZero = newProperty(Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR, false, null);

  /**
   * Get the {@code isZero} property.
   * @see #isZero
   */
  public boolean getIsZero() { return getBoolean(isZero); }

  /**
   * Set the {@code isZero} property.
   * @see #isZero
   */
  public void setIsZero(boolean v) { setBoolean(isZero, v, null); }

  //endregion Property "isZero"

  //region Property "isSubnormal"

  /**
   * Slot for the {@code isSubnormal} property.
   * @see #getIsSubnormal
   * @see #setIsSubnormal
   */
  public static final Property isSubnormal = newProperty(Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR, false, null);

  /**
   * Get the {@code isSubnormal} property.
   * @see #isSubnormal
   */
  public boolean getIsSubnormal() { return getBoolean(isSubnormal); }

  /**
   * Set the {@code isSubnormal} property.
   * @see #isSubnormal
   */
  public void setIsSubnormal(boolean v) { setBoolean(isSubnormal, v, null); }

  //endregion Property "isSubnormal"

  //region Property "isInfinity"

  /**
   * Slot for the {@code isInfinity} property.
   * @see #getIsInfinity
   * @see #setIsInfinity
   */
  public static final Property isInfinity = newProperty(Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR, false, null);

  /**
   * Get the {@code isInfinity} property.
   * @see #isInfinity
   */
  public boolean getIsInfinity() { return getBoolean(isInfinity); }

  /**
   * Set the {@code isInfinity} property.
   * @see #isInfinity
   */
  public void setIsInfinity(boolean v) { setBoolean(isInfinity, v, null); }

  //endregion Property "isInfinity"

  //region Property "isNaN"

  /**
   * Slot for the {@code isNaN} property.
   * @see #getIsNaN
   * @see #setIsNaN
   */
  public static final Property isNaN = newProperty(Flags.READONLY | Flags.TRANSIENT | Flags.SUMMARY | Flags.OPERATOR, false, null);

  /**
   * Get the {@code isNaN} property.
   * @see #isNaN
   */
  public boolean getIsNaN() { return getBoolean(isNaN); }

  /**
   * Set the {@code isNaN} property.
   * @see #isNaN
   */
  public void setIsNaN(boolean v) { setBoolean(isNaN, v, null); }

  //endregion Property "isNaN"

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BDoubleDemux2.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  @Override
  public void changed(Property property, Context context)
  {
    super.changed(property, context);

    if (isRunning() && property.equals(value))
    {
      updateOutputs();
    }
  }

  private void updateOutputs()
  {
    long bits = Double.doubleToRawLongBits(getValue());

    boolean isNegative = isNegative(bits);
    int biasedExponent = getBiasedExponent(bits);
    long fraction = getFraction(bits);

    boolean isZero = isZero(biasedExponent, fraction);
    boolean isSubnormal = isSubnormal(biasedExponent, fraction);
    boolean isInfinity = isInfinity(biasedExponent, fraction);
    boolean isNaN = isNaN(biasedExponent, fraction);

    int exponent;
    double significand;
    if (isZero || isInfinity || isNaN)
    {
      exponent = 0;
      significand = 0.0;
    }
    else
    {
      exponent = isSubnormal ? -1022 : biasedExponent - 1023;
      long significandLong = isSubnormal ?
        fraction :
        fraction | IMPLICIT_INT_BIT;
      significand = significandLong * Math.pow(2.0, -52.0);
    }

    setBits(bits);
    setIsNegative(isNegative);
    setBiasedExponent(biasedExponent);
    setExponent(exponent);
    setFraction(fraction);
    setSignificand(significand);
    setIsZero(isZero);
    setIsSubnormal(isSubnormal);
    setIsInfinity(isInfinity);
    setIsNaN(isNaN);
  }

  public static boolean isNegative(double value)
  {
    return (Double.doubleToLongBits(value) & SIGN_BIT_MASK) != 0;
  }

  public static boolean isZero(double value)
  {
    long bits = Double.doubleToLongBits(value);
    return isZero(getBiasedExponent(bits), getFraction(bits));
  }

  public static boolean isSubnormal(double value)
  {
    long bits = Double.doubleToLongBits(value);
    return isSubnormal(getBiasedExponent(bits), getFraction(bits));
  }

  public static boolean isInfinity(double value)
  {
    long bits = Double.doubleToLongBits(value);
    return isInfinity(getBiasedExponent(bits), getFraction(bits));
  }

  public static boolean isNaN(double value)
  {
    long bits = Double.doubleToLongBits(value);
    return isNaN(getBiasedExponent(bits), getFraction(bits));
  }

  private static boolean isNegative(long bits)
  {
    return (bits & SIGN_BIT_MASK) != 0;
  }

  private static int getBiasedExponent(long bits)
  {
    return (int) ((bits & EXP_BIT_MASK) >> 52);
  }

  private static long getFraction(long bits)
  {
    return bits & FRAC_BIT_MASK;
  }

  private static boolean isZero(int biasedExponent, long fraction)
  {
    return biasedExponent == 0 && fraction == 0;
  }

  private static boolean isSubnormal(int biasedExponent, long fraction)
  {
    return biasedExponent == 0 && fraction != 0;
  }

  private static boolean isInfinity(int biasedExponent, long fraction)
  {
    return biasedExponent == 0x7FF && fraction == 0;
  }

  private static boolean isNaN(int biasedExponent, long fraction)
  {
    return biasedExponent == 0x7FF && fraction != 0;
  }

  @Override
  public String toString(Context ignored)
  {
    if (getIsNaN())
    {
      return "NaN";
    }

    boolean isNegative = getIsNegative();
    if (getIsInfinity())
    {
      return isNegative ? "-Infinity" : "Infinity";
    }

    StringBuilder builder = new StringBuilder(24);

    if (isNegative)
    {
      builder.append('-');
    }

    builder.append("0x");

    if (getIsZero())
    {
      builder.append("0.0p0");
      return builder.toString();
    }

    builder.append(getIsSubnormal() ? "0." : "1.");

    // Get the lower 13 hex digits
    // OR in IMPLICIT_INT_BIT to ensure there are always 14 digits
    String significand = Long.toHexString(getFraction() | IMPLICIT_INT_BIT).substring(1, 14);

    if (significand.equals("0000000000000"))
    {
      // Replace all zeros with a single 0
      builder.append('0');
    }
    else
    {
      // Remove all trailing zeros
      builder.append(TRAILING_ZEROS.matcher(significand).replaceFirst(""));
    }

    builder.append('p');
    builder.append(getExponent());

    return builder.toString();
  }

  private static final Pattern TRAILING_ZEROS = Pattern.compile("0{1,12}$");

  // Based on values from sun.misc.DoubleConsts
  private static final long SIGN_BIT_MASK    = 0x8000_0000_0000_0000L;
  private static final long EXP_BIT_MASK     = 0x7FF0_0000_0000_0000L;
  private static final long FRAC_BIT_MASK    = 0x000F_FFFF_FFFF_FFFFL;
  private static final long IMPLICIT_INT_BIT = 0x0010_0000_0000_0000L;
}
