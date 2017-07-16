package com.bdsoft.test;

import java.util.ArrayList;
import java.util.List;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s0 = "kvill";

		String s1 = "kvill";
		System.out.println(s1.intern());
		String s2 = "kv" + "il";

		System.out.println(s0 == s1);

		System.out.println(s0 == s2);

		String strT = "i.lo.ve.you.!";
		String[] sts = strT.split("\\.");
		for (String st : sts) {
			System.out.print(st);
		}

		List<Integer> l = new ArrayList<Integer>();
		for (int i = 0; i <= 100; i++) {
			l.add(i);
		}
		System.out.println(l.remove(0));

	}
}
