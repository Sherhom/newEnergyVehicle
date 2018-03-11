/**
 * 
 */
"use strict";
$(document).ready(function() {
	//生成车队的Tree begin
	/*var tree = {
			init: $.get("/GreenCarWeb/car/initCarTeamTree.action",
					function(result){
						$('#tree').treeview({
							data:result,
							onNodeSelected:function(event){
								alert(event.target);
							},
							onNodeUnchecked:function(event,data){
								alert(event);
							} 
						});
					})
		};
	tree.init;*/
	//生成车队的Tree end
	
	//绑定修改车辆信息事件
	/*$("#sys-carteam-mofify-btnsave").on('click',modifyCar);
	
	function createModifyBtn(){
		return [
			'<button type="button" class="btn btn-primary" id="modify" data-toggle="modal" data-target="#sysModifyCar" >修改</button>'
		]
	}
	
	function modifyCar(){
		let carryingCapacityVal = $("#sys-carteam-mofify-carryingCapacity").val();
		let carBrandVal = $("#sys-carteam-mofify-carBrand").val();
		alert('getsections' + JSON.stringify($('#demoTable').bootstrapTable('getSelections')));
		$.get("/GreenCarWeb/car/modifyCarInfo.action",
				{
					carryingCapacity:carryingCapacityVal,
					carBrand:carBrandVal
				},
				function(data){
					alert(data);
				}
			);
		
	}
	
	//为修改按钮绑定事件 end
	function operateEvents(){
	};*/
	function queryParams(params) {

		return {
		//pageSize: params.limit,

		//pageNumber: params.pageNumber,
		
		limit : params.limit, //页面大小
		offset : params.offset, //从第几条开始的
		carKeyword:$("#carKeyword").val(),
		carTeamKeyword:$("#carTeamKeyword").val()
		

		};

	}
	
	function responseHandler(res) { 
	    if (res) {
	        return {
	            "rows" : res.rows,
	            "total" : res.total
	        };
	    } else {
	        return {
	            "rows" : [],
	            "total" : 0
	        };
	    }
	}
	
	//生成table begin
	let _demoTable = $('#tableCarOpInfo').bootstrapTable({
        sidePagination:'server',//设置为服务器端分页
        url: '/GreenCarWeb/getOpInfo.action',
		method : 'post',
		queryParams :queryParams,
		responseHandler: responseHandler,
		contentType : 'application/x-www-form-urlencoded;charset=utf-8',
		striped : true,
		clickToSelect : true,
		pagenumber : 1,
		pageSize :5,
		pagination : true,
		pageList : [ 10, 30, 50 ],
		showToggle : true,
		showRefresh : true,
		
		sortable : true,
		idField : 'id',
		columns : [ {
			field : 'state',
			width : '10%',
			checkbox : true
		}, {
			field : 'carNum',
			width : '10%',
			title : '车辆编号',
			align : 'center'
		}, {
			field : 'motorcadeNum',
			width : '10%',
			title : '车队号',
			align : 'center'
		}, {
			field : 'driverName',
			width : '10%',
			title : '司机姓名',
			align : 'center'
		}, {
			field : 'carBrand',
			width : '10%',
			title : '车辆品牌',
			align : 'center',
			
		}, {
			field : 'carryingCapacity',
			width : '10%',
			title : '承载能力',
			align : 'center'
		}, {
			field : 'dataManu',
			width : '10%',
			title : '出厂日期',
			align : 'center'
		}, {
			field : 'batteryNum',
			width : '10%',
			title : '电池编号',
			align : 'center'
		}, {
			field : 'times',
			width : '10%',
			title : '保养时间',
			align : 'center'
		}, {
			field : 'totalMile',
			width : '10%',
			title : '行驶里程',
			align : 'center'
		} ],
		toolbar : '#toolbar'

	});
	//生成table end
	
});