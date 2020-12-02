package com.es.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "github",type = "shebei")

public class Shebei implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    protected String remarks;	// 备注

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date createDate;	// 创建日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date updateDate;	// 更新日期
    protected String delFlag; 	// 删除标记（0：正常；1：删除；2：审核）
    protected String isAudit="0"; 	// 判定是否是流程审批（0：否；1：是；）
    protected String operationType;//操作类型  系统、门户

    private String tiaoma;		// 条码
    private String name;		// 设备名称
    private String shebeilxid;		// 设备类型
    private String shebeilxmc;		// 设备类型mc
    private String shebeiglyid;		// 设备管理员
    private String shebeiglymc;		// 设备管理员mc
    private String gudingzcbh;		// 固定资产编号
    private String gongzuorlid;		// 工作日历ID
    private String gongzuorlmc;		// 工作日历mc
    private String yuyuefw;		// 预约范围（可预约的天数）
    private String yuyuezdsc;		// 预约最大时长
    private String cunfanwzid;		// 存放位置
    private String cunfanwzmc;		// 存放位置mc
    private String shebeixh;		// 设备型号
    private String ketizid;		// 课题组
    private String ketizmc;		// 课题组mc
    private String shebeiytsm;		// 设备用途说明
    private String shebeidacfc;		// 设备档案存放处
    private String shebeifzrid;		// 设备负责人
    private String shebeifzrmc;		// 设备负责人
    private String filecode;		// 附件码(收费标准附件shoufeibzfj,保养模板附件baoyangmbfj,设备照片附件shebeizpfj)
    private String shoufeibz;		//收费标准（20190416 页面改为文本框形式，故添加该字段）
    private String baoyangyq;		// 保养要求
    private String shebeiztdict;		// 设备状态(ZY_SHEBEIZT)
    private String shebeishztdict;		// 设备审核状态(ZY_SHEBEISHZT)
    private String qijianhczq;		// 期间核查周期
    private String qijianhczqdw;		// 期间核查周期单位
    private String hechaff;		// 核查方法
    private String shoucihcrq;		// 首次核查日期
    private String hechar;		// 核查人
    private String hechaxm;		// 核查项目
    private String xiacihcrq;		// 下次核查日期
    private String cankaowjdw;		// 参考外检单位
    private String youxiaorq;		// 有效日期
    private String jiandingjzzq;		// 检定校准周期
    private String zhouqidw;		// 周期单位(字典)
    private String shoucijdjzrq;		// 首次检定校准日期
    private String dingjianzq;		// 定检周期
    private String xianyongfw;		// 限用范围
    private String jiliangfzrid;		// 计量负责人
    private String jiliangfzrmc;		// 计量负责人
    private String daoqitqtxsj;		// 到检提前提醒时间
    private String jiandingjzyq;		// 检定校准要求
    private String jiandingztdict;		// 检定状态(ZY_SHEBEIJDZT)
    private String zhizaos;		// 制造商
    private String gongyignsid;		// 供应商ID
    private String gongyignsmc;		// 供应商mc
    private String chuchangbh;		// 出厂编号
    private String chuchangrq;		// 出厂日期
    private String gouzhirq;		// 购置日期
    private String gouzhije;		// 购置金额
    private String zijinly;		// 资金来源
    private String zhibaoq;		// 质保期
    private String shiyongdwid;		// 使用单位id
    private String shiyongdwmc;		// 使用单位mc
    private String jiandingyid;		// 检定员id
    private String jiandingymc;		// 检定员mc
    private String meiriyykssj;//每日预约开始时间
    private String meiriyyjssj;//每日预约结束时间
    private String yuyuezxdw;//预约最小单位
    private String bukeyysj;//不可预约时间
    private String bukeyyjssj;//不可预约结束时间
    private String shebeizzid;//设备资质id
    private String shebeizzmc;//设备资质名称
    private String qijianhcdqtqtxsj;//期间核查到期提前提醒时间（单位天）
    private String buttonType;      //操作类型 save  submit
    private String flowtype;        //流程类型  区分是新增，变更，删除流程
    private Boolean isShebeigly;    //是否设备管理员角色
    private String shebeixxbgsqid;  //设备变更申请id（只存最近一次的）
    private String gaonanduyydj;	//高难度预约单价

    private String yuyuesjdatastr;//预约时间临时变量
    private String shouzhangzp;//首张照片ID
    private String canshu;//已预约时间参数临时变量
    private String yuyuedj;//预约单价
    private String formtype;//判断是0：首页,1：首页点击更多还是 2：管理

    private String shifoudy;//是否对外预约和展示

    private String zhichiyylx;//支持预约类型 （数据存储用这个字段）


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getIsAudit() {
        return isAudit;
    }

    public void setIsAudit(String isAudit) {
        this.isAudit = isAudit;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getTiaoma() {
        return tiaoma;
    }

    public void setTiaoma(String tiaoma) {
        this.tiaoma = tiaoma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShebeilxid() {
        return shebeilxid;
    }

    public void setShebeilxid(String shebeilxid) {
        this.shebeilxid = shebeilxid;
    }

    public String getShebeilxmc() {
        return shebeilxmc;
    }

    public void setShebeilxmc(String shebeilxmc) {
        this.shebeilxmc = shebeilxmc;
    }

    public String getShebeiglyid() {
        return shebeiglyid;
    }

    public void setShebeiglyid(String shebeiglyid) {
        this.shebeiglyid = shebeiglyid;
    }

    public String getShebeiglymc() {
        return shebeiglymc;
    }

    public void setShebeiglymc(String shebeiglymc) {
        this.shebeiglymc = shebeiglymc;
    }

    public String getGudingzcbh() {
        return gudingzcbh;
    }

    public void setGudingzcbh(String gudingzcbh) {
        this.gudingzcbh = gudingzcbh;
    }

    public String getGongzuorlid() {
        return gongzuorlid;
    }

    public void setGongzuorlid(String gongzuorlid) {
        this.gongzuorlid = gongzuorlid;
    }

    public String getGongzuorlmc() {
        return gongzuorlmc;
    }

    public void setGongzuorlmc(String gongzuorlmc) {
        this.gongzuorlmc = gongzuorlmc;
    }

    public String getYuyuefw() {
        return yuyuefw;
    }

    public void setYuyuefw(String yuyuefw) {
        this.yuyuefw = yuyuefw;
    }

    public String getYuyuezdsc() {
        return yuyuezdsc;
    }

    public void setYuyuezdsc(String yuyuezdsc) {
        this.yuyuezdsc = yuyuezdsc;
    }

    public String getCunfanwzid() {
        return cunfanwzid;
    }

    public void setCunfanwzid(String cunfanwzid) {
        this.cunfanwzid = cunfanwzid;
    }

    public String getCunfanwzmc() {
        return cunfanwzmc;
    }

    public void setCunfanwzmc(String cunfanwzmc) {
        this.cunfanwzmc = cunfanwzmc;
    }

    public String getShebeixh() {
        return shebeixh;
    }

    public void setShebeixh(String shebeixh) {
        this.shebeixh = shebeixh;
    }

    public String getKetizid() {
        return ketizid;
    }

    public void setKetizid(String ketizid) {
        this.ketizid = ketizid;
    }

    public String getKetizmc() {
        return ketizmc;
    }

    public void setKetizmc(String ketizmc) {
        this.ketizmc = ketizmc;
    }

    public String getShebeiytsm() {
        return shebeiytsm;
    }

    public void setShebeiytsm(String shebeiytsm) {
        this.shebeiytsm = shebeiytsm;
    }

    public String getShebeidacfc() {
        return shebeidacfc;
    }

    public void setShebeidacfc(String shebeidacfc) {
        this.shebeidacfc = shebeidacfc;
    }

    public String getShebeifzrid() {
        return shebeifzrid;
    }

    public void setShebeifzrid(String shebeifzrid) {
        this.shebeifzrid = shebeifzrid;
    }

    public String getShebeifzrmc() {
        return shebeifzrmc;
    }

    public void setShebeifzrmc(String shebeifzrmc) {
        this.shebeifzrmc = shebeifzrmc;
    }

    public String getFilecode() {
        return filecode;
    }

    public void setFilecode(String filecode) {
        this.filecode = filecode;
    }

    public String getShoufeibz() {
        return shoufeibz;
    }

    public void setShoufeibz(String shoufeibz) {
        this.shoufeibz = shoufeibz;
    }

    public String getBaoyangyq() {
        return baoyangyq;
    }

    public void setBaoyangyq(String baoyangyq) {
        this.baoyangyq = baoyangyq;
    }

    public String getShebeiztdict() {
        return shebeiztdict;
    }

    public void setShebeiztdict(String shebeiztdict) {
        this.shebeiztdict = shebeiztdict;
    }

    public String getShebeishztdict() {
        return shebeishztdict;
    }

    public void setShebeishztdict(String shebeishztdict) {
        this.shebeishztdict = shebeishztdict;
    }

    public String getQijianhczq() {
        return qijianhczq;
    }

    public void setQijianhczq(String qijianhczq) {
        this.qijianhczq = qijianhczq;
    }

    public String getQijianhczqdw() {
        return qijianhczqdw;
    }

    public void setQijianhczqdw(String qijianhczqdw) {
        this.qijianhczqdw = qijianhczqdw;
    }

    public String getHechaff() {
        return hechaff;
    }

    public void setHechaff(String hechaff) {
        this.hechaff = hechaff;
    }

    public String getShoucihcrq() {
        return shoucihcrq;
    }

    public void setShoucihcrq(String shoucihcrq) {
        this.shoucihcrq = shoucihcrq;
    }

    public String getHechar() {
        return hechar;
    }

    public void setHechar(String hechar) {
        this.hechar = hechar;
    }

    public String getHechaxm() {
        return hechaxm;
    }

    public void setHechaxm(String hechaxm) {
        this.hechaxm = hechaxm;
    }

    public String getXiacihcrq() {
        return xiacihcrq;
    }

    public void setXiacihcrq(String xiacihcrq) {
        this.xiacihcrq = xiacihcrq;
    }

    public String getCankaowjdw() {
        return cankaowjdw;
    }

    public void setCankaowjdw(String cankaowjdw) {
        this.cankaowjdw = cankaowjdw;
    }

    public String getYouxiaorq() {
        return youxiaorq;
    }

    public void setYouxiaorq(String youxiaorq) {
        this.youxiaorq = youxiaorq;
    }

    public String getJiandingjzzq() {
        return jiandingjzzq;
    }

    public void setJiandingjzzq(String jiandingjzzq) {
        this.jiandingjzzq = jiandingjzzq;
    }

    public String getZhouqidw() {
        return zhouqidw;
    }

    public void setZhouqidw(String zhouqidw) {
        this.zhouqidw = zhouqidw;
    }

    public String getShoucijdjzrq() {
        return shoucijdjzrq;
    }

    public void setShoucijdjzrq(String shoucijdjzrq) {
        this.shoucijdjzrq = shoucijdjzrq;
    }

    public String getDingjianzq() {
        return dingjianzq;
    }

    public void setDingjianzq(String dingjianzq) {
        this.dingjianzq = dingjianzq;
    }

    public String getXianyongfw() {
        return xianyongfw;
    }

    public void setXianyongfw(String xianyongfw) {
        this.xianyongfw = xianyongfw;
    }

    public String getJiliangfzrid() {
        return jiliangfzrid;
    }

    public void setJiliangfzrid(String jiliangfzrid) {
        this.jiliangfzrid = jiliangfzrid;
    }

    public String getJiliangfzrmc() {
        return jiliangfzrmc;
    }

    public void setJiliangfzrmc(String jiliangfzrmc) {
        this.jiliangfzrmc = jiliangfzrmc;
    }

    public String getDaoqitqtxsj() {
        return daoqitqtxsj;
    }

    public void setDaoqitqtxsj(String daoqitqtxsj) {
        this.daoqitqtxsj = daoqitqtxsj;
    }

    public String getJiandingjzyq() {
        return jiandingjzyq;
    }

    public void setJiandingjzyq(String jiandingjzyq) {
        this.jiandingjzyq = jiandingjzyq;
    }

    public String getJiandingztdict() {
        return jiandingztdict;
    }

    public void setJiandingztdict(String jiandingztdict) {
        this.jiandingztdict = jiandingztdict;
    }

    public String getZhizaos() {
        return zhizaos;
    }

    public void setZhizaos(String zhizaos) {
        this.zhizaos = zhizaos;
    }

    public String getGongyignsid() {
        return gongyignsid;
    }

    public void setGongyignsid(String gongyignsid) {
        this.gongyignsid = gongyignsid;
    }

    public String getGongyignsmc() {
        return gongyignsmc;
    }

    public void setGongyignsmc(String gongyignsmc) {
        this.gongyignsmc = gongyignsmc;
    }

    public String getChuchangbh() {
        return chuchangbh;
    }

    public void setChuchangbh(String chuchangbh) {
        this.chuchangbh = chuchangbh;
    }

    public String getChuchangrq() {
        return chuchangrq;
    }

    public void setChuchangrq(String chuchangrq) {
        this.chuchangrq = chuchangrq;
    }

    public String getGouzhirq() {
        return gouzhirq;
    }

    public void setGouzhirq(String gouzhirq) {
        this.gouzhirq = gouzhirq;
    }

    public String getGouzhije() {
        return gouzhije;
    }

    public void setGouzhije(String gouzhije) {
        this.gouzhije = gouzhije;
    }

    public String getZijinly() {
        return zijinly;
    }

    public void setZijinly(String zijinly) {
        this.zijinly = zijinly;
    }

    public String getZhibaoq() {
        return zhibaoq;
    }

    public void setZhibaoq(String zhibaoq) {
        this.zhibaoq = zhibaoq;
    }

    public String getShiyongdwid() {
        return shiyongdwid;
    }

    public void setShiyongdwid(String shiyongdwid) {
        this.shiyongdwid = shiyongdwid;
    }

    public String getShiyongdwmc() {
        return shiyongdwmc;
    }

    public void setShiyongdwmc(String shiyongdwmc) {
        this.shiyongdwmc = shiyongdwmc;
    }

    public String getJiandingyid() {
        return jiandingyid;
    }

    public void setJiandingyid(String jiandingyid) {
        this.jiandingyid = jiandingyid;
    }

    public String getJiandingymc() {
        return jiandingymc;
    }

    public void setJiandingymc(String jiandingymc) {
        this.jiandingymc = jiandingymc;
    }

    public String getMeiriyykssj() {
        return meiriyykssj;
    }

    public void setMeiriyykssj(String meiriyykssj) {
        this.meiriyykssj = meiriyykssj;
    }

    public String getMeiriyyjssj() {
        return meiriyyjssj;
    }

    public void setMeiriyyjssj(String meiriyyjssj) {
        this.meiriyyjssj = meiriyyjssj;
    }

    public String getYuyuezxdw() {
        return yuyuezxdw;
    }

    public void setYuyuezxdw(String yuyuezxdw) {
        this.yuyuezxdw = yuyuezxdw;
    }

    public String getBukeyysj() {
        return bukeyysj;
    }

    public void setBukeyysj(String bukeyysj) {
        this.bukeyysj = bukeyysj;
    }

    public String getBukeyyjssj() {
        return bukeyyjssj;
    }

    public void setBukeyyjssj(String bukeyyjssj) {
        this.bukeyyjssj = bukeyyjssj;
    }

    public String getShebeizzid() {
        return shebeizzid;
    }

    public void setShebeizzid(String shebeizzid) {
        this.shebeizzid = shebeizzid;
    }

    public String getShebeizzmc() {
        return shebeizzmc;
    }

    public void setShebeizzmc(String shebeizzmc) {
        this.shebeizzmc = shebeizzmc;
    }

    public String getQijianhcdqtqtxsj() {
        return qijianhcdqtqtxsj;
    }

    public void setQijianhcdqtqtxsj(String qijianhcdqtqtxsj) {
        this.qijianhcdqtqtxsj = qijianhcdqtqtxsj;
    }

    public String getButtonType() {
        return buttonType;
    }

    public void setButtonType(String buttonType) {
        this.buttonType = buttonType;
    }

    public String getFlowtype() {
        return flowtype;
    }

    public void setFlowtype(String flowtype) {
        this.flowtype = flowtype;
    }

    public Boolean getShebeigly() {
        return isShebeigly;
    }

    public void setShebeigly(Boolean shebeigly) {
        isShebeigly = shebeigly;
    }

    public String getShebeixxbgsqid() {
        return shebeixxbgsqid;
    }

    public void setShebeixxbgsqid(String shebeixxbgsqid) {
        this.shebeixxbgsqid = shebeixxbgsqid;
    }

    public String getGaonanduyydj() {
        return gaonanduyydj;
    }

    public void setGaonanduyydj(String gaonanduyydj) {
        this.gaonanduyydj = gaonanduyydj;
    }

    public String getYuyuesjdatastr() {
        return yuyuesjdatastr;
    }

    public void setYuyuesjdatastr(String yuyuesjdatastr) {
        this.yuyuesjdatastr = yuyuesjdatastr;
    }

    public String getShouzhangzp() {
        return shouzhangzp;
    }

    public void setShouzhangzp(String shouzhangzp) {
        this.shouzhangzp = shouzhangzp;
    }

    public String getCanshu() {
        return canshu;
    }

    public void setCanshu(String canshu) {
        this.canshu = canshu;
    }

    public String getYuyuedj() {
        return yuyuedj;
    }

    public void setYuyuedj(String yuyuedj) {
        this.yuyuedj = yuyuedj;
    }

    public String getFormtype() {
        return formtype;
    }

    public void setFormtype(String formtype) {
        this.formtype = formtype;
    }

    public String getShifoudy() {
        return shifoudy;
    }

    public void setShifoudy(String shifoudy) {
        this.shifoudy = shifoudy;
    }

    public String getZhichiyylx() {
        return zhichiyylx;
    }

    public void setZhichiyylx(String zhichiyylx) {
        this.zhichiyylx = zhichiyylx;
    }
}
