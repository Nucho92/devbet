package fr.formation.inti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.dao.IWalletDao;
import fr.formation.inti.entities.User;
import fr.formation.inti.entities.Wallet;

@Service
public class WalletServiceImpl implements IWalletService {

	@Autowired 
	private IWalletDao walletDao; 
	
	@Override
	public float rechargeWallet(float rechargeAmount, User user) {
		return walletDao.rechargeWallet(rechargeAmount, user);
		
	}

	@Override
	public List<Wallet> findByWalletId(Integer walletId) {
		
		return walletDao.findByWalletId(walletId);
	}

	@Override
	public void save(Wallet user) {
		walletDao.save(user);
		
	}

	@Override
	public Wallet get(Integer id) {
		// TODO Auto-generated method stub
		return walletDao.getById(id);
	}

	@Override
	public void delete(Wallet id) {
		walletDao.delete(id);
		
	}

	@Override
	public Wallet findWalletByUser(User user) {
		// TODO Auto-generated method stub
		return walletDao.findWalletByUser(user);
	}


	

}
