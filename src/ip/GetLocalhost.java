package ip;

import java.io.*;
import java.util.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
 
public class GetLocalhost {
  public static void main(String [] args) {
    try {
      System.out.println(InetAddress.getLocalHost());
    } catch(UnknownHostException var1) {
      System.out.println("Exception : " + var1);
    }
  }
}