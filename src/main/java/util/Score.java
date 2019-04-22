package util;

public class Score {

	public static double getScore(double area, String houseType, double price, String payment, String rentWay,
			double distance) {
		double houseScore;
		double payScore;
		if (payment.length() > 3) {
			payScore = getPayment(payment);
		} else {
			payScore = getPaymentOther(payment);
		}

		double sum;

		if (rentWay.equals("合租")) {
			houseScore = getHouseHe(houseType);
			sum = ((area / price ) * 150  + houseScore * 2 + ((1 / payScore) * 2.5)) / 2+1/distance*30;
			if (houseScore == -1 || payScore == -1)
				sum = 0;
		} else { // 整租
			houseScore = getHouseZheng(houseType);
			sum = (area / price) *10  + houseScore * 0.5 + ((1 / payScore) * 2)+1/distance*30;
			if (houseScore == -1 || payScore == -1)
				sum = 0;
		}

		if(sum>10) {
			sum=10.0;
		}
		
		return Double.valueOf(String.format("%.1f", sum).toString());
	}

	private static double getPaymentOther(String payment) {
		if (payment.equals("月付价")) {
			return 1.0;
		} else if (payment.equals("季付价")) {
			return 3.0;
		} else {
			return 6.0;
		}
	}

	// 合租
	private static double getHouseHe(String houseType) {
		if (houseType.length() == 6) {
			char[] cs = houseType.toCharArray();
			int[] house = new int[3];
			house[0] = cs[0] - '0';
			if (house[0] == 3) {
				return 1.0;
			} else if (house[0] == 4) {
				return 0.8;
			} else {
				return 0.5;
			}
		} else {
			return -1.0;
		}
	}

	// 整租
	private static double getHouseZheng(String houseType) {
		if (houseType.length() == 6) {
			char[] cs = houseType.toCharArray();
			int[] house = new int[3];
			house[0] = cs[0] - '0';
			house[1] = cs[2] - '0';
			house[2] = cs[4] - '0';
			int houseTypeScore = house[0] + house[1] + house[2];
			return houseTypeScore;
		} else {
			return -1.0;
		}

	}

	private static double getPayment(String payment) {
		if (payment.length() == 4) {
			char[] cs = payment.toCharArray();
			int[] pay = new int[2];
			pay[0] = cs[1] - '0';
			pay[1] = cs[3] - '0';
			double payScore = 0;
			for (int i = 0; i < pay.length; i++) {
				payScore += pay[i];
			}
			if (pay[0] == '1' && pay[1] == '1')
				return 1.0;
			if (payment.equals("面议"))
				return -1.0;
			return payScore;
		} else {
			return -1.0;
		}
	}
}
