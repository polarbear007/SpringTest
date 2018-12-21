package cn.itcast.transactionManager;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDao extends JdbcDaoSupport {
	// 根据  id 查询帐户余额
	public Double getBalanceById(Integer id) {
		return this.getJdbcTemplate().queryForObject("select balance from t_account where id = ?", 
								Double.class, id);
	}
	
	// 根据 id 从余额里面扣款
	public void out(Integer id, Double amount) {
		this.getJdbcTemplate().update("update t_account set balance = balance - ? where id = ?",
								amount, id);
	}
	
	// 根据 id 给余额增加指定金额
	public void in(Integer id, Double amount) {
		this.getJdbcTemplate().update("update t_account set balance = balance + ? where id = ?", 
								amount, id);
	}
	
	// 根据id 查询用户
	public Account getAccountById(Integer id) {
		return this.getJdbcTemplate().queryForObject("select * from t_account where id = ?", 
								new BeanPropertyRowMapper<>(Account.class), id);
	}
}
