package cn.itcast.transactionManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {
	@Autowired
	private AccountDao accountDao;
	
	@Transactional
	public void transfer(Account fromAccount, Account toAccount, Double amount) {
		try {
			Double balance = accountDao.getBalanceById(fromAccount.getId());
			if(balance == null) {
				throw new RuntimeException("查无此用户");
			}else if(balance < amount) {
				throw new RuntimeException("余额不足");
			}else {
				accountDao.out(fromAccount.getId(), amount);
				accountDao.in(toAccount.getId(), amount);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public Account getAccountById(Integer id) {
		return accountDao.getAccountById(id);
	}
	
}
