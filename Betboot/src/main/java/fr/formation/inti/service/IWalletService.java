package fr.formation.inti.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import fr.formation.inti.entities.User;
import fr.formation.inti.entities.Wallet;

public interface IWalletService {

	List<Wallet> findByWalletId(Integer walletId);

	float rechargeWallet(@Param("rechargeAmount") float rechargeAmount, @Param("user") User user);

	void save(Wallet user);

	Wallet get(Integer id);

	void delete(Wallet id);

	Wallet findWalletByUser(User user);
}
