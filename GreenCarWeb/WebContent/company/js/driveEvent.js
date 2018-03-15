/**
 * 
 */
"use strict";
var num;
var $testTable;



// 删除
function delDriveEventInfo(carNum,times,maxSpeed,actualLoad,actualValue) {
	var titleTip = '提示';
	var event=$("#driveEvent").val();
    bootbox.confirm({
        title: titleTip,
        message: '确认删除？',
        callback: function(flag) {
            if (flag) {
                exchangeData("/GreenCarWeb/delDriveEventInfo.action",event,carNum,times,maxSpeed,actualLoad,actualValue);
            }
        }
    });
}


//用于修改服务器资源
function exchangeData(path,event,carNum,times,maxSpeed,actualLoad,actualValue) {
    $.ajax({
        url: path,
        type: 'post',
        data : {
        	event:event,
        	carNum:carNum,
        	times:times,
        	maxSpeed:maxSpeed,
        	actualLoad:actualLoad,
        	actualValue:actualValue
        },
        success: function(res) {
           /* bootbox.alert({
                title: titleTip,
                message: res.message
            });*/
            // 在每次提交操作后返回首页
            $testTable.bootstrapTable('selectPage', 1);
        }
    });
}




$(document).ready(function() {
	
	function queryParams(params) {

		return {
		//pageSize: params.limit,

		//pageNumber: params.pageNumber,
		
		limit : params.limit, //页面大小
		offset : params.offset, //从第几条开始的
	
		driveEvent:$("#driveEvent").val(),
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
	
	
	$testTable=$('#driveEventTable');
	//生成table begin
	let _demoTable = $testTable.bootstrapTable({
        sidePagination:'server',//设置为服务器端分页
        url: '/GreenCarWeb/driveEventManage.action',
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
			field : 'times',
			//width : '10%',
			title : '时间',
			align : 'center'
		}, {
			field : 'limitSpeed',
			//width : '10%',
			title : '限定值(超速)',
			align : 'center'
		}, {
			field : 'maxSpeed',
			//width : '10%',
			title : '最大值(超速)',
			align : 'center'
		}, {
			field : 'statusIdent',
			//width : '10%',
			title : '状态标识(超速)',
			align : 'center'
		}, {
			field : 'statusIdent',
			//width : '10%',
			title : '状态标识(超速)',
			align : 'center'
		}, {
			field : 'limitLoad',
			//width : '10%',
			title : '额定值(超载)',
			align : 'center'
		}, {
			field : 'actualLoad',
			//width : '10%',
			title : '实际值(超载)',
			align : 'center'
		}, {
			field : 'ident',
			//width : '10%',
			title : '状态标识(超载)',
			align : 'center'
		}, {
			field : 'collRank',
			//width : '10%',
			title : '碰撞等级(碰撞)',
			align : 'center'
		}, {
			field : 'limitValue',
			//width : '10%',
			title : '限定值(碰撞)',
			align : 'center'
		}, {
			field : 'actualValue',
			//width : '10%',
			title : '实际值(碰撞)',
			align : 'center'
		}, {
			field : 'collAngle',
			//width : '10%',
			title : '碰撞角度(碰撞)',
			align : 'center'
		},{
	        formatter: function (value, row, index) {
	            return [
	                
	                '<a href="javascript:delDriveEventInfo(' + "'" + row.carNum +"','" +row.times+ "','" + row.maxSpeed + "','" + row.actualLoad + "','" + row.actualValue + "'" +  ')">' +
	                    '<i class="glyphicon glyphicon-remove"></i>删除' +
	                '</a>'
	            ].join('');
	        },
	        title: '操作'
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