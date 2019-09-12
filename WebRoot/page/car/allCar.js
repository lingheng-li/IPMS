layui.config({
	base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
	var form = layui.form(),
		layer = parent.layer === undefined ? layui.layer : parent.layer,
		laypage = layui.laypage,
		$ = layui.jquery;

	//加载页面数据
	var carData = '';
	$.get("../../RecordAction_CarInList", function(data){
		carData = data;
		if(carData==null){
			window.location.href="../../UserAction_logout";
		}
		if(window.sessionStorage.getItem("addUser")){
			var addUser = window.sessionStorage.getItem("addUser");
			carData = JSON.parse(addUser).concat(carData);
		}
		//执行加载数据的方法
		usersList();
	})

	//查询
	$(".search_btn").click(function(){
		var userArray = [];
		if($(".search_input").val() != ''){
			var index = layer.msg('查询中，请稍候',{icon: 16,time:false,shade:0.8});
            setTimeout(function(){
            	$.ajax({
					url : "../../RecordAction_CarInList",
					type : "get",
					dataType : "json",
					success : function(data){
						if(window.sessionStorage.getItem("addUser")){
							var addUser = window.sessionStorage.getItem("addUser");
							carData = JSON.parse(addUser).concat(data);
						}else{
							carData = data;
						}
						for(var i=0;i<carData.length;i++){
							var usersStr = carData[i];
							var selectStr = $(".search_input").val();
		            		function changeStr(data){
		            			var dataStr = '';
		            			var showNum = data.split(eval("/"+selectStr+"/ig")).length - 1;
		            			if(showNum > 1){
									for (var j=0;j<showNum;j++) {
		            					dataStr += data.split(eval("/"+selectStr+"/ig"))[j] + "<i style='color:#03c339;font-weight:bold;'>" + selectStr + "</i>";
		            				}
		            				dataStr += data.split(eval("/"+selectStr+"/ig"))[showNum];
		            				return dataStr;
		            			}else{
		            				dataStr = data.split(eval("/"+selectStr+"/ig"))[0] + "<i style='color:#03c339;font-weight:bold;'>" + selectStr + "</i>" + data.split(eval("/"+selectStr+"/ig"))[1];
		            				return dataStr;
		            			}
		            		}
		            		//车牌号
		            		if(usersStr.carId.indexOf(selectStr) > -1){
			            		usersStr["carId"] = changeStr(usersStr.carId);
		            		}
		            		if(usersStr.userId.username.indexOf(selectStr) > -1){
			            		usersStr["userId"]["username"] = changeStr(usersStr.userId.username);
		            		}
		            		if(usersStr.carId.indexOf(selectStr)>-1||usersStr.userId.username.indexOf(selectStr) > -1){
		            			userArray.push(usersStr);
		            		}
		            	}
		            	carData = userArray;
		            	usersList(carData);
					}
				})
                layer.close(index);
            },100);
		}else{
			layer.msg("请输入需要查询的内容");
		}
	})

	//添加车辆
	$(".usersAdd_btn").click(function(){
		var index = layui.layer.open({
			title : "车辆进入",
			type : 2,
			content : "addcar.jsp",
			success : function(layero, index){
				setTimeout(function(){
					layui.layer.tips('点击此处返回会员列表', '.layui-layer-setwin .layui-layer-close', {
						tips: 3
					});
				},500)
			}
		})
		//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
		$(window).resize(function(){
			layui.layer.full(index);
		})
		layui.layer.full(index);
	})

	//显示全部
	$(".showAll").click(function(){
		$.get("../../RecordAction_CarInList", function(data){
			carData = data;
			if(window.sessionStorage.getItem("addUser")){
				var addUser = window.sessionStorage.getItem("addUser");
				carData = JSON.parse(addUser).concat(carData);
			}
			//执行加载数据的方法
			usersList();
		})
	});
	
    //全选
	form.on('checkbox(allChoose)', function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		child.each(function(index, item){
			item.checked = data.elem.checked;
		});
		form.render('checkbox');
	});

	//通过判断文章是否全部选中来确定全选按钮是否选中
	form.on("checkbox(choose)",function(data){
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
		var childChecked = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"]):checked')
		if(childChecked.length == child.length){
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = true;
		}else{
			$(data.elem).parents('table').find('thead input#allChoose').get(0).checked = false;
		}
		form.render('checkbox');
	})

	//结算
	$("body").on("click",".users_edit",function(){  
		var _this = $(this);
		var id = _this.attr('data-id');
		var index = layui.layer.open({
			title : "停车结算",
			type : 2,
			content : "../../RecordAction_CarOut?Id="+id,
			success : function(layero, index){
				setTimeout(function(){
					layui.layer.tips('点击此处返回会员列表', '.layui-layer-setwin .layui-layer-close', {
						tips: 3
					});
				},500)
			}
		})
		//改变窗口大小时，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
		$(window).resize(function(){
			layui.layer.full(index);
		})
		layui.layer.full(index);
		
	})

	function usersList(){
		//渲染数据
		function renderDate(data,curr){
			var dataHtml = '';
			currData = carData.concat().splice(curr*nums-nums, nums);
			if(currData.length != 0){
				for(var i=0;i<currData.length;i++){
					var minutes;
					var seconds;
					if (currData[i].entertime.minutes<10) {
						minutes = "0"+currData[i].entertime.minutes;
					}else{
						minutes = currData[i].entertime.minutes;
					}
					if (currData[i].entertime.seconds<10) {
						seconds = "0"+currData[i].entertime.seconds;
					}else{
						seconds = currData[i].entertime.seconds;
					}
					var time = (currData[i].entertime.year+1900)+"-"
					+(currData[i].entertime.month+1)+"-"
			    	+(currData[i].entertime.date)+" "
			    	+(currData[i].entertime.hours)+":"
			    	+minutes+":"
			    	+seconds;
					dataHtml += '<tr>'
			    	+  '<td><input type="checkbox" name="checked" lay-skin="primary" lay-filter="choose"></td>'
			    	+  '<td>'+currData[i].carId+'</td>'
			    	+  '<td>'+time+'</td>'
			    	+  '<td>'+currData[i].userId.username+'</td>'
			    	+  '<td>'
					+    '<a class="layui-btn layui-btn-danger layui-btn-mini users_edit" data-id="'+data[i].id+'"><i class="iconfont icon-edit"></i> 结算</a>'
			        +  '</td>'
			    	+'</tr>';
				}
			}else{
				dataHtml = '<tr><td colspan="5">暂无数据</td></tr>';
			}
		    return dataHtml;
		}

		//分页
		var nums = 8; //每页出现的数据量
		laypage({
			cont : "page",
			pages : Math.ceil(carData.length/nums),
			jump : function(obj){
				$(".users_content").html(renderDate(carData,obj.curr));
				$('.users_list thead input[type="checkbox"]').prop("checked",false);
		    	form.render();
			}
		})
	}
        
})