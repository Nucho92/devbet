package fr.formation.inti.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.formation.inti.entities.User;
import fr.formation.inti.entities.Wallet;

@Repository
public interface IWalletDao extends JpaRepository<Wallet, Integer>{
	
	@Query("select w from Wallet w where w.walletId=?1")
	List<Wallet> findByWalletId(Integer walletId);
	
	
	
	@Modifying
	@Query("Update Wallet w set w.rechargeAmount=:rechargeAmount where user=:user")
	float rechargeWallet(@Param ("rechargeAmount") float rechargeAmount, @Param("user") User user);
	
	
	@Query("select w from Wallet w where user=:user")
	Wallet findWalletByUser(User user);
	


}
