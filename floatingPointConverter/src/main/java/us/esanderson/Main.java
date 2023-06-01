/*
 * Copyright 2023 Tridium, Inc. All Rights Reserved.
 */
package us.esanderson;

public final class Main
{
  public static void main(String[] args)
  {
    double value = args.length > 0 ? Double.parseDouble(args[0]) : 0.0;
    DoubleDemux converter = new DoubleDemux();
    converter.setValue(value);
    System.out.println(converter.toDebugString());
  }
}
