    	function loadSelect(typeCode,eID,selectname,selectID){
    		//创建select对象，将name属性指定
    		var $select=$("<select name="+selectname+"></select>");
    		//添加选择项
    		$select.append($("<option value=''>---select---</option>"));
    		//使用ajax方法，访问后台Action
    		$.post(
    				"BaseDictAction",
    				{dictTypeCode:typeCode},
    				function(data){
    				    $.each(data,function(i,json){
    				    	//每次遍历都创建一个option对象，
    				    	var $option=$("<option value='"+json["dictId"]+"'>"+json["dictItemName"]+"</option>");
    				    	//回显
    				    	if(json["dictId"]==selectID){
    				    		$option.attr("selected","selected");
    				    	}
    				    	$select.append($option);
    				    	
    				    });
    				},"json");
    		$("#"+eID).append($select);
    	}