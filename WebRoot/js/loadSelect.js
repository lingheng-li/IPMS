    	function loadSelect(typeCode,eID,selectname,selectID){
    		//����select���󣬽�name����ָ��
    		var $select=$("<select name="+selectname+"></select>");
    		//���ѡ����
    		$select.append($("<option value=''>---select---</option>"));
    		//ʹ��ajax���������ʺ�̨Action
    		$.post(
    				"BaseDictAction",
    				{dictTypeCode:typeCode},
    				function(data){
    				    $.each(data,function(i,json){
    				    	//ÿ�α���������һ��option����
    				    	var $option=$("<option value='"+json["dictId"]+"'>"+json["dictItemName"]+"</option>");
    				    	//����
    				    	if(json["dictId"]==selectID){
    				    		$option.attr("selected","selected");
    				    	}
    				    	$select.append($option);
    				    	
    				    });
    				},"json");
    		$("#"+eID).append($select);
    	}