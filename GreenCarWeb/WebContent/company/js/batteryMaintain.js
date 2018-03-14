/**
 * 
 */
"use strict";
//生成表格 begin



$(document).ready(function() {
	let isBindedNow = null;
	window.sysMatainBatteryOp = {
			
		    'click #batteryModify': function (e, value, row, index) {
		        alert("modify");
		    },
			'click #batteryDel': function (e, value, row, index) {
				alert("batteryDel");
		    },
		    'click #batteryCorrelation': function (e, value, row, index) {
		        alert("batteryCorrelation");
		    },
		    'click #batteryDetatch': function (e, value, row, index) {
		        alert("batteryDetatch");
		     }	
				
		};
	let tableBattery = {
			init: function(){
				$('#batteryTable').bootstrapTable({
		        sidePagination:'server',//设置为服务器端分页
		        url: '/GreenCarWeb/battery/initTable.action',
				method : 'post',
				queryParams : function(params) {
					var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
						limit : params.limit, //页面大小
						offset : params.offset, //页码
						isBinded : isBindedNow
					};
					return temp;
				},
				contentType : 'application/x-www-form-urlencoded;charset=utf-8',
				striped : true,
				clickToSelect : false,
				pagenumber : 1,
				pageSize : 5,
				pagination : true,
				pageList : [ 10, 30, 50 ],
				showToggle : true,
				showRefresh : true,

				sortable : true,
				idField : 'batteryNum',
				columns : [ {
					field : 'state',
					width : '10%',
					checkbox : true
				}, {
					field : 'batteryNum',
					width : '10%',
					title : '电池编号',
					align : 'center'
				}, {
					field : 'isCorrelated',
					width : '10%',
					title : '车辆关联',
					align : 'center'
				}, {
					field : 'carNum',
					width : '10%',
					title : '车辆编号',
					align : 'center'
				}, {
					field : 'batteryBrand',
					width : '10%',
					title : '电池品牌',
					align : 'center'
				}, {
					field : 'batteryVersion',
					width : '10%',
					title : '电池型号',
					align : 'center'
				}, {
					field : 'operateBattery',
					width : '10%',
					title : '电池操作',
					align : 'center',
					events : sysMatainBatteryOp,
					formatter : function(value, row, index){
						return[
						'<button type="button" id="batteryModify" class="btn btn-primary" data-toggle="modal" data-target="#sysModifyCar" >修改信息</button>' ,
						'<button type="button" id ="batteryDel" class="btn btn-danger" >删除电池</button>'
						].join("");
					}
				},{
					field : 'operateCar',
					width : '10%',
					title : '车辆操作',
					align : 'center',
					events : sysMatainBatteryOp,
					formatter : function(value, row, index){
						return[
						'<button type="button"  class="btn btn-primary" id="batteryCorrelation" > 关联电池</button>',
						'<button type="button" class="btn btn-danger" id="batteryDetatch" > 脱离关联</button>'
						].join("");
					}
					
				} ],
				toolbar : '#toolbar'

			});}
	}
	
	tableBattery.init();
	
});