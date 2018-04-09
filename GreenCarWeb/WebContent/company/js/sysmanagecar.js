/**
 * 
 */
"use strict";

$(document).ready(function() {
	// 设置bootbox中文
	bootbox.setLocale('zh_CN');
	//全局的motorcade,用于存储当前选择的是哪个车队
	//全局的carNumNow,用于存储当前选择的是哪个车辆
	var motorcadeNow = 1;
	var carNumNow;
	
	//生成车队的Tree begin
	var tree = {
			init: function(){ 
				$.get("/GreenCarWeb/car/initCarTeamTree.action",
					function(result){
						$('#tree').treeview({
							data:result,
							onNodeSelected:function(event,node){
								refreshMotorcade(node.text);
							}
						});
					})
					$('#demoTable').bootstrapTable('selectPage', 1);
			}
		};
	tree.init();
		//用于点击车队,重绘table内容
	function refreshMotorcade(nodeText){
		nodeText = nodeText +"";
		var  regx = new RegExp("\\d+");
		var num = nodeText.match(regx);
		motorcadeNow = parseInt(num);
		$("#demoTable").bootstrapTable('destroy');
		tableDemo.init();
	}
	//生成车队的Tree end
	
	
	//点击每行将车辆编号赋给全局变量carNumNow
	 $('#demoTable').on('click-row.bs.table', function (e, row, $element) {
         carNumNow = JSON.stringify(row.carNum);
     });
	 
	 //绑定模态框响应函数
	$("#sys-carteam-mofify-btnsave").on('click',modifyCar);
	
	
		
	//生成table begin
	
	//为table中的id为remove的按钮添加响应事件
	window.sysManageCarOp = {
			
		    'click #remove': function (e, value, row, index) {
		        delCar(row.carNum);
		    }
	};
	$("#btnAddCarSave").on('click',addCar);
	//删除车辆信息
	function delCar(carNumVal){
		bootbox.confirm({
			title:"提示",
			message:"确认删除?",
			callback: function(flag){
				if(flag){
					$.get("/GreenCarWeb/car/delCar.action",
							{
								carNum:carNumVal
							},
							function(msg){
								bootbox.alert({
					                title: '提示',
					                message: msg
					            });
							}
						);
					$('#demoTable').bootstrapTable('selectPage', 1);
				}
			}
		});

	}
	//表格修改车辆信息
	function modifyCar(){
		$('#sysModifyCar').modal('hide');
		bootbox.confirm({
			title:"提示",
			message:"确认修改?",
			callback: function(flag){
				if(flag){
					let carryingCapacityVal = $("#sys-carteam-mofify-carryingCapacity").val();
					let carBrandVal = $("#sys-carteam-mofify-carBrand").val();
					let carNumVal = carNumNow;
					$.get("/GreenCarWeb/car/modifyCarInfo.action",
							{
								carNum:carNumVal,
								carryingCapacity:carryingCapacityVal,
								carBrand:carBrandVal
							},
							function(msg){
								bootbox.alert({
					                title: '提示',
					                message: msg
					            });
							}
						);
					$('#demoTable').bootstrapTable('selectPage', 1);
					
				}
			}
		});
	}
	//为车队添加车辆
	function addCar(){
		$('#sysAddCar').modal('hide');
		bootbox.confirm({
			title:"提示",
			message:"确认添加?",
			callback: function(flag){
				if(flag){
					let carNumVal = $('#sysAddCarNum').val();
					$.get("/GreenCarWeb/car/addCar.action",
							{
								carNum:carNumVal,
								carTeamNum:motorcadeNow
							},
							function(msg){
								bootbox.alert({
					                title: '提示',
					                message: msg
					            });
							}
						);
					$('#demoTable').bootstrapTable('selectPage', 1);
					
				}
			}
		});
	}
	
	let tableDemo = {
			init: function(){
				$('#demoTable').bootstrapTable({
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
	
	tableDemo.init();
	//生成table end
	
});