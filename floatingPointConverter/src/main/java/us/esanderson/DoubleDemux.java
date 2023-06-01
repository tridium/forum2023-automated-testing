/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */
package us.esanderson;

import java.util.regex.Pattern;

/**
 * See <a href="https://en.wikipedia.org/wiki/Double-precision_floating-point_format">Double-precision floating-point format - Wikipedia</a>
 * See <a href="https://floating-point-gui.de">The Floating-Point Guide - What Every Programmer Should Know About Floating-Point Arithmetic</a>
 * See <a href="https://gregstoll.com/~gregstoll/floattohex">Floating Point to Hex Converter (gregstoll.com)</a>
 * See <a href="https://calculla.com/floating_point_numbers">CALCULLA - Floating point numbers explorer</a>
 */
public class DoubleDemux
{
  private static final Pattern TRAILING_ZEROS = Pattern.compile("0{1,12}$");
  
  // Based on values from sun.misc.DoubleConsts
  private static final long SIGN_BIT_MASK     = 0x8000_0000_0000_0000L;
  private static final long EXP_BIT_MASK      = 0x7FF0_0000_0000_0000L;
  private static final long FRAC_BIT_MASK     = 0x000F_FFFF_FFFF_FFFFL;
  private static final long IMPLICIT_INT_BIT  = 0x0010_0000_0000_0000L;
  
  private double value;
  
  private long bits;
  
  private boolean isNegative;
  private int biasedExponent;
  private long fraction;
  
  private boolean isZero;
  private boolean isSubnormal;
  private boolean isInfinity;
  private boolean isNaN;

  public double getValue()
  {
    return value;
  }

  public void setValue(double value)
  {
    this.value = value;

    bits = Double.doubleToRawLongBits(value);

    isNegative = (bits & SIGN_BIT_MASK) != 0;
    biasedExponent = (int) ((bits & EXP_BIT_MASK) >> 52);
    fraction = bits & FRAC_BIT_MASK;

    isZero      = biasedExponent == 0     && fraction == 0;
    isSubnormal = biasedExponent == 0     && fraction != 0;
    isInfinity  = biasedExponent == 0x7FF && fraction == 0;
    isNaN       = biasedExponent == 0x7FF && fraction != 0;
  }

  public long getBits()
  {
    return bits;
  }

  public boolean getIsNegative()
  {
    return isNegative;
  }

  public int getBiasedExponent()
  {
    return biasedExponent;
  }
  
  public int getExponent()
  {
    if (isZero || isInfinity || isNaN)
    {
      return 0;
    }

    return isSubnormal ? -1022 : biasedExponent - 1023;
  }

  public long getFraction()
  {
    return fraction;
  }
  
  public double getSignificand()
  {
    if (isZero || isInfinity || isNaN)
    {
      return 0.0;
    }

     long significand = isSubnormal ?
      fraction :
      fraction | IMPLICIT_INT_BIT;
    return significand * Math.pow(2.0, -52.0);
  }

  public boolean getIsZero()
  {
    return isZero;
  }

  public boolean getIsSubnormal()
  {
    return isSubnormal;
  }

  public boolean getIsInfinity()
  {
    return isInfinity;
  }

  public boolean getIsNaN()
  {
    return isNaN;
  }

  /**
   * Heavily inspired by java.lang.Double#toHexString(double)
   */
  @Override
  public String toString()
  {
    if (isNaN)
    {
      return "NaN";
    }
    
    if (isInfinity)
    {
      return isNegative ? "-Infinity" : "Infinity";
    }
    
    StringBuilder builder = new StringBuilder(24);
    
    if (isNegative)
    {
      builder.append('-');
    }
    
    builder.append("0x");
    
    if (isZero)
    {
      builder.append("0.0p0");
      return builder.toString();
    }

    builder.append(isSubnormal ? "0." : "1.");
    
    // Get the lower 13 hex digits
    // OR in IMPLICIT_INT_BIT to ensure there are always 14 digits
    String significand = Long.toHexString(fraction | IMPLICIT_INT_BIT).substring(1, 14);
    
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

  public String toDebugString()
  {
    return
      "Value          " + value + '\n' +
      "Bits           " + String.format("0x%16X", bits) + '\n' +
      "toString       " + this + '\n' +
      "Sign           " + (isNegative ? "1 (negative)" : "0 (positive)") + '\n' +
      "Exponent field " + String.format("0x%3X", biasedExponent) + " = " + biasedExponent + '\n' +
      "Fraction field " + String.format("0x%13X", fraction) + '\n' +
      "Exponent       " + getExponent() + '\n' +
      "Significand    " + getSignificand() + '\n' +
      "IsZero?        " + isZero + '\n' +
      "IsSubnormal?   " + isSubnormal + '\n' +
      "IsInfinity?    " + isInfinity + '\n' +
      "IsNaN?         " + isNaN;
  }
}
