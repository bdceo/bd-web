package com.bdsoft.wlqp;

import java.util.*;

public class FPUtil {

	public static String[] newGame() {
		ArrayList<Integer> cards = new ArrayList<Integer>();
		for (int i = 0; i <= 53; i++) {
			cards.add(i);
		}
		// 打乱
		Collections.shuffle(cards);

		String[] result = new String[] { "<#START#>", "<#START#>", "<#START#>" };

		for (int i = 0; i < 51; i++) {
			int k = i % 3;
			result[k] = result[k] + cards.get(i) + ",";
		}
		for (int i = 0; i < 3; i++) {
			result[i] = result[i].substring(0, result[i].length() - 1);
		}
		return result;
	}

	public static void main(String[] args) {
		String[] result = newGame();
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}