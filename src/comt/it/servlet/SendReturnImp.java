package comt.it.servlet;



import net.sf.json.JSONObject;


/**
 * @author wuyz:
 * @version 创建时间：2015年11月18日 下午2:41:00
 */

public class SendReturnImp implements SendReturnService{

	@Override
	public String SetHeaderAndReturn(String returnstr) {
		String code="";
		String msg="";
		if  (returnstr.equals("0001"))
		{
			 code="0001";  //没有更多数据
			 msg="暂无更多数据！";
		}				
		else {
			code="0000";
			msg="请求处理完成！";  //处理正常	
		}	
				    
//	    JSONObject status = new JSONObject();
		org.json.JSONObject status = new org.json.JSONObject();
	    status.put("errorCode", code);
	    status.put("errorMsg", msg);
	    
//	    JSONObject returnObj = new JSONObject();
	    org.json.JSONObject returnObj = new org.json.JSONObject();
	    returnObj.put("status", status);
	    returnObj.put("bizObj", returnstr);
	        
	return returnObj.toString();
	}

	@Override
	public String SetHeaderAndReturn(String returnstr,int errorCount) {
		String code="";
		String msg="";
		if  (returnstr.equals("0001"))
		{
			 code="0001";  //没有更多数据
			 msg="暂无更多数据！";
		}
		else 
		{
			code="0000";
			msg="请求处理完成！";  //处理正常	
		}
			    
	    JSONObject status = new JSONObject();
	    status.put("errorCode", code);
	    status.put("errorMsg", msg);
	    
	    JSONObject returnObj = new JSONObject();
	    returnObj.put("status", status);
	    returnObj.put("bizObj", returnstr);	        
	    return returnObj.toString();
	    
	}

	@Override
	public String SetHeaderAndReturnWithPageInfo(String returnstr,int currentPage,int pageSize,int totalItems,int totalPages) {
		String code="";
		String msg="";
		if  (returnstr.equals("0001"))
		{
			 code="0001";  //没有更多数据
			 msg="暂无更多数据！";
		}
		else
		{
			code="0000";
			msg="请求处理完成！";  //处理正常	
		}
			    
	    JSONObject status = new JSONObject();
	    status.put("errorCode", code);
	    status.put("errorMsg", msg);
	    
	    JSONObject returnObj = new JSONObject();
	    returnObj.put("status", status);
	    
	    String res="{\"pageInfo\":{\"currentPage\":"+currentPage+",\"pageSize\":"+pageSize+",\"totalItems\":"+totalItems+",\"total_pages\":"+totalPages+"}, \"list\":\""+returnstr+"\"}";
	    
	    returnObj.put("bizObj", res);
	        
	return returnObj.toString();
	}

	@Override
	public String SetReturnInfo(String returnstr,String remap) {
		String code="";
		String msg="";
		if  (returnstr.equals("0001"))
		{
			 code="0001";  //没有更多数据
			 msg="暂无更多数据！";
		}
		else 
		{
			code="0000";
			msg="请求处理完成！";  //处理正常	
		}
		
			    
	    JSONObject status = new JSONObject();
	    status.put("errorCode", code);
	    status.put("errorMsg", msg);
	    
	    JSONObject returnObj = new JSONObject();
	    returnObj.put("status", status);
	    returnObj.put("bizObj", returnstr);
	        
	return returnObj.toString();
	}

}
