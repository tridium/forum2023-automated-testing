/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */
package us.esanderson;

public class DoubleDemuxTestCase
{
  public static final DoubleDemuxTestCase[] testCases = {
    // https://en.wikipedia.org/wiki/Double-precision_floating-point_format
    new DoubleDemuxTestCase(
      1.0,                    /* value */
      0x3FF0_0000_0000_0000L, /* bits */
      false,                  /* isNegative */
      0x3FF,                  /* biasedExponent */
      0x0_0000_0000_0000L,    /* fraction */
      0,                      /* exponent */
      1.0,                    /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      1.0000000000000002,     /* value */
      0x3FF0_0000_0000_0001L, /* bits */
      false,                  /* isNegative */
      0x3FF,                  /* biasedExponent */
      0x0_0000_0000_0001L,    /* fraction */
      0,                      /* exponent */
      1.0 + Math.pow(2, -52), /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      1.0000000000000004,     /* value */
      0x3FF0_0000_0000_0002L, /* bits */
      false,                  /* isNegative */
      0x3FF,                  /* biasedExponent */
      0x0_0000_0000_0002L,    /* fraction */
      0,                      /* exponent */
      1.0 + Math.pow(2, -51), /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      2.0,                    /* value */
      0x4000_0000_0000_0000L, /* bits */
      false,                  /* isNegative */
      0x400,                  /* biasedExponent */
      0x0_0000_0000_0000L,    /* fraction */
      1,                      /* exponent */
      1.0,                    /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      -2.0,                   /* value */
      0xC000_0000_0000_0000L, /* bits */
      true,                   /* isNegative */
      0x400,                  /* biasedExponent */
      0x0_0000_0000_0000L,    /* fraction */
      1,                      /* exponent */
      1.0,                    /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      3.0,                    /* value */
      0x4008_0000_0000_0000L, /* bits */
      false,                  /* isNegative */
      0x400,                  /* biasedExponent */
      0x8_0000_0000_0000L,    /* fraction */
      1,                      /* exponent */
      1.5,                    /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      4.0,                    /* value */
      0x4010_0000_0000_0000L, /* bits */
      false,                  /* isNegative */
      0x401,                  /* biasedExponent */
      0x0_0000_0000_0000L,    /* fraction */
      2,                      /* exponent */
      1.0,                    /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      5.0,                    /* value */
      0x4014_0000_0000_0000L, /* bits */
      false,                  /* isNegative */
      0x401,                  /* biasedExponent */
      0x4_0000_0000_0000L,    /* fraction */
      2,                      /* exponent */
      1.25,                   /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      6.0,                    /* value */
      0x4018_0000_0000_0000L, /* bits */
      false,                  /* isNegative */
      0x401,                  /* biasedExponent */
      0x8_0000_0000_0000L,    /* fraction */
      2,                      /* exponent */
      1.5,                    /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      23.0,                   /* value */
      0x4037_0000_0000_0000L, /* bits */
      false,                  /* isNegative */
      0x403,                  /* biasedExponent */
      0x7_0000_0000_0000L,    /* fraction */
      4,                      /* exponent */
      1.4375,                 /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      0.01171875,             /* value */
      0x3F88_0000_0000_0000L, /* bits */
      false,                  /* isNegative */
      0x3F8,                  /* biasedExponent */
      0x8_0000_0000_0000L,    /* fraction */
      -7,                     /* exponent */
      1.5,                    /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      Double.MIN_VALUE,       /* value */
      0x0000_0000_0000_0001L, /* bits */
      false,                  /* isNegative */
      0x000,                  /* biasedExponent */
      0x0_0000_0000_0001L,    /* fraction */
      -1022,                  /* exponent */
      Math.pow(2, -52),       /* significand */
      false,                  /* isZero */
      true,                   /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      Double.longBitsToDouble(0x000F_FFFF_FFFF_FFFFL), /* value */
      0x000F_FFFF_FFFF_FFFFL, /* bits */
      false,                  /* isNegative */
      0x000,                  /* biasedExponent */
      0xF_FFFF_FFFF_FFFFL,    /* fraction */
      -1022,                  /* exponent */
      1.0 - Math.pow(2, -52), /* significand */
      false,                  /* isZero */
      true,                   /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      Double.MIN_NORMAL,      /* value */
      0x0010_0000_0000_0000L, /* bits */
      false,                  /* isNegative */
      0x001,                  /* biasedExponent */
      0x0_0000_0000_0000L,    /* fraction */
      -1022,                  /* exponent */
      1.0,                    /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      Double.MAX_VALUE,       /* value */
      0x7FEF_FFFF_FFFF_FFFFL, /* bits */
      false,                  /* isNegative */
      0x7FE,                  /* biasedExponent */
      0xF_FFFF_FFFF_FFFFL,    /* fraction */
      1023,                   /* exponent */
      1.0 + (1.0 - Math.pow(2, -52)), /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      0.0,                    /* value */
      0x0000_0000_0000_0000L, /* bits */
      false,                  /* isNegative */
      0x000,                  /* biasedExponent */
      0x0_0000_0000_0000L,    /* fraction */
      0,                      /* exponent */
      0.0,                    /* significand */
      true,                   /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      -0.0,                   /* value */
      0x8000_0000_0000_0000L, /* bits */
      true,                   /* isNegative */
      0x000,                  /* biasedExponent */
      0x0_0000_0000_0000L,    /* fraction */
      0,                      /* exponent */
      0.0,                    /* significand */
      true,                   /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      Double.POSITIVE_INFINITY, /* value */
      0x7FF0_0000_0000_0000L, /* bits */
      false,                  /* isNegative */
      0x7FF,                  /* biasedExponent */
      0x0_0000_0000_0000L,    /* fraction */
      0,                      /* exponent */
      0.0,                    /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      true,                   /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      Double.NEGATIVE_INFINITY, /* value */
      0xFFF0_0000_0000_0000L, /* bits */
      true,                   /* isNegative */
      0x7FF,                  /* biasedExponent */
      0x0_0000_0000_0000L,    /* fraction */
      0,                      /* exponent */
      0.0,                    /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      true,                   /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      Double.NaN,             /* value */
      0x7FF8_0000_0000_0000L, /* bits */
      false,                  /* isNegative */
      0x7FF,                  /* biasedExponent */
      0x8_0000_0000_0000L,    /* fraction */
      0,                      /* exponent */
      0.0,                    /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      true                    /* isNaN */
    ),
    new DoubleDemuxTestCase(
      1.0 / 3.0,              /* value */
      0x3FD5_5555_5555_5555L, /* bits */
      false,                  /* isNegative */
      0x3FD,                  /* biasedExponent */
      0x5_5555_5555_5555L,    /* fraction */
      -2,                     /* exponent */
      0x15_5555_5555_5555L * Math.pow(2, -52), /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
    new DoubleDemuxTestCase(
      Math.PI,                /* value */
      0x4009_21FB_5444_2D18L, /* bits */
      false,                  /* isNegative */
      0x400,                  /* biasedExponent */
      0x9_21FB_5444_2D18L,    /* fraction */
      1,                      /* exponent */
      0x19_21FB_5444_2D18L * Math.pow(2, -52), /* significand */
      false,                  /* isZero */
      false,                  /* isSubnormal */
      false,                  /* isInfinity */
      false                   /* isNaN */
    ),
  };

  public final double value;

  public final long bits;
  public final boolean isNegative;
  public final int biasedExponent;
  public final long fraction;

  public final int exponent;
  public final double significand;

  public final boolean isZero;
  public final boolean isSubnormal;
  public final boolean isInfinity;
  public final boolean isNaN;

  public DoubleDemuxTestCase(
    double value,
    long bits,
    boolean isNegative,
    int biasedExponent,
    long fraction,
    int exponent,
    double significand,
    boolean isZero,
    boolean isSubnormal,
    boolean isInfinity,
    boolean isNaN)
  {
    this.value = value;
    this.bits = bits;
    this.isNegative = isNegative;
    this.biasedExponent = biasedExponent;
    this.fraction = fraction;
    this.exponent = exponent;
    this.significand = significand;
    this.isZero = isZero;
    this.isSubnormal = isSubnormal;
    this.isInfinity = isInfinity;
    this.isNaN = isNaN;
  }

  @Override
  public String toString()
  {
    return "DoubleDemuxTestCase{" +
      "value=" + value +
      ", bits=" + bits +
      ", isNegative=" + isNegative +
      ", biasedExponent=" + biasedExponent +
      ", fraction=" + fraction +
      ", exponent=" + exponent +
      ", significand=" + significand +
      ", isZero=" + isZero +
      ", isSubnormal=" + isSubnormal +
      ", isInfinity=" + isInfinity +
      ", isNaN=" + isNaN +
      '}';
  }
}
