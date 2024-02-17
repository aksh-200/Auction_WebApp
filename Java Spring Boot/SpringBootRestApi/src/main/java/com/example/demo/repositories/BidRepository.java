package com.example.demo.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Bidding;
import com.example.demo.entities.User;

@Transactional
@Repository
public interface BidRepository extends JpaRepository<Bidding, Integer> {

	@Query("select b from Bidding b where bidder_id=:bidder_id")
	public List<Bidding> findAllBidsWon(User bidder_id);
	
	@Modifying
	@Query("update Bidding set bidding_status='payment done' where bid_id=:bid_id")
	public int changePaymentStatus(int bid_id);
	
	@Query("select b from Bidding b where b.P_Id.seller_id=:seller_id")
	public List<Bidding> findsellerhome(User seller_id);
}
