package kr.bit.digitalhsp.mapping.aop;
import kr.bit.digitalhsp.mapping.exception.ErrorException;
import kr.bit.digitalhsp.mapping.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;


/**
 * 
 * @FileName : AopCommon.java
 * @Project : LGUPHR-Mobile-Server-Plus
 * @Date : 2012. 12. 13.
 * @Writer : shinminjae
 * @fixed history : kr.bit.uhealth.lgu.phr.mobile.controller 컨트롤러로 들어가는 모든 요청의 진입전과 진입후를 제어하여
 * 프로퍼티 검사, 로그 기록,암 복화를 일체 처리한다.   
 * @explain :
 */

@Component
public class AopCommon {

	
	
	
	Logger LOGGER = Logger.getLogger(AopCommon.class);
	
	//private static Logger LOGGER = Logger.getLogger(AopCommon.class);

	/**
	 * **************************************************************
	 * 
	 * @history 2012.09.07 shinminjae첫개발
	 * @brief 들어온 문자의 양옆에 홀따옴표를 붙여줍니다.
	 * @example aaa => 'aaa'
	 * @method wrapString
	 * @author shinminjae
	 * @date 2012. 9. 7.
	 * @param str
	 * @return
	 *************************************************************** 
	 */
	private static String wrapString(String str) {
		if (str == null)
			str = "NULL";
		else
			str = "'" + str + "'";
		return str;
	}




	/**
	 * **************************************************************
	 * 
	 * @history
	 * @brief 모든 Request 와 Response 들의 기본 셋팅과 로그를 여기서 AOP로 처리한다.
	 * @method setBasic
	 * @author shinminjae
	 * @date 2012. 9. 10.
	 * @param joinPoint
	 *************************************************************** 
	 */
	
	public Object setBasic(ProceedingJoinPoint joinPoint) {
		
		
		 
		//joinPoint.getArgs();
		
		Object returnStr = "";
		try {
			returnStr = joinPoint.proceed();
			LOGGER.info(
					""," 정상 연결입니다.","","");
			
		} catch (ErrorException e) {
			// TODO Auto-generated catch block
			LOGGER.error("", "" + " 연결 오류입니다.","서버 오류입니다. " + e.getErrMsg(), "");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			
			LOGGER.error("", "" + " 연결 오류입니다.","서버 오류입니다. " + e.getMessage(), "");
		}
		
		return returnStr;
	}
	

	public String printQuery(ProceedingJoinPoint joinPoint) {
		
		String query = "";
		try {
			query = (String)joinPoint.proceed();
			System.out.println(query);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		return query;
	}
}
