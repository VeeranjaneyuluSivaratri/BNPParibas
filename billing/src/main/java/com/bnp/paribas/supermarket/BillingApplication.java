package com.bnp.paribas.supermarket;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.bnp.paribas.supermarket.util.OfferCalculation;
import com.bnp.paribas.supermarket.util.PrintingBill;
import com.bnp.paribas.supermarket.util.ProductEnum;



public class BillingApplication {
	
	public static void main(String[] args) {
		double cost = 0;
		Map<String, Integer> fruitMap = new HashMap<>();

		try (Scanner scanner = new Scanner(System.in)) {
			//Loop thru product
			for(ProductEnum product: ProductEnum.values()) {
				int count = readInt("How many "+product.getKey()+" ?", scanner);
				cost = cost + OfferCalculation.offerDetail(product.getKey(),count);
				fruitMap.put(product.getKey(), count);
			}
			
			//Print bill
			PrintingBill.printBill(fruitMap);
			
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

	}
	
	private static int readInt(String msg, Scanner scanner) {
		int count = 0;
		System.out.print(msg);
        while (true) {
        	try {
                count = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException nfe) {
                System.out.print("Try again: ");
            }
        }
        return count;
	}
}
