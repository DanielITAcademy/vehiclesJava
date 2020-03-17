package com.vehicles.project;

public class Wheel {
	private String brand;
	private double diameter;

	public Wheel(String brand, double diameter) {
		try {
			CheckDiametre(diameter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.brand = brand;
		this.diameter = diameter;
	}

	@Override
	public String toString() {
		return "Wheel [brand=" + brand + ", diameter=" + diameter + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wheel other = (Wheel) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (Double.doubleToLongBits(diameter) != Double.doubleToLongBits(other.diameter))
			return false;
		return true;
	}

	public void CheckDiametre(double diametre) throws Exception {
		
		if(!(diametre>0.4&&diametre<4)) 
			throw new Exception("This diametre is not between 0.4 and 4");
		
	}
	
	
}
