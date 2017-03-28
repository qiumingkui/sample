package com.qiumingkui.sample.imedia.asset.domain.model.account;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.asset.domain.model.busy.PointAdd;
import com.qiumingkui.sample.imedia.asset.domain.model.busy.PointSubtract;
import com.qiumingkui.sample.imedia.asset.domain.model.busy.RmbAdd;
import com.qiumingkui.sample.imedia.asset.domain.model.busy.RmbSubtract;
import com.qiumingkui.sample.imedia.asset.domain.model.member.Owner;

public abstract class AssetAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AssetAccountId assetAccountId;

	private PointBalance pointBalance;

	private RmbBalance rmbBalance;

	private Owner owner;

	private Timestamp createTime;

	private Timestamp modifyTime;

	private AssetAccount() {
		super();
	}

	public AssetAccount(AssetAccountId aAssetAccountId, PointBalance aPointBalance, RmbBalance aRmbBalance, Owner aOwner, Timestamp aCreateTime,
			Timestamp aModifyTime) {
		this();

		this.setAssetAccountId(aAssetAccountId);
		this.setPointBalance(aPointBalance);
		this.setRmbBalance(aRmbBalance);
		this.setOwner(aOwner);
		this.setCreateTime(aCreateTime);
		this.setModifyTime(aModifyTime);
		
	}

	public void addPoint(PointAdd aPointAdd) {

	}

	public void subtractPoint(PointSubtract aPointSubtract) {

	}

	public void addRmb(RmbAdd aRmbAdd) {

	}

	public void subtractRmb(RmbSubtract aRMBSubtract) {

	}

	/**
	 * @return the assetAccountId
	 */
	public AssetAccountId assetAccountId() {
		return assetAccountId;
	}

	/**
	 * @return the point
	 */
	public PointBalance pointBalance() {
		return pointBalance;
	}

	/**
	 * @return the rmb
	 */
	public RmbBalance rmbBalance() {
		return rmbBalance;
	}

	/**
	 * @return the owner
	 */
	public Owner owner() {
		return owner;
	}

	/**
	 * @return the createTime
	 */
	public Timestamp createTime() {
		return createTime;
	}

	/**
	 * @return the modifyTime
	 */
	public Timestamp modifyTime() {
		return modifyTime;
	}

	/**
	 * @param assetAccountId
	 *            the assetAccountId to set
	 */
	private void setAssetAccountId(AssetAccountId assetAccountId) {
		this.assetAccountId = assetAccountId;
	}

	/**
	 * @param point
	 *            the point to set
	 */
	private void setPointBalance(PointBalance aPointBalance) {
		this.pointBalance = aPointBalance;
	}

	/**
	 * @param rmb
	 *            the rmb to set
	 */
	private void setRmbBalance(RmbBalance aRmbBalance) {
		this.rmbBalance = aRmbBalance;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	private void setOwner(Owner owner) {
		this.owner = owner;
	}

	/**
	 * @param createTime
	 *            the createTime to set
	 */
	private void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	/**
	 * @param modifyTime
	 *            the modifyTime to set
	 */
	private void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

}
