package util;

public class ScoreUtil {

	// 合租评分
	public static double getScoreHe(double area, String houseType, double price, String payment, double distance,
			double maxArea, double minPrice, double minDistance) {

		double areaScore = area / maxArea;

		double houseTypeScore = getHouseHe(houseType);

		double priceScore = minPrice / price;

		double paymentScore = getPaymentScore(payment);

		double distanceScore = minDistance / distance;

		double sum = areaScore * 2 + houseTypeScore * 1.5 + priceScore * 3 + paymentScore * 1.5 + distanceScore * 2;

		return Double.valueOf(String.format("%.1f", sum).toString());
	}
	
	// 整租评分
	public static double getScoreZheng(double area, String houseType, double price, String payment, double distance,
			double maxArea, double minPrice, double minDistance) {

		double areaScore = area / maxArea;

		double houseTypeScore = getHouseZheng(houseType);

		double priceScore = minPrice / price;

		double paymentScore = getPaymentScore(payment);

		double distanceScore = minDistance / distance;

		double sum = areaScore * 2 + houseTypeScore * 1.5 + priceScore * 3 + paymentScore * 1.5 + distanceScore * 2;

		return Double.valueOf(String.format("%.1f", sum).toString());
	}

	// payment得分
	private static double getPaymentScore(String payment) {
		if (payment.equals("月付价")) {
			return 1.0;
		}
		if (payment.equals("季付价")) {
			return 1.0 / 3;
		}
		if (payment.equals("半年付")) {
			return 1.0 / 6;
		}
		if (payment.length() == 4) {
			char[] cs = payment.toCharArray();
			int[] pay = new int[2];
			pay[0] = cs[1] - '0';
			pay[1] = cs[3] - '0';
			if (payment.equals("面议"))
				return 1.0 / 3;
			double paymentScore = 1.0 / pay[0];
			if (paymentScore > 1.0)
				paymentScore = 1.0;
			return paymentScore;
		} else { // 半年付押1
			return 1.0 / 6;
		}
	}

	// 合租HouseType得分
	private static double getHouseHe(String houseType) {
		if (houseType.length() == 6) {
			char[] cs = houseType.toCharArray();
			int[] house = new int[3];
			house[0] = cs[0] - '0';
			double houseTypeScore = 2.0 / house[0];
			if (houseTypeScore > 1.0)
				houseTypeScore = 1.0;
			return houseTypeScore;
		} else {
			return 2.0 / 5;
		}
	}

	// 整租HouseType得分
	private static double getHouseZheng(String houseType) {
		if (houseType.length() == 6) {
			char[] cs = houseType.toCharArray();
			int[] house = new int[3];
			house[0] = cs[0] - '0';
			house[1] = cs[2] - '0';
			house[2] = cs[4] - '0';
			double houseTypeScore = (house[0] + house[1] + house[2]) / 7.0;
			if (houseTypeScore > 1.0)
				houseTypeScore = 1.0;
			return houseTypeScore;
		} else {
			return 1.0 / 7;
		}

	}

}
