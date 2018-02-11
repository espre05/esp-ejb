package esp.calc.ws;

public class CalculatedResponse {
	private Integer result;

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "CalculatedResponse [result=" + result + "]";
	}

}
