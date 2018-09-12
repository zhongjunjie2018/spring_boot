package com.zjj.exercise.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局的异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandle {

    public static final String DEFAULT_ERROR_VIEW = "error";
    public static final String DEFAULT_ERROR_VIEW2 = "404";

    /**
     * 异常处理
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req,Exception e){
        return getModelAndView(req, e, DEFAULT_ERROR_VIEW);
    }

    /**
     * 404处理
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = ClassNotFoundException.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req,ClassNotFoundException e){
        return getModelAndView(req, e, DEFAULT_ERROR_VIEW2);
    }

    /**
     * 页面跳转
     * @param req
     * @param e
     * @param defaultErrorView
     * @return
     */
    private ModelAndView getModelAndView(HttpServletRequest req, Exception e, String defaultErrorView) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",req.getRequestURL());
        mav.setViewName(defaultErrorView);
        return mav;
    }

    /**
     * json异常
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setMessage(e.getMessage());
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setUrl(req.getRequestURL().toString());
        return r;
    }




}
