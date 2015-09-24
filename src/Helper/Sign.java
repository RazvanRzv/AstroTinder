package Helper;

import javax.swing.JComboBox;

public class Sign {

	private String				dayString;
	private String				monthString;
	private String				signString;
	private int					day;
	private int					month;
	private JComboBox<String>	dayBox;
	private JComboBox<String>	monthBox;
	private JComboBox<String>	signBox;

	public Sign(JComboBox<String> dayBox, JComboBox<String> monthBox,
			JComboBox<String> signBox) {
		this.dayBox = dayBox;
		this.monthBox = monthBox;
		this.signBox = signBox;
	}

	public Sign(JComboBox<String> dayBox, JComboBox<String> monthBox) {
		this.dayBox = dayBox;
		this.monthBox = monthBox;
	}

	private void setInfos() {
		if (signBox != null) {
			signString = signBox.getSelectedItem().toString();
		}
		dayString = dayBox.getSelectedItem().toString();
		monthString = monthBox.getSelectedItem().toString();
		day = Integer.parseInt(dayString);
		month = Integer.parseInt(monthString);
	}

	public boolean isDateValid() {
		setInfos();
		if ((month == 2 && day > 29)
				|| (month == 4 || month == 6 || month == 9 || month == 11)
						&& day > 30) {
			return false;
		}
		return true;
	}

	public String getSignDate() {
		setInfos();
		if ((day >= 21 && month == 3) || (day <= 20 && month == 4)) {
			return "Aries";
		}
		if ((day >= 21 && month == 4) || (day <= 21 && month == 5)) {
			return "Taurus";
		}
		if ((day >= 22 && month == 5) || (day <= 21 && month == 6)) {
			return "Gemini";
		}
		if ((day >= 22 && month == 6) || (day <= 22 && month == 7)) {
			return "Cancer";
		}
		if ((day >= 23 && month == 7) || (day <= 22 && month == 8)) {
			return "Leo";
		}
		if ((day >= 23 && month == 8) || (day <= 21 && month == 9)) {
			return "Virgo";
		}
		if ((day >= 22 && month == 9) || (day <= 22 && month == 10)) {
			return "Libra";
		}
		if ((day >= 23 && month == 10) || (day <= 21 && month == 11)) {
			return "Scorpio";
		}
		if ((day >= 23 && month == 11) || (day <= 21 && month == 12)) {
			return "Sagittarius";
		}
		if ((day >= 22 && month == 12) || (day <= 19 && month == 1)) {
			return "Capricorn";
		}
		if ((day >= 21 && month == 1) || (day <= 18 && month == 2)) {
			return "Aquarius";
		}
		if ((day >= 19 && month == 2) || (day <= 20 && month == 3)) {
			return "Pisces";
		}
		return "Invalid Date";
	}

	public String getSign() {
		setInfos();
		return signString;
	}

}
