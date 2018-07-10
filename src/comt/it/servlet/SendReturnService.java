package comt.it.servlet;



/**
 * @author wuyz:
 * @version 创建时间：2015年11月18日 下午2:38:45
 */

public interface SendReturnService {
	//基础返回
	public  String SetHeaderAndReturn(String returnstr);
	//登录返回
	public String SetHeaderAndReturn(String returnstr,int errorCount);
	//带翻页列表返回
	public String SetHeaderAndReturnWithPageInfo(String returnstr,int currentPage,int pageSize,int totalItems,int totalPages);
	//返回状态码及信息
	public String SetReturnInfo(String returnstr,String remap);
    	

}
