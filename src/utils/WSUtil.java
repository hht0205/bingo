package utils;

import java.text.SimpleDateFormat;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;



public class WSUtil {
	 static Log log = LogFactory.getLog(WSUtil.class);
	 private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	 static Logger logger=Logger.getLogger(WSUtil.class);
	 public static void error(Exception e){
	        log.error(e,e.fillInStackTrace());
	     }
		
		public static void PrintDebug(Object str){
			log.info(str);		
		}
}
