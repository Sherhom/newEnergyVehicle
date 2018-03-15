/**
 * 
 */
"use strict";


$(document).ready(function() {
	
	let isBindedNow = null;
	let batteryNumNow;
	//点击每行将车辆编号赋给全局变量carNumNow
	 $('#batteryTable').on('click-row.bs.table', function (e, row, $element) {
		 batteryNumNow = JSON.stringify(row.batteryNum);
    });
	// 设置bootbox中文
	bootbox.setLocale('zh_CN');
	
	//表格响应事件 begin
	
	//新增电池
	$("#batteryMaintainAddBatteryBtn").click(function(){
		let batteryNumVal =$("#batteryMaintainBatteryAddBatteryNum").val();
		let brandVal = $("#batteryMaintainBatteryAddBrand").val();
		let batteryVersionVal = $("#batteryMaintainBatteryAddVersion").val();
		$('#batteryMaintainAddBattery').modal('hide');
	    bootbox.confirm({
	        title: "提示",
	        message: '确认添加？',
	        callback: function (flag) {
	            if (flag) {	            
	            	$.get("/GreenCarWeb/battery/addBattery.action",
							{
								batteryNum:batteryNumVal,
								brand:brandVal,
								version:batteryVersionVal
							},
							function(msg){
								bootbox.alert({
					                title: '提示',
					                message: msg
					            });
							}
						);
	            }
	        }
	    });
	});
	
	 
	window.sysMatainBatteryOp = {
			
		    'click #batteryModify': function (e, value, row, index) {
		    	alert("modify");
		        modifyBattery(row);
		    },
			'click #batteryDel': function (e, value, row, index) {
				delBattery(row.batteryNum);
		    },
		    'click #batteryCorrelation': function (e, value, row, index) {
		    	attachBattery(row);
		    },
		    'click #batteryDetatch': function (e, value, row, index) {
		    	detachBattery(row.batteryNum);
		     }	
				
		};
	//修改电池信息
	function modifyBattery(row){
		$("#batteryMaintainBatteryBrand").val("");
		$("#batteryMaintainBatteryVersion").val("");
		$("#batteryMaintainModify").modal('show');
	}
	$('#batteryMaintainBtnSave').click(function() {
	    $('#batteryMaintainModify').modal('hide');
	    bootbox.confirm({
	        title: "提示",
	        message: '确认修改？',
	        callback: function (flag) {
	            if (flag) {
	            	let brandVal = $("#batteryMaintainBatteryBrand").val();
	        		let versionVal = $("#batteryMaintainBatteryVersion").val();
	            	$.get("/GreenCarWeb/battery/modifyBattery.action",
							{
								batteryNum:batteryNumNow,
								brand:brandVal,
								version:versionVal
							},
							function(msg){
								bootbox.alert({
					                title: '提示',
					                message: msg
					            });
							}
						);
	            }
	        }
	    });
	});
	
	//删除电池信息
	function delBattery(batteryNumVal){
		bootbox.confirm({
			title:"提示",
			message:"确认删除电池?",
			callback: function(flag){
				if(flag){
					$.get("/GreenCarWeb/battery/del.action",
							{
								batteryNum:batteryNumVal
							},
							function(msg){
								bootbox.alert({
					                title: '提示',
					                message: msg
					            });
							}
						);
				}
			}
		});
	}
	
	//添加电池关联
	function attachBattery(row){
		$("#batteryMaintainAttachCarNum").val("");
		$("#batteryMaintainAttach").modal('show');
	}
	$('#batteryMaintainBtnSaveAttach').click(function() {
	    $('#batteryMaintainAttach').modal('hide');
	    bootbox.confirm({
	        title: "提示",
	        message: '确认关联？',
	        callback: function (flag) {
	            if (flag) {
	            	let carNumVal = $("#batteryMaintainAttachCarNum").val();
	            	$.get("/GreenCarWeb/battery/attach.action",
							{
	            				batteryNum:batteryNumNow,
								carNum:carNumVal
							},
							function(msg){
								bootbox.alert({
					                title: '提示',
					                message: msg
					            });
							}
						);
	            }
	        }
	    });
	});
	//电池脱离关联
	function detachBattery(batteryNumVal){
		bootbox.confirm({
			title:"提示",
			message:"确认取消关联?",
			callback: function(flag){
				if(flag){
					$.get("/GreenCarWeb/battery/detach.action",
							{
								batteryNum:batteryNumVal
							},
							function(msg){
								bootbox.alert({
					                title: '提示',
					                message: msg
					            });
							}
						);
				}
			}
		});
	}
	
	
	//表格相应事件 end
	//生成表格 begin
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
	
	//生成表格end
});