package comt.it.servlet;



/**
 * @author wuyz:
 * @version ����ʱ�䣺2015��11��18�� ����2:38:45
 */

public interface SendReturnService {
	//��������
	public  String SetHeaderAndReturn(String returnstr);
	//��¼����
	public String SetHeaderAndReturn(String returnstr,int errorCount);
	//����ҳ�б���
	public String SetHeaderAndReturnWithPageInfo(String returnstr,int currentPage,int pageSize,int totalItems,int totalPages);
	//����״̬�뼰��Ϣ
	public String SetReturnInfo(String returnstr,String remap);
    	

}
