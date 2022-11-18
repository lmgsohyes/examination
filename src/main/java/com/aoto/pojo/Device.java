package com.aoto.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;



@XmlRootElement(name = "device")
@XmlAccessorType(XmlAccessType.NONE)
public class Device implements Serializable {
	private static final long serialVersionUID = -3156027615645618339L;
	private int deviceId; /* IDPK. */
	private String deviceCode; /* 设备编码. */
	private String deviceName; /* 设备名称. */
	private String deviceIp; /* 设备IP. */
	private int devicePort; /* 设备端口. */
	private String mac; /* 设备MAC地址. */

	private int deviceType; /* 设备大类. */
	private int deviceTypeDetail; /* 设备小类. */

	private String deviceVersion; /* 设备型号（门楣屏）. */

	private String orientation; /* 屏幕类型（横屏/竖屏） */

	private String state; /* 指令执行状态. */
	private int isAudit; /* 审核状态. */
	private int online; /* 是否在线. */

	private int supplierId; /* 厂商ID. */
	private String supplierName; /* 厂商Name. */
	private String remark; /* 备注I. */
	private String comments; /* 备注II. */

	private int strategyId; /* 策略ID. */
	private String strategyName; /* 策略Name. */

	private String diskInfo; /* 磁盘信息. */
	private String operationType; /* 指令. */
	private int orgId; /* 机构ID. */
	private String orgName; /* 机构Name. */
	private boolean subContain; /* 是否包含子机构. */
	private boolean deleted; /* 是否被删除. */
	private String result; /* . */

	@JsonDeserialize(using = DateDeserializer.class)
	private Date systemDate; /* . */
	private int width; /* LED的宽. */
	private int height; /* LED的高. */
	private int proTextId; /* . */
	private int proClockId; /* . */

	private String proTextName; /* . */
	private String proClockName; /* . */

	private String lcdViewMsg; /* . */

	private String multiIp; /* 视展卡副卡IP. */

	private int ledCls; /* 控制卡类型（视展4砺研5诣阔7仰邦9）. */

	private Date lastHeartbeatDate; /* 最近心跳日期. */

	private int createdBy; /* 创建人ID. */
	private String createdByName; /* 创建人Name. */
	private Date createdDate; /* 创建日期. */

	private int lastUpdatedBy; /* 最近更新人ID（一般是心跳）. */
	private String lastUpdatedByName; /* 最近更新人Name（一般是心跳）. */
	private Date lastUpdatedDate; /* 最近更新日期（一般是心跳）. */

	private int lastEditBy; /* 最近编辑人ID（一般是编辑设备信息）. */
	private String lastEditByName; /* 最近编辑人Name（一般是编辑设备信息）. */
	private Date lastEditDate; /* 最近编辑的日期（一般是编辑设备信息）. */

	private int lastCommandBy; /* 最近下发指令人ID. */
	private String lastCommandByName; /* 最近下发指令人Name. */
	private Date lastCommandDate; /* 最近下发指令的日期. */

	private int screenNo; /* 仰邦卡屏号. */

	private String command; /* 心跳返回给终端的任务xml编号. */

	private String firmware;

	private String downloadProgress; /* 下载进度. */

	private int isDoubleScreen; /* 判断是否为双面屏 1为双面，0为单面 */

	private String faceDate;

	//增加是否开关的属性
	private String isOn;

	public Device() {
		super();
	}
	

	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ",deviceCode=" + deviceCode + ",deviceName=" + deviceName + ",deviceIp="
				+ deviceIp + ",devicePort=" + devicePort + ",mac=" + mac + ",deviceType=" + deviceType
				+ ",deviceTypeDetail=" + deviceTypeDetail + ",deviceVersion=" + deviceVersion + ",orientation="
				+ orientation + ",state=" + state + ",isAudit=" + isAudit + ",online=" + online + ",supplierId="
				+ supplierId + ",supplierName=" + supplierName + ",remark=" + remark + ",comments=" + comments
				+ ",strategyId=" + strategyId + ",strategyName=" + strategyName + ",diskInfo=" + diskInfo
				+ ",operationType=" + operationType + ",orgId=" + orgId + ",orgName=" + orgName + ",subContain="
				+ subContain + ",deleted=" + deleted + ",result=" + result + ",systemDate=" + systemDate + ",width="
				+ width + ",height=" + height + ",proTextId=" + proTextId + ",proClockId=" + proClockId
				+ ",proTextName=" + proTextName + ",proClockName=" + proClockName + ",lcdViewMsg=" + lcdViewMsg
				+ ",multiIp=" + multiIp + ",ledCls=" + ledCls + ",lastHeartbeatDate=" + lastHeartbeatDate
				+ ",createdBy=" + createdBy + ",createdByName=" + createdByName + ",createdDate=" + createdDate
				+ ",lastUpdatedBy=" + lastUpdatedBy + ",lastUpdatedByName=" + lastUpdatedByName + ",lastUpdatedDate="
				+ lastUpdatedDate + ",lastEditBy=" + lastEditBy + ",lastEditByName=" + lastEditByName + ",lastEditDate="
				+ lastEditDate + ",lastCommandBy=" + lastCommandBy + ",lastCommandByName=" + lastCommandByName
				+ ",lastCommandDate=" + lastCommandDate + ",screenNo=" + screenNo + ",command=" + command + ",]";
	}

	@XmlAttribute(name = "id")
	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceCode() {
		return deviceCode;
	}

	public void setDeviceCode(String deviceCode) {
		this.deviceCode = deviceCode;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceIp() {
		return deviceIp;
	}

	public void setDeviceIp(String deviceIp) {
		this.deviceIp = deviceIp;
	}

	public int getDevicePort() {
		return devicePort;
	}

	public void setDevicePort(int devicePort) {
		this.devicePort = devicePort;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public int getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}

	public int getDeviceTypeDetail() {
		return deviceTypeDetail;
	}

	public void setDeviceTypeDetail(int deviceTypeDetail) {
		this.deviceTypeDetail = deviceTypeDetail;
	}

	public String getDeviceVersion() {
		return deviceVersion;
	}

	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getIsAudit() {
		return isAudit;
	}

	public void setIsAudit(int isAudit) {
		this.isAudit = isAudit;
	}

	@XmlElement
	public int getOnline() {
		return online;
	}

	public void setOnline(int online) {
		this.online = online;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@XmlElement
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getStrategyId() {
		return strategyId;
	}

	public void setStrategyId(int strategyId) {
		this.strategyId = strategyId;
	}

	public String getStrategyName() {
		return strategyName;
	}

	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}

	@XmlElement
	public String getDiskInfo() {
		return diskInfo;
	}

	public void setDiskInfo(String diskInfo) {
		this.diskInfo = diskInfo;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public int getOrgId() {
		return orgId;
	}

	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@XmlElement
//	@DateTimeFormat()
//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//	@JsonDeserialize(using = LocalDateDeserializer.class)
//	@JsonSerialize(using = LocalDateSerializer.class)
	public Date getSystemDate() {
		return systemDate;
	}

	public void setSystemDate(Date systemDate) {
		this.systemDate = systemDate;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isSubContain() {
		return subContain;
	}

	public void setSubContain(boolean subContain) {
		this.subContain = subContain;
	}

	public int getProTextId() {
		return proTextId;
	}

	public void setProTextId(int proTextId) {
		this.proTextId = proTextId;
	}

	public int getProClockId() {
		return proClockId;
	}

	public void setProClockId(int proClockId) {
		this.proClockId = proClockId;
	}

	public String getProTextName() {
		return proTextName;
	}

	public void setProTextName(String proTextName) {
		this.proTextName = proTextName;
	}

	public String getProClockName() {
		return proClockName;
	}

	public void setProClockName(String proClockName) {
		this.proClockName = proClockName;
	}

	public String getLcdViewMsg() {
		return lcdViewMsg;
	}

	public void setLcdViewMsg(String lcdViewMsg) {
		this.lcdViewMsg = lcdViewMsg;
	}

	public String getMultiIp() {
		return multiIp;
	}

	public void setMultiIp(String multiIp) {
		this.multiIp = multiIp;
	}

	public int getLedCls() {
		return ledCls;
	}

	public void setLedCls(int ledCls) {
		this.ledCls = ledCls;
	}

	public Date getLastHeartbeatDate() {
		return lastHeartbeatDate;
	}

	public void setLastHeartbeatDate(Date lastHeartbeatDate) {
		this.lastHeartbeatDate = lastHeartbeatDate;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(int lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getLastUpdatedByName() {
		return lastUpdatedByName;
	}

	public void setLastUpdatedByName(String lastUpdatedByName) {
		this.lastUpdatedByName = lastUpdatedByName;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public int getLastEditBy() {
		return lastEditBy;
	}

	public void setLastEditBy(int lastEditBy) {
		this.lastEditBy = lastEditBy;
	}

	public String getLastEditByName() {
		return lastEditByName;
	}

	public void setLastEditByName(String lastEditByName) {
		this.lastEditByName = lastEditByName;
	}

	public Date getLastEditDate() {
		return lastEditDate;
	}

	public void setLastEditDate(Date lastEditDate) {
		this.lastEditDate = lastEditDate;
	}

	public int getLastCommandBy() {
		return lastCommandBy;
	}

	public void setLastCommandBy(int lastCommandBy) {
		this.lastCommandBy = lastCommandBy;
	}

	public String getLastCommandByName() {
		return lastCommandByName;
	}

	public void setLastCommandByName(String lastCommandByName) {
		this.lastCommandByName = lastCommandByName;
	}

	public Date getLastCommandDate() {
		return lastCommandDate;
	}

	public void setLastCommandDate(Date lastCommandDate) {
		this.lastCommandDate = lastCommandDate;
	}

	public int getScreenNo() {
		return screenNo;
	}

	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}

	@XmlElement
	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	@XmlElement
	public String getFirmware() {
		return firmware;
	}

	public void setFirmware(String firmware) {
		this.firmware = firmware;
	}

	public String getDownloadProgress() {
		return downloadProgress;
	}

	public void setDownloadProgress(String downloadProgress) {
		this.downloadProgress = downloadProgress;
	}

	@XmlElement
	public String getFaceDate() {
		return faceDate;
	}

	public void setFaceDate(String faceDate) {
		this.faceDate = faceDate;
	}

	public int getIsDoubleScreen() {
		return isDoubleScreen;
	}

	public void setIsDoubleScreen(int isDoubleScreen) {
		this.isDoubleScreen = isDoubleScreen;
	}

	public String getIsOn() {
		return isOn;
	}

	public void setIsOn(String isOn) {
		this.isOn = isOn;
	}
}
