package com.qiumingkui.sample.imedia.asset.domain.model.account;

import java.io.Serializable;
import java.sql.Timestamp;

import com.qiumingkui.sample.imedia.asset.domain.model.account.point.Point;
import com.qiumingkui.sample.imedia.asset.domain.model.account.point.PointAdd;
import com.qiumingkui.sample.imedia.asset.domain.model.account.point.PointSubtract;
import com.qiumingkui.sample.imedia.asset.domain.model.account.rmb.Rmb;
import com.qiumingkui.sample.imedia.asset.domain.model.account.rmb.RmbAdd;
import com.qiumingkui.sample.imedia.asset.domain.model.account.rmb.RmbSubtract;
import com.qiumingkui.sample.imedia.asset.domain.model.member.Owner;

public class AssetAccount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AssetAccountId assetAccountId;

	private Point point;

	private Rmb rmb;

	private Owner owner;

	private Timestamp createTime;

	private Timestamp modifyTime;

	private AssetAccount() {
		super();
	}

	public AssetAccount(AssetAccountId aAssetAccountId, Point aPoint, Rmb aRmb, Owner aOwner, Timestamp aCreateTime,
			Timestamp aModifyTime) {
		this();

		this.setAssetAccountId(aAssetAccountId);
		this.setPoint(aPoint);
		this.setRmb(aRmb);
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
	public Point point() {
		return point;
	}

	/**
	 * @return the rmb
	 */
	public Rmb rmb() {
		return rmb;
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
	private void setPoint(Point point) {
		this.point = point;
	}

	/**
	 * @param rmb
	 *            the rmb to set
	 */
	private void setRmb(Rmb rmb) {
		this.rmb = rmb;
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
