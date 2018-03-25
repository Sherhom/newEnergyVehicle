/**
 * 
 */
"use strict";
var num;
var $testTable;



$(document).ready(function() {
	
	function queryParams(params) {

		return {
		//pageSize: params.limit,

		//pageNumber: params.pageNumber,
		
		limit : params.limit, //页面大小
		offset : params.offset, //从第几条开始的
	
		startDate:$("#startDate").val(),
		endDate:$("#endDate").val(),
		keyword:$("#keyword").val()
		
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
	
	
	$testTable=$('#workRecordTable');
	//生成table begin
	let _demoTable = $testTable.bootstrapTable({
        sidePagination:'server',//设置为服务器端分页
        url: '/GreenCarWeb/workRecord.action',
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
			//width : '10%',
			title : '车辆编号',
			align : 'center'
		}, {
			field : 'driverNum',
			//width : '10%',
			title : '驾驶员工号',
			align : 'center'
		}, {
			field : 'driverName',
			//width : '10%',
			title : '驾驶员名称',
			align : 'center'
		}, {
			field : 'commitTime',
			//width : '10%',
			title : '开始时间',
			align : 'center'
		}, {
			field : 'endTime',
			//width : '10%',
			title : '结束时间',
			align : 'center'
		}, {
			field : 'workDuration',
			//width : '10%',
			title : '工作时长',
			align : 'center'
		}, {
			field : 'workMileage',
			//width : '10%',
			title : '工作里程',
			align : 'center'
		}, {
			field : 'taskDes',
			//width : '10%',
			title : '作业描述',
			align : 'center'
		}, {
			field : 'moveDuration',
			//width : '10%',
			title : '移动时长',
			align : 'center'
		}],
		toolbar : '#toolbar'

	});
	//生成table end
	// 设置bootbox中文
	bootbox.setLocale('zh_CN');

	
	
	
	// 点击查询按钮，年龄符合查询条件方可跳转查询
	

	// 点击重置按钮，清空查询条件并跳转回第一页
	
	

	

	// 修改
	

	
});