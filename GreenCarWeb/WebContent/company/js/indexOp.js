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
    mangagecarLi.addEventListener('click',()=>{changeContent('/GreenCarWeb/company/SysmanageCarDemo.jsp','mangagecarLi')});
    maintainBatteryLi.addEventListener('click',()=>{changeContent('/GreenCarWeb/company/BatteryMaintain.jsp','maintainBattery')});

    /**
     * url 传入的要引用的html绝对地址
     */
    function changeContent(url,setActiveLi){
        contentFrame.src = url;

    }
})();