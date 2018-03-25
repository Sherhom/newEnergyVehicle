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
	    $('#addMotorcadeNum').val('');
	    $('#addCaptainNum').val('');
	    $('#addMotorcadeMount').val('');
	   
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
            	var addMotorcadeNum=$('#addMotorcadeNum').val();
        	    var addCaptainNum=$('#addCaptainNum').val();
        	    var addMotorcadeMount=$('#addMotorcadeMount').val();
               
                exchangeData('/GreenCarWeb/addCarTeamInfo.action',addMotorcadeNum,addCaptainNum,addMotorcadeMount);
                
            }
        }
    });
});



//用于修改服务器资源
function exchangeData(path,addMotorcadeNum,addCaptainNum,addMotorcadeMount) {
    $.ajax({
        url: path,
        type: 'post',
        data : {
        	motorcadeNum:addMotorcadeNum,
        	captainNum:addCaptainNum,
        	motorcadeMount:addMotorcadeMount
        	
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
	
	
	$testTable=$('#carTeamInfoTable');
	//生成table begin
	let _demoTable = $testTable.bootstrapTable({
        sidePagination:'server',//设置为服务器端分页
        url: '/GreenCarWeb/getCarTeamInfo.action',
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
			//width : '10%',
			checkbox : true
		}, {
			field : 'motorcadeNum',
			//width : '10%',
			title : '车队号',
			align : 'center'
		},  {
			field : 'motorcadeMount',
			//width : '10%',
			title : '车队人数',
			align : 'center'
		},{
			field : 'captainNum',
			//width : '10%',
			title : '队长编号',
			align : 'center'
		}, {
			field : 'driverName',
			//width : '10%',
			title : '队长姓名',
			align : 'center'
		}, {
			field : 'driverPhone',
			//width : '10%',
			title : '队长手机号',
			align : 'center',
			
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