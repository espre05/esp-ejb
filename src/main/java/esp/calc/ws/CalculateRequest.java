package esp.calc.ws;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="CalculateRequest", propOrder={"data", "operation"})
public class CalculateRequest {

	public CalculateRequest() {
		// TODO Auto-generated constructor stub
	}
	@XmlElement(name="data", required=true)
	private InputData data;
	@XmlElement(name="operation", required=true)
	private StatisticalOperation operation;
	public InputData getData() {
		return data;
	}
	public void setData(InputData data) {
		this.data = data;
	}
	public StatisticalOperation getOperation() {
		return operation;
	}
	public void setOperation(StatisticalOperation operation) {
		this.operation = operation;
	}
	@Override
	public String toString() {
		return "CalculateRequest [data=" + data + ", operation=" + operation + "]";
	}
	
}
