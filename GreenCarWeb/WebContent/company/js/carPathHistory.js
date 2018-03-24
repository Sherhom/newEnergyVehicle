/**
 * 
 */
"use strict";

$(document).ready(function() {
	//全局的motorcade,用于存储当前选择的是哪个车队
	//全局的carNumNow,用于存储当前选择的是哪个车辆
	var motorcadeNow = 1;
	var carNumNow;
	
	//生成车队的Tree begin
	var tree = {
			init: function(){ 
				$.get("/GreenCarWeb/car/initCarTeamDetailTree.action",
					function(result){
						$('#tree').treeview({
							data:result,
							onNodeSelected:function(event,node){
								refreshMotorcade(node.text);
							}
						});
					})
			}
		};
	tree.init();
	
});