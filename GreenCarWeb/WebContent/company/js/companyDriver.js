/**
 * 
 */
"use strict";
var num;
var $testTable;
function modifyDriverInfo(driverNum, motorcadeNum, carNum, driverName,driverSex,driverPhone,driverPosition) {
    num = driverNum;
    $('#modifyDriverNum').val(driverNum);
    $('#modifyMotorcadeNum').val( motorcadeNum);
    $('#modifyCarNum').val(carNum);
    $('#modifyDriverName').val(driverName);
    $('#modifyDriverSex').val(driverSex);
    $('#modifyDriverPhone').val(driverPhone);
    $('#modifyDriverPosition').val(driverPosition);
    $('#modifyModal').modal('show');
}

$('#saveModify').click(function() {
	var titleTip = '提示';
    $('#modifyModal').modal('hide');
    bootbox.confirm({
        title: titleTip,
        message: '确认修改？',
        callback: function (flag) {
        	//alert(flag);
            if (flag) {
            	var driverNum = $('#modifyDriverNum').val();
        	    var motorcadeNum = $('#modifyMotorcadeNum').val();
        	    var carNum = $('#modifyCarNum').val();
        	    var driverName = $('#modifyDriverName').val();
        	    var driverSex = $('#modifyDriverSex').val();
        	    var driverPhone = $('#modifyDriverPhone').val();
        	    var driverPosition = $('#modifyDriverPosition').val();
        	    $('#modifyModal').modal('show');
               
        	    exchangeData('/GreenCarWeb/modifyDriverInfo.action', driverNum, motorcadeNum, carNum, driverName,driverSex,driverPhone,driverPosition);
              
            }
        }
    });
});

// 删除
function delDriverInfo(driverNum) {
	var titleTip = '提示';
    bootbox.confirm({
        title: titleTip,
        message: '确认删除？',
        callback: function(flag) {
            if (flag) {
                exchangeData("/GreenCarWeb/delDriverInfo.action", driverNum);
            }
        }
    });
}


//新增
$('#addBtn').click(function() {
	    $('#addDriverNum').val('');
	    $('#addMotorcadeNum').val('');
	    $('#addCarNum').val('');
	    $('#addDriverName').val('');
	    $('#addDriverSex').val('');
	    $('#addDriverPhone').val('');
	    $('#addDriverPosition').val('');
    $('#addModal').modal('show');
});

$('#saveAdd').click(function() {
	var titleTip = '提示';
    $('#addModal').modal('hide');
    bootbox.confirm({
        title: titleTip,
        message: '确认增加？',
        callback: function (flag) {
            if (flag) {
            	var addDriverNum = $('#addDriverNum').val();
        	    var addMotorcadeNum = $('#addMotorcadeNum').val();
        	    var addCarNum = $('#addCarNum').val();
        	    var addDriverName = $('#addDriverName').val();
        	    var addDriverSex = $('#addDriverSex').val();
        	    var addDriverPhone = $('#addDriverPhone').val();
        	    var addDriverPosition = $('#addDriverPosition').val();
               
                exchangeData('/GreenCarWeb/addDriverInfo.action', addDriverNum,addMotorcadeNum,addCarNum, addDriverName,addDriverSex,addDriverPhone,addDriverPosition);
                
            }
        }
    });
});



//用于修改服务器资源
function exchangeData(path, driverNum, motorcadeNum, carNum, driverName,driverSex,driverPhone,driverPosition) {
    $.ajax({
        url: path,
        type: 'post',
        data : {
        	driverNum: driverNum, 
        	motorcadeNum: motorcadeNum,
        	carNum: carNum,
        	driverName: driverName,
        	driverSex: driverSex,
        	driverPhone: driverPhone,
        	driverPosition: driverPosition
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
		teamNum:$("#teamNum").val(),
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
	
	
	$testTable=$('#driverInfoTable');
	//生成table begin
	let _demoTable = $testTable.bootstrapTable({
        sidePagination:'server',//设置为服务器端分页
        url: '/GreenCarWeb/getDriverInfo.action',
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
			field : 'driverNum',
			width : '10%',
			title : '驾驶员编号',
			align : 'center'
		}, {
			field : 'motorcadeNum',
			width : '10%',
			title : '车队编号',
			align : 'center'
		}, {
			field : 'carNum',
			width : '10%',
			title : '车辆编号',
			align : 'center'
		}, {
			field : 'driverName',
			width : '10%',
			title : '驾驶员姓名',
			align : 'center',
			
		}, {
			field : 'driverSex',
			width : '10%',
			title : '驾驶员性别',
			align : 'center'
		}, {
			field : 'driverPhone',
			width : '10%',
			title : '驾驶员电话',
			align : 'center'
		}, {
			field : 'driverPosition',
			width : '10%',
			title : '驾驶员职位',
			align : 'center'
		}, {
	        formatter: function (value, row, index) {
	            return [
	                '<a href="javascript:modifyDriverInfo(' + row.driverNum + ",'" + row.motorcadeNum + "','" + row.carNum + "','" + row.driverName + "'," + row.driverSex + ",'" + row.driverPhone + "','" + row.driverPosition + "'" + ')">' +
	                    '<i class="glyphicon glyphicon-pencil"></i>修改' +
	                '</a>',
	                '<a href="javascript:delDriverInfo(' + row.driverNum + ')">' +
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