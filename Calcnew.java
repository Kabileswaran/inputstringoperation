package com.arun.demo.controller;

import java.util.HashMap;
import java.util.Map;

public class Calcnew {
	public static void main(String[] args) {
		String str = "12+123*1235+12345";
		Calcnew calc = new Calcnew();
		System.out.println(calc.DataFormator(str));
	}

	public int value(Map<String, String> val, Map<String, String> oper) {
		int out = 0;
		for (int i = 0; i < oper.size(); i++) {
			if (oper.get("operater_" + i).contains("add")) {
				Calcnew calc = new Calcnew();
				String str1 = Integer.toString(calc.sum(Integer.parseInt(val.get("value_" + i)),
						Integer.parseInt(val.get("value_" + (i + 1)))));
				val.put("value_" + (i + 1), str1);
			}
			if (oper.get("operater_" + i).contains("sub")) {
				Calcnew calc = new Calcnew();
				calc.sub(Integer.parseInt(val.get("value_" + i)), Integer.parseInt(val.get("value_" + (i + 1))));
				String str1 = Integer.toString(calc.sub(Integer.parseInt(val.get("value_" + i)),
						Integer.parseInt(val.get("value_" + (i + 1)))));
				val.put("value_" + (i + 1), str1);
			}
			if (oper.get("operater_" + i).contains("mul")) {
				Calcnew calc = new Calcnew();
				calc.mul(Integer.parseInt(val.get("value_" + i)), Integer.parseInt(val.get("value_" + (i + 1))));
				String str1 = Integer.toString(calc.mul(Integer.parseInt(val.get("value_" + i)),
						Integer.parseInt(val.get("value_" + (i + 1)))));
				val.put("value_" + (i + 1), str1);
			}
			if (oper.get("operater_" + i).contains("dev")) {
				Calcnew calc = new Calcnew();
				calc.dev(Integer.parseInt(val.get("value_" + i)), Integer.parseInt(val.get("value_" + (i + 1))));
				String str1 = Integer.toString(calc.dev(Integer.parseInt(val.get("value_" + i)),
						Integer.parseInt(val.get("value_" + (i + 1)))));
				val.put("value_" + (i + 1), str1);
			}
			out = Integer.parseInt(val.get("value_" + (i + 1)));
		}
		return out;
	}

	public int sum(int a, int b) {
		int c = a + b;
		return c;
	}

	public int sub(int a, int b) {
		int c = a - b;
		return c;
	}

	public int mul(int a, int b) {
		int c = a * b;
		return c;
	}

	public int dev(int a, int b) {
		int c = a / b;
		return c;
	}

	public int DataFormator(String W) {
		StringBuilder strun = new StringBuilder();
		int j = 0;
		int k = 0;
		int ab = 0;
		String str = null;
		String stringinput = new String(W);
		Map<String, String> oper = new HashMap<String, String>();
		Map<String, String> val = new HashMap<String, String>();
		for (int i = 0; i < stringinput.length(); i++) {
			str = String.valueOf(stringinput.charAt(i));
			System.out.println(str);
			if ((str.equals("+")) || (str.equals("-")) || (str.equals("/")) || (str.equals("*"))) {
				switch (str) {
				case "+":
					oper.put("operater_" + String.valueOf(j), "add");
					break;
				case "-":
					oper.put("operater_" + String.valueOf(j), "sub");
					break;
				case "*":
					oper.put("operater_" + String.valueOf(j), "mul");
					break;
				case "/":
					oper.put("operater_" + String.valueOf(j), "dev");
					break;
				default:
					System.out.println("error");
				}
				j++;
			} else if ((str.equals("1")) || (str.equals("2")) || (str.equals("3")) || (str.equals("4"))
					|| (str.equals("5")) || (str.equals("6")) || (str.equals("7")) || (str.equals("8"))
					|| (str.equals("9")) || (str.equals("0"))) {
				// System.out.println(str);

				if (i != ab) {
					// System.out.println(strun.toString());
					val.put("value_" + String.valueOf(k), strun.toString());
					strun = new StringBuilder();
					if (strun.isEmpty()) {
						strun.append(str);
					}
					k++;
					ab++;
				} else {
					strun.append(str);
				}
				ab++;
			} else {
				System.out.println("invalid format");
			}
		}
		System.out.println(strun.toString());
		val.put("value_" + String.valueOf(k), strun.toString());
		System.out.println(val);
		System.out.println(oper);
		Calcnew calc = new Calcnew();
		return calc.value(val, oper);

	}

}
