package com.bnp.paribas.supermarket.util;

import java.util.HashMap;
import java.util.Map;

public enum ProductEnum {
	APPLE("apple", 0.20), ORANGE("orange", 0.50), WATERMELON("watermelon", 0.80);
	
	private final String key;
    private final double value;
	
    ProductEnum(String key, double value) {
        this.key = key;
        this.value = value;
    }
    
	public String getKey() {
		return key;
	}
	
	public double getValue() {
		return value;
	}
	
	private static final Map<String, Double> lookup = new HashMap<>();
	
	static {
        for (ProductEnum p : ProductEnum.values()) {
            lookup.put(p.getKey(), p.getValue());
        }
    }

	
	public static double get(String key) {
		return lookup.get(key);
	}
}
