package com.eitraz.tellstick.core.rawdevice;

import java.util.Map;

public class RawCommandDevice extends RawDevice {
	private final String method;

	public RawCommandDevice(String _class, String protocol, String model, String method, Map<String, String> parameters) {
		super(_class, protocol, model, parameters);

		this.method = method;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RawCommandDevice [method=" + method + ", toString()="
				+ super.toString() + "]";
	}

}