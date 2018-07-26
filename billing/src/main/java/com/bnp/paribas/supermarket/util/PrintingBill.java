package com.bnp.paribas.supermarket.util;

import java.util.Map;
import java.util.Map.Entry;

public class PrintingBill {
	public static void printBill(Map<String, Integer> fruitMap) {
		double totalBill = 0;
		double productBill = 0;
		System.out.println("Printing bill:");
		System.out.format("%32s%10s%10s%20s%20s", "Product", "Quantity", "rate(£)", "Offer","Amount(£)");
		System.out.println("");
		
		for(Entry<String, Integer> e: fruitMap.entrySet()) {
			productBill = OfferCalculation.offerDetail(e.getKey(), e.getValue());
			System.out.format("%32s%10d%10s%20s%20s", e.getKey(), e.getValue(), ProductEnum.get(e.getKey()), OfferCalculation.offerMap.get(e.getKey()), productBill);
			System.out.println("");
			totalBill = totalBill + productBill;
		}
		System.out.println("Total Bill: £"+ totalBill);

	}
}
