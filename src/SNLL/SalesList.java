package SNLL;

public class SalesList {

	SellerNode head;

	int membershipDiscountPercentage = 10;
	int commissionProfitPercentage = 25;
	
	public void add(Seller seller){
		
		SellerNode newSeller = new SellerNode();
		newSeller.seller = seller;
				
		if (head== null){
			head = newSeller;
		}
		else {
			SellerNode tmp = head;
			while(tmp.next!=null){
				tmp = tmp.next;
			}
			tmp.next = newSeller;
		}
	}// end add
	
	public void printList(SellerNode node) {
		if(node==null) {
			return;
		}
		System.out.println("name: " + node.seller.name + " " + 
		"initial fee: " +  node.seller.membershipInitialFee );
		printList(node.next);
	}
	
	
	public int getInitialBalance (SellerNode node) {
		if(node == null) {
			return 0;		
		}
		
		int tot =0;
		
		SellerNode tmp = this.head;
		while(tmp!=null) {
			 tot = tmp.seller.membershipInitialFee - (tmp.seller.membershipInitialFee*membershipDiscountPercentage/100);
			 			 
			 //System.out.println(" Initial Balance " + tmp.seller.name + ": "+  tot );
			 tmp = tmp.next;
		}
		return tot ;
	}// end initial balance
	
	public int getProfit (SellerNode node) {
		if(node == null) {
			return 0;		
		}
		
		int tot =0;
		int add=0;
		SellerNode tmp = this.head;
		while(tmp!=null) {
			
			add+=(getInitialBalance(node.next)*commissionProfitPercentage/100);
			tot = getInitialBalance(node) + add;
			 			 
			 //System.out.println(" actual Balance " + tmp.seller.name + ": "+  tot );
			 tmp = tmp.next;
		}
		return tot ;
	}//end profit 
	
	public int networkBalance (SellerNode node) {
		if(node == null) {
			return 0;		
		}
		SellerNode tmp = this.head;
		int nB =0;
		while(tmp!=null) {
			nB+=getProfit(node);
			tmp=tmp.next;
		}
		System.out.println("networkBalance: " + nB);
		return nB;
	}
	
	public int getSmallestBalance(SellerNode node) {
		if(node == null) {
			return 0;		
		}
		SellerNode tmp = this.head;
		//int small =0;
		/*while(tmp!=null) {
			small=Math.min(head.seller.balance, tmp.seller.balance);
			tmp=tmp.next;
		}*/
		//System.out.println(small);
		return Math.min(head.seller.balance, tmp.next.seller.balance);
		
	}//end networkBalance
	
	public int getLargestBalance(SellerNode node) {
		if(node == null) {
			return 0;		
		}
		SellerNode tmp = this.head;
		//int largest =0;
		/*while(tmp!=null) {
			small=Math.min(head.seller.balance, tmp.seller.balance);
			tmp=tmp.next;
		}*/
		//System.out.println(small);
		return Math.max(head.seller.balance, tmp.seller.balance);
		
	}
}
