package comt.it.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import utils.Check;
import utils.DateUtils;
import utils.WSUtil;


public class BingoServlet extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public BingoServlet() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String res = "";
		String req = "";
		String command = "";
		long dt1=System.currentTimeMillis();
		BufferedReader br = new BufferedReader(
				new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
		try {
			/* 读取数据 */
			StringBuffer sb = new StringBuffer("");
			String temp;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			br.close();
			req = sb.toString();
			WSUtil.PrintDebug("Time:"+DateUtils.getNow()+"||"+Thread.currentThread().getName()+" `请求报文:" + req);
			
			if(Check.isJson(req) == false){
				res = " {\"status\":{\"errorCode\":\"9999\",\"errorMsg\":\"无数据\"},\"bizObj\":\"\"}";
			}else{
			String head = "";
			String params = "";
			
//			String check = "";

//			JSONObject reqObj = JSONObject.fromObject(req);
			org.json.JSONObject reqObj = new org.json.JSONObject(req);
			head = reqObj.get("head").toString();
			command = reqObj.get("command").toString();
			params = reqObj.get("params").toString();
//			check = reqObj.get("check").toString();

			String name = "";
			String phoneNum = "";
			String businessType = "";
			org.json.JSONObject jb = new org.json.JSONObject(head);
//			JSONObject jb = JSONObject.fromObject(head);
			name = jb.get("name").toString();
			phoneNum = jb.get("phoneNum").toString();
			businessType = jb.get("businessType").toString();
			
			/**
			 * 校验用户是否存在
			 */
			int ret = Check.userCheck(name, phoneNum);
			
		
			if(ret == 1){//校验成功
				
				ServletAbstractHandler sat=null;
				if(businessType.equals("BingoHanderImp")){
					sat=new BingoHanderImp();
				}
				if(businessType.equals("PublicHandlerImp")){
					sat=new PublicHandlerImp();
				}
				 res=sat.getClass().getMethod(command,String.class, String.class,String.class).invoke(sat,head,params,getRemoteAddress(request)).toString();
			}else{
				res = " {\"status\":{\"errorCode\":\"9999\",\"errorMsg\":\"用户不存在\"},\"bizObj\":\"\"}";
			}	
			
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			/* 返回数据 */
			long dt2=System.currentTimeMillis();
            long dt3=dt2-dt1;      
//            JSONObject job = JSONObject.fromObject(res);
            org.json.JSONObject job;
			try {
				job = new org.json.JSONObject(res);
				String errorcode = new org.json.JSONObject(job.get("status").toString()).get("errorCode").toString();
			
//    		String errorcode = JSONObject.fromObject(job.get("status").toString()).get("errorCode").toString();
    		if(!"0000".equalsIgnoreCase(errorcode)){
    			WSUtil.PrintDebug(Thread.currentThread().getName()+"||接口{"+command+"}处理时间{"+dt3+"毫秒}返回报文:" + res);
    		}else{
    			WSUtil.PrintDebug(Thread.currentThread().getName()+"||接口{"+command+"}处理时间{"+dt3+"毫秒}处理成功0000" + res);
    		}    		
			PrintWriter pw = response.getWriter();
			pw.write(res);
			pw.flush();
			pw.close();
			br.close();
			} catch (ParseException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	public String getRemoteAddress(HttpServletRequest request) {  
	        String ip = request.getHeader("x-forwarded-for");  
	        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	            ip = request.getHeader("Proxy-Client-IP");  
	        }  
	        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	            ip = request.getHeader("WL-Proxy-Client-IP");  
	        }  
	        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {  
	            ip = request.getRemoteAddr();  
	        }  
	        return ip;  
	    }  

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
