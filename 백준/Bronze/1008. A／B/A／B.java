// https://www.acmicpc.net/problem/1008

import java.util.Scanner;

public class Main{
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt(), B = sc.nextInt();

    System.out.println((double)A / B);

    sc.close();
  }
}