package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Bidding;
import com.example.demo.entities.BiddingTransaction;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;

@Transactional
@Repository
public interface BiddingRepository extends JpaRepository<BiddingTransaction, Integer> {

	@Query(value = "select * from bidding_transaction\r\n"
			+ "where P_Id=:P_Id and bid_price = (select max(bid_price) \r\n"
			+ "								from bidding_transaction\r\n"
			+ "                                where P_Id=:P_Id)"
			+ "limit 1; ", nativeQuery=true)
	public BiddingTransaction findMaxBid(int P_Id);
	
	
//	public BiddingTransaction bid(int P_Id,int bidder_id);
	
	//@Query(value = "select * from bidding_table where P_Id=:P_Id limit 1", nativeQuery=true)
	//select p from Product p where status='pending'
	@Query("select b from Bidding b where P_Id=:P_Id")
	public Bidding findProductInBiddingTable(Product P_Id);
	
	
	@Query(value="select bidding_transaction_id,b.P_Id,bidder_id,max(bid_price) bid_price,bid_time from bidding_transaction b,product p  where b.P_ID=p.P_Id and b.bidder_id =:bidder_id and curdate() between p.start_date and p.end_date group by P_Id",nativeQuery=true)
	public List<BiddingTransaction> mybids(int bidder_id);
	
	@Query(value="select max(bid_price) from bidding_transaction where P_Id=:P_Id",nativeQuery=true)
	public float findHighestBidForProductUsingP_Id(int P_Id);
	
}