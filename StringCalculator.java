

public class StringCalculator {
	static int count = 0;

	public static int GetCalledCount() {
		return count;
	}

	public static int Add(String s) {
		count = count + 1;
		int i = 0, sum1 = 0;
		boolean isNegative = false;
		String str = "0";
		String errorMessage = "";

		while (i < s.length()) {
			str = "0";
			while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '-')) {
				if (str == "0") {
					str = "" + s.charAt(i);
				} else {
					str = str + s.charAt(i);
				}
				i = i + 1;
			}
			int n = Integer.parseInt(String.valueOf(str));
			if (n < 0) {
				isNegative = true;
				errorMessage = errorMessage + n + " , ";
			} else if (n < 1000) {
				sum1 = sum1 + n;
			}
			i = i + 1;
		}
		if (isNegative) {
			throw new IllegalArgumentException("Negative numbers are not allowed. " + errorMessage);
		}
		return sum1;
	}

	public static void main(String args[]) {
		int count = GetCalledCount();
		System.out.println("Sum is " + Add(""));
		System.out.println("Sum is " + Add("1"));
		System.out.println("Sum is " + Add("1,2"));
		System.out.println("Sum is " + Add("1\n2,3"));
		System.out.println("Sum is " + Add("//;\n1;2"));
		// System.out.println("Sum is " + Add("-1,-2,-3,9"));
		System.out.println("Sum is " + Add("1,1001,1,2000"));
		System.out.println("Sum is " + Add("//[***]\n1***2***3"));
		System.out.println("Sum is " + Add("//[*][%]\n1*2%3"));
		System.out.println("Sum is " + Add("//[**][%%]\n1**2%%3"));
		System.out.println("count is " + Add("count is="+GetCalledCount()));
	}
}