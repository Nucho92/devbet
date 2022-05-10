package fr.formation.inti.entities;
// Generated 4 mai 2022, 11:33:36 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Wallet generated by hbm2java
 */
@Entity
@Table(name = "wallet", catalog = "ligue1_gamble")
public class Wallet implements java.io.Serializable {

	private Integer walletId;
	private User user;
	private Float availBalance;
	private Date lastActivity;
	private Date lastRecharge;
	private Float rechargeAmount;

	public Wallet() {
	}

	public Wallet(User user, Float availBalance, Date lastActivity, Date lastRecharge, Float rechargeAmount) {
		this.user = user;
		this.availBalance = availBalance;
		this.lastActivity = lastActivity;
		this.lastRecharge = lastRecharge;
		this.rechargeAmount = rechargeAmount;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "wallet_id", unique = true, nullable = false)
	public Integer getWalletId() {
		return this.walletId;
	}

	public void setWalletId(Integer walletId) {
		this.walletId = walletId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "avail_balance", precision = 12, scale = 0)
	public Float getAvailBalance() {
		return this.availBalance;
	}

	public void setAvailBalance(Float availBalance) {
		this.availBalance = availBalance;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "last_activity", length = 10)
	public Date getLastActivity() {
		return this.lastActivity;
	}

	public void setLastActivity(Date lastActivity) {
		this.lastActivity = lastActivity;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "last_recharge", length = 10)
	public Date getLastRecharge() {
		return this.lastRecharge;
	}

	public void setLastRecharge(Date lastRecharge) {
		this.lastRecharge = lastRecharge;
	}

	@Column(name = "recharge_amount", precision = 12, scale = 0)
	public Float getRechargeAmount() {
		return this.rechargeAmount;
	}

	public void setRechargeAmount(Float rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

}
