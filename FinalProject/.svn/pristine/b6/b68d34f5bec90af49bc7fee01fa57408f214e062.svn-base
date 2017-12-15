package yl128_pg23.game.server.model;

import java.io.Serializable;

/**
 * 
 * @author Yiqing Lu
 *
 */

public class IPosition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6240231319494390851L;
	private double latitude, longitude, elevation;

	public IPosition(double latitude, double longitude, double elevation) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
	}

	public double getLat() {
		return this.latitude;
	}

	public double getLon() {
		return this.longitude;
	}

	public double getEle() {
		return this.elevation;
	}

	public boolean equals(IPosition p) {
		return this.latitude == p.latitude && this.longitude == p.longitude && this.elevation == p.elevation;
	}

}
