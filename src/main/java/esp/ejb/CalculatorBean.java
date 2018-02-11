package esp.ejb;

import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebParam.Mode;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import esp.calc.ws.CalculatedResponse;
import esp.calc.ws.CalculatorException;
import esp.calc.ws.InputData;
import esp.calc.ws.StatisticalOperation;
@Stateless
@WebService(name = "CalculatorService")
public class CalculatorBean {
	public CalculatedResponse calculate(@WebParam(mode=Mode.IN) @XmlElement(required=true, name="data") InputData data, @WebParam(mode=Mode.IN)  @XmlElement(required=true, name="operation") StatisticalOperation operation) throws CalculatorException {
		validateInputData(data, operation);
		CalculatedResponse result = new CalculatedResponse();
		try {
			switch (operation) {
			case SUM:
				int sum = data.getData().stream().reduce(0, (a, b) -> a + b);
				result.setResult(sum);
				break;
			case AVERAGE:
				throw new CalculatorException("AVG not implemented");
			default:
				throw new CalculatorException("Unknown operation");
			}
		} catch (Exception e) {
			throw new CalculatorException("Calculator exception", e);
		}

		return result;
	}

	private void validateInputData(InputData inData, StatisticalOperation operation) {
		if (inData == null || inData.getData() == null || inData.getData().size() == 0) {
			throw new CalculatorException("Invalid input Data");
		}
		if (operation == null) {
			throw new CalculatorException("Operation is mandatory");
		}

	}

}
