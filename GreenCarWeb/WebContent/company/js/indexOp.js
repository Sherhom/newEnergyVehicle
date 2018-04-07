/**
 * 
 * @authors hoo
 * @date    2018-02-08 14:22:13
 * 变换frame内容使用changeContent函数
 */
"use strict";
(function(){

    const contentFrame = document.querySelector('#myContent');
    const mangagecarLi = document.querySelector('#sysManagecar');
    const maintainBatteryLi = document.querySelector('#maintainBattery');
    const carPosInfoLi  = document.querySelector("#carPosInfo");
    const carPathInfoLi = document.querySelector("#carPathInfo");
    const sysCatteamInfoLi = document.querySelector("#sysCatteamInfo");
    const driverEventManageLi = document.querySelector("#driverEventManage");
    const companyDriverInfoLi = document.querySelector("#companyDriverInfo");
    const carOpInfoLi = document.querySelector("#carOpInfo");
    const workRecordLi = document.querySelector("#workRecord");
    
    mangagecarLi.addEventListener('click',()=>{changeContent('/GreenCarWeb/company/SysmanageCarDemo.jsp','mangagecarLi')});
    maintainBatteryLi.addEventListener('click',()=>{changeContent('/GreenCarWeb/company/BatteryMaintain.jsp','maintainBattery')});
    carPosInfoLi.addEventListener('click',()=>{changeContent('/GreenCarWeb/company/carPosInfo.jsp','maintainBattery')});
    carPathInfoLi.addEventListener('click',()=>{changeContent('/GreenCarWeb/company/CarPathHistory.jsp','maintainBattery')});
    sysCatteamInfoLi.addEventListener('click',()=>{changeContent('/GreenCarWeb/company/carTeamInfo.jsp','maintainBattery')});
    driverEventManageLi.addEventListener('click',()=>{changeContent('/GreenCarWeb/company/driverEventManage.jsp','maintainBattery')});
    companyDriverInfoLi.addEventListener('click',()=>{changeContent('/GreenCarWeb/company/companyDriverInfo.jsp','maintainBattery')});
    carOpInfoLi.addEventListener('click',()=>{changeContent('/GreenCarWeb/company/carOpInfoNew.jsp','maintainBattery')});
    workRecordLi.addEventListener('click',()=>{changeContent('/GreenCarWeb/company/workRecord.jsp','maintainBattery')});
    
    /**
     * url 传入的要引用的html绝对地址
     */
    function changeContent(url,setActiveLi){
        contentFrame.src = url;

    }
})();