
public class present_value {
	
	public static double calc_pv(double rate, double allowable_pay, int term, double downpay){
		
		int months = term * 12;
		double mo_rate= rate/12;
		double monthlyrate_exp = Math.pow(1+mo_rate, months);
		
		double pv = (allowable_pay)*(((1-(1/monthlyrate_exp))/mo_rate)+downpay);
		
		return pv;
	}
	
	public static void main(String[] args){
		double r = .06;
		int num_pay= 360;
		double can_pay = 840;
		calc_pv(r,can_pay,30,0);
		System.out.println(calc_pv(r,can_pay,30,0));
		
	}
}
