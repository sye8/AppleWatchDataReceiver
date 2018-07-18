/**
 * @author yesifan
 *
 */
public class HKQuantitySample {

	private double hr;
	private String startDate;
	private String endDate;
	
	public HKQuantitySample(double HR, String startDate, String endDate){
		this.hr = HR;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public double getHR() {
		return hr;
	}

	public void setHR(double hr) {
		this.hr = hr;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	public String toString(){
		return hr + "\t" + startDate + "\t" + endDate + "\n";
	}
}
