package com.es.entity;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.util.Date;

@Document(indexName = "github",type = "shebei")
@Data
public class Shebei implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;

    protected String remarks;	// 备注
    protected Date createDate;	// 创建日期
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
}
