package comt.it.servlet;


public class BingoHanderImp extends ServletAbstractHandler {
	
	protected SendReturnService sReturnService=new SendReturnImp();
	public String getPlay(String head,String params,String ip) {
		
		
		return sReturnService.SetHeaderAndReturn("0000");
	}
}
