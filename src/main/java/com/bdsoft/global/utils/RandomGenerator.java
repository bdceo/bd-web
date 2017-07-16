package com.bdsoft.global.utils;

public class RandomGenerator {
	// private static Random rm1=new Random(2099999999);
	/*
	 * private static Random rm2=new Random(); public static String
	 * getPseudorandom(){ //StringBuffer randomstr=new StringBuffer(); //Random
	 * rm=new Random(rm1.nextInt(1000000000));
	 * 
	 * 
	 * //return ("9"+randomstr).substring(0,randomstr.length()); while(true){
	 * String randomstr=String.valueOf(rm2.nextInt(100000000));
	 * if(randomstr.length()==8) return randomstr.toString(); } }
	 */
	public static String getPseudorandom() { // 产生8位由数字组成的随机码
		while (true) {
			String randomstr = String.valueOf(Math
					.round(Math.random() * 100000000));
			if (randomstr.length() == 8)
				return randomstr.toString();
		}
	}

	public static String getPseudorandomByNumber(int length) { // 产生指定length位由数字组成的随机码
		String possible = "ABCDEFGHJKMNPQRSTUXYZ23456789";
		StringBuffer pseudorandom = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int randomint = new Double(Math.floor(Math.random()
					* possible.length())).intValue();
			pseudorandom.append(possible.substring(randomint, randomint + 1));
		}
		return pseudorandom.toString();
	}


	public static void main(String args[]) {
		/*
		 * Set ss=new HashSet(); long time1=System.currentTimeMillis(); for(int
		 * i=0;i<600000;i++){ ss.add(RandomGenerator.getPseudorandom());
		 * //System.out.println(RandomGenerator.getPseudorandom()); }
		 * System.out.println(ss.size()); long time2=System.currentTimeMillis();
		 * System.out.println("time:"+(time2-time1));
		 */

		/*
		 * time1=System.currentTimeMillis(); for(int i=0;i<500000;i++){
		 * ss.add(RandomGenerator.getPseudorandom());
		 * //System.out.println(RandomGenerator.getPseudorandom()); }
		 * System.out.println(ss.size()); time2=System.currentTimeMillis();
		 * System.out.println("time:"+(time2-time1));
		 */
		// Map m = new HashMap();
		// m.put("dd", "");
		// System.out.println("dd-" + m.get("dd"));
		for (int i = 0; i < 10; i++) {
			// System.out.println(getPseudorandomByletter(i));
		}

	}
}
