package org.openda.model_damflow;

import org.openda.exchange.TimeInfo;
import org.openda.interfaces.IExchangeItem;
import org.openda.interfaces.IGeometryInfo;
import org.openda.interfaces.IQuantityInfo;
import org.openda.interfaces.ITimeInfo;

public class DupuitBHOFileExchangeItem implements IExchangeItem {
	//TODO: find the proper interpretation of nx, b, and y!! also their data type, are they really integer?
	private int nx;
	private int b;
	private int y;
	private TimeInfo timeInfo;
	private double[] phi;
	private String id;

	public DupuitBHOFileExchangeItem(int nx, int b, int y, String id, double[] time, double[] phi) {
		this.nx = nx;
		this.b = b;
		this.y = y;
		this.id = id;
		this.timeInfo = new TimeInfo(time);
		this.phi = phi;
	}

	public int getNx() {
		return this.nx;
	}

	public int getB() {
		return this.b;
	}

	public int getY() {
		return this.y;
	}

	
	public Role getRole() {
		throw new UnsupportedOperationException("Class Name : org.openda.model_damflow.DupuitBHOFileExchangeItem - Method Name : getRole");
	}

	
	public String getId() {
		return this.id;
	}

	
	public String getDescription() {
		throw new UnsupportedOperationException("Class Name : org.openda.model_damflow.DupuitBHOFileExchangeItem - Method Name : getDescription");
	}

	
	public Class getValueType() {
		throw new UnsupportedOperationException("Class Name : org.openda.model_damflow.DupuitBHOFileExchangeItem - Method Name : getValueType");
	}

	
	public void copyValuesFromItem(IExchangeItem sourceItem) {
		throw new UnsupportedOperationException("Class Name : org.openda.model_damflow.DupuitBHOFileExchangeItem - Method Name : copyValuesFromItem");
	}

	
	public ITimeInfo getTimeInfo() {
		throw new UnsupportedOperationException("Class Name : org.openda.model_damflow.DupuitBHOFileExchangeItem - Method Name : getTimeInfo");
	}

	
	public IQuantityInfo getQuantityInfo() {
		throw new UnsupportedOperationException("Class Name : org.openda.model_damflow.DupuitBHOFileExchangeItem - Method Name : getQuantityInfo");
	}

	
	public IGeometryInfo getGeometryInfo() {
		throw new UnsupportedOperationException("Class Name : org.openda.model_damflow.DupuitBHOFileExchangeItem - Method Name : getGeometryInfo");
	}

	
	public ValueType getValuesType() {
		throw new UnsupportedOperationException("Class Name : org.openda.model_damflow.DupuitBHOFileExchangeItem - Method Name : getValuesType");
	}

	
	public Object getValues() {
		throw new UnsupportedOperationException("Class Name : org.openda.model_damflow.DupuitBHOFileExchangeItem - Method Name : getValues");
	}

	
	public double[] getValuesAsDoubles() {
		int nValues = this.phi.length;
		double[] values = new double[nValues];
		System.arraycopy(this.phi, 0, values, 0, nValues);
		return values;
	}

	
	public void axpyOnValues(double alpha, double[] axpyValues) {
		int nValues = this.phi.length;
		double[] newValues = new double[nValues];
		if (nValues != axpyValues.length) {
			throw new RuntimeException(this.getClass() + ": vectors of different size, cannot perform axpyOnValues.");
		}
		for (int i = 0; i < nValues; i++) {
			newValues[i] = alpha * axpyValues[i] + this.phi[i];
		}
		System.arraycopy(newValues, 0, this.phi, 0, nValues);
	}

	
	public void multiplyValues(double[] multiplicationFactors) {
        if (this.phi.length != multiplicationFactors.length){
            throw new RuntimeException(this.getClass() + ": vectors of different size, cannot perform multiplyValues.");
        }
        for (int i=0; i<multiplicationFactors.length; i++){
            this.phi[i] *= multiplicationFactors[i];
        }
//		throw new UnsupportedOperationException("Class Name : org.openda.model_damflow.DupuitBHOFileExchangeItem - Method Name : multiplyValues");
	}

	
	public void setValues(Object values) {
		throw new UnsupportedOperationException("Class Name : org.openda.model_damflow.DupuitBHOFileExchangeItem - Method Name : setValues");
	}

	
	public void setValuesAsDoubles(double[] values) {
		int nValues = this.phi.length;
		if (nValues != values.length) {
			throw new RuntimeException(this.getClass() + ": vectors of different size, cannot perform setValuesAsDouble.");
		}
		System.arraycopy(values, 0, this.phi, 0, nValues);
	}

	
	public double[] getTimes() {
		return this.timeInfo.getTimes();
	}

	
	public void setTimes(double[] times) {
		throw new UnsupportedOperationException("Class Name : org.openda.model_damflow.DupuitBHOFileExchangeItem - Method Name : setTimes");
	}
}
