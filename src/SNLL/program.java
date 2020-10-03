package SNLL;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class program {

	public static void main(String[] args) throws NumberFormatException, IOException {

		SalesList salesList = new SalesList();
		BufferedReader bf;
		bf = new BufferedReader(new FileReader("SellersInfo.txt"));

		
		int sellersQ = Integer.parseInt(bf.readLine());
		
		String [] datos;
		
		for (int i=0; i<sellersQ; i++) {
			datos = bf.readLine().split(" ");
			Seller seller = new Seller();
			seller.name=datos[0];
			seller.membershipInitialFee= Integer.parseInt(datos[1]);
			
			salesList.add(seller);
			
			
		}//end for
		
		//salesList.printList(salesList.head);	
		salesList.getInitialBalance(salesList.head);
		salesList.getProfit(salesList.head);
		salesList.networkBalance(salesList.head);
		salesList.getSmallestBalance(salesList.head);
		
	}//end main

}//end program
