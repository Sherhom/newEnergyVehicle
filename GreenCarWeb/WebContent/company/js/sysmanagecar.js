/**
 * 
 */
"use strict";
$(document).ready(function() {
	//生成车队的Tree begin
	var tree = {
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
	tree.init;
	//生成车队的Tree end
	
	//绑定修改车辆信息事件
	$("#sys-carteam-mofify-btnsave").on('click',modifyCar);
	
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
	};
	
	
	
	//生成table begin
	let _demoTable = $('#demoTable').bootstrapTable({
        sidePagination:'server',//设置为服务器端分页
        url: '/GreenCarWeb/car/sysgetCarinfo.action',
		method : 'post',
		queryParams : function(params) {
			var temp = { //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
				limit : params.limit, //页面大小
				offset : params.offset, //页码
				motorcade : 1
			};
			return temp;
		},
		contentType : 'application/x-www-form-urlencoded;charset=utf-8',
		striped : true,
		clickToSelect : true,
		pagenumber : 1,
		pageSize : 5,
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
			events : operateEvents,
			formatter : createModifyBtn
		} ],
		toolbar : '#toolbar'

	});
	//生成table end
	
});