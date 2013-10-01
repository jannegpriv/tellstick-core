package com.eitraz.tellstick.manager;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.eitraz.tellstick.core.device.Device;
import com.eitraz.tellstick.core.device.DeviceEventListener;
import com.eitraz.tellstick.core.device.DeviceHandler;

public class TellstickDeviceManager implements DeviceEventListener {
	private final Map<Integer, Device> devices = new ConcurrentHashMap<Integer, Device>();

	public TellstickDeviceManager(DeviceHandler deviceHandler) {
		// Get all devices
		List<Device> devices = deviceHandler.getDevices();
		for (Device device : devices) {
			this.devices.put(device.getDeviceId(), device);
		}

		// Add Device Event Listener
		deviceHandler.addDeviceEventListener(this);
	}

	/*
	 * (non-Javadoc)
	 * @see com.eitraz.tellstick.core.TellstickDeviceEventListener#deviceChanged(int, com.eitraz.tellstick.core.device.TellstickDevice)
	 */
	public void deviceChanged(int deviceId, Device device) {
		devices.put(deviceId, device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.eitraz.tellstick.core.TellstickDeviceEventListener#deviceAdded(int, com.eitraz.tellstick.core.device.TellstickDevice)
	 */
	public void deviceAdded(int deviceId, Device device) {
		devices.put(deviceId, device);
	}

	/*
	 * (non-Javadoc)
	 * @see com.eitraz.tellstick.core.TellstickDeviceEventListener#deviceRemoved(int)
	 */
	public void deviceRemoved(int deviceId) {
		devices.remove(deviceId);
	}

	/**
	 * Get Devices
	 * @return devices
	 */
	public Map<Integer, Device> getDevices() {
		return Collections.unmodifiableMap(devices);
	}
}