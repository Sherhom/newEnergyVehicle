/**
 * 
 */
"use strict";

$(document).ready(function() {
	let tableDemo = {
			init: function(){
				$('#batteryTable').bootstrapTable({
		        sidePagination:'server',//设置为服务器端分页
		        url: '/GreenCarWeb/car/sysgetCarinfo.action',
				method : 'post',
				queryParams : function(params) {
					var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
						limit : params.limit, //页面大小
						offset : params.offset, //页码
						motorcade : motorcadeNow
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
				idField : 'carNum',
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
					field : 'carBrand',
					width : '10%',
					title : '车辆品牌',
					align : 'center'
				}, {
					field : 'carryingCapacity',
					width : '10%',
					title : '承载能力',
					align : 'center'
				}, {
					field : 'operate',
					width : '10%',
					title : '操作',
					align : 'center',
					events : sysManageCarOp,
					formatter : function(value, row, index){
						return[
						'<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#sysModifyCar" >修改</button>' ,
						'<button type="button" id ="remove" class="btn btn-danger" >删除</button>'
						].join("");
					}
				} ],
				toolbar : '#toolbar'

			});
			}
	}
	
});