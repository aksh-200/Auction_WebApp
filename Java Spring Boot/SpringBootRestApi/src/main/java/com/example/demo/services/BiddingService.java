package com.example.demo.services;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Bidding;
import com.example.demo.entities.BiddingTransaction;
import com.example.demo.entities.Product;
import com.example.demo.entities.User;
import com.example.demo.repositories.BidRepository;
import com.example.demo.repositories.BiddingRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class BiddingService {

	@Autowired
	BiddingRepository btrepo;
	
	@Autowired
	ProductRepository prepo;
	
	@Autowired
	UserRepository urepo;
	
	@Autowired
	BidRepository brepo;
	
	public BiddingTransaction findMaxBid(int P_Id)
	{
		return btrepo.findMaxBid(P_Id);
	}
	
	public BiddingTransaction bid(int P_ID,int bidder_Id,float bid_price)
	{
		Product P_Id=prepo.findById(P_ID).get();
		User bidder_id=urepo.findById(bidder_Id).get();
        long millis=System.currentTimeMillis();  
        java.sql.Date date=new java.sql.Date(millis);  
		
		BiddingTransaction bt= new BiddingTransaction(P_Id,bidder_id,bid_price,date);
		
		return btrepo.save(bt);
	}
	
	public Bidding findProductInBiddingTable(int P_id)
	{
		Product P_Id=prepo.findById(P_id).get();
		return btrepo.findProductInBiddingTable(P_Id);
	}
	
	public Bidding save(Bidding b)
	{
		return brepo.save(b);
	}
	
	public List<Bidding> findAllFinalBids()
	{
		return brepo.findAll();
	}
	
	public List<Bidding> findAllBidsWon(int b_id)
	{
		User bidder_id = urepo.getById(b_id).get();
		return brepo.findAllBidsWon(bidder_id);
	}
	
	public List<BiddingTransaction> mybids(int bidder_id)
	{
		return btrepo.mybids(bidder_id);
	}
	
	public List<Bidding> findsellerhome(int sellerr_id)
	{
		User Seller_id =urepo.getById(sellerr_id).get();
		return brepo.findsellerhome(Seller_id);
	}
	
	public float findHighestBidForProductUsingP_Id(int P_Id)
	{
		return btrepo.findHighestBidForProductUsingP_Id(P_Id);
	}
	
	public Bidding findBidById(int bid_id)
	{
		return brepo.findById(bid_id).get();
	}
	
	public int changePaymentStatus(int b_id)
	{
		Bidding bid_id = brepo.findById(b_id).get();
		return brepo.changePaymentStatus(b_id);
	}
}
