package yude.mes.com.mes_yd.common.exception;


import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import yude.mes.com.mes_yd.common.utils.R;

/**
 * 异常处理器
 *
 * @author wangpw
 * @creat 2018-09-10
 */
@RestControllerAdvice
public class BTExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 自定义异常
	 */
//	@ExceptionHandler(BTException.class)
//	public R handleRRException(RRException e) {
//		R r = new R();
//		r.put("code", e.getCode());
//		r.put("msg", e.getMessage());
//
//		return r;
//	}

	@ExceptionHandler(DuplicateKeyException.class)
	public R handleDuplicateKeyException(DuplicateKeyException e) {
		logger.error(e.getMessage(), e);
		return R.error("数据库中已存在该记录");
	}

	@ExceptionHandler(AuthorizationException.class)
	public ModelAndView handleAuthorizationException(AuthorizationException e) {
		ModelAndView mView = new ModelAndView("403");
		return mView;
//		logger.error(e.getMessage(), e);
//		return R.error("没有权限，请联系管理员授权");
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e) {
		ModelAndView mView = new ModelAndView("500");
		return mView;
	}
}
