package com.aoto.util;

import javax.servlet.ServletContext;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
 
/**
 *功能描述：获取spring容器，以访问容器中定义的其他bean 
 */
 
public class SpringContextUtil implements ApplicationContextAware {


  /** 
  * 以静态变量保存Spring ApplicationContext, 可在任何代码任何地方任何时�?�中取出ApplicaitonContext. 
  *   
  *  
  */
        private static ApplicationContext applicationContext; //Spring应用上下文环�?   
        
        /**
         * 静�?�资源路�?
         */
        private @Value("${web.staticPath}") String staticPath;
 
        /**  
         * 实现ApplicationContextAware接口的回调方法，设置上下文环�?     
         * @param applicationContext  
         * @throws BeansException  
         */
        public void setApplicationContext(ApplicationContext applicationContext)
                        throws BeansException {
                SpringContextUtil.applicationContext = applicationContext;
                
                if (applicationContext instanceof WebApplicationContext)
                {
                    ServletContext servletContext = ((WebApplicationContext)applicationContext).getServletContext();
                    String contextPath = servletContext.getContextPath();
                    
                    if (StringUtils.isEmpty(staticPath))
                    {
                        staticPath = contextPath;
                    }

                    servletContext.setAttribute("staticPath", staticPath);
                    servletContext.setAttribute("contextPath", contextPath);
                }
                
                
        }
 
        public static ApplicationContext getApplicationContext() {
                return applicationContext;
        }
 
        /**  
         * 获取对象     
         * @param name  
         * @return Object �?个以�?给名字注册的bean的实�?  
         * @throws BeansException  
         */
        public static Object getBean(String name) throws BeansException {
                return applicationContext.getBean(name);
        }
 
        /**  
         * 获取类型为requiredType的对�?  
         * 如果bean不能被类型转换，相应的异常将会被抛出（BeanNotOfRequiredTypeException�?  
         * @param name       bean注册�?  
         * @param requiredType 返回对象类型  
         * @return Object 返回requiredType类型对象  
         * @throws BeansException  
         */
        public static Object getBean(String name, Class requiredType)
                        throws BeansException {
                return applicationContext.getBean(name, requiredType);
        }
 
        /**  
         * 如果BeanFactory包含�?个与�?给名称匹配的bean定义，则返回true   
         * @param name  
         * @return boolean  
         */
        public static boolean containsBean(String name) {
                return applicationContext.containsBean(name);
        }
 
        /**  
         * 判断以给定名字注册的bean定义是一个singleton还是�?个prototype�?  
         * 如果与给定名字相应的bean定义没有被找到，将会抛出�?个异常（NoSuchBeanDefinitionException�?     
         * @param name  
         * @return boolean  
         * @throws NoSuchBeanDefinitionException  
         */
        public static boolean isSingleton(String name)
                        throws NoSuchBeanDefinitionException {
                return applicationContext.isSingleton(name);
        }
 
        /**  
         * @param name  
         * @return Class 注册对象的类�?  
         * @throws NoSuchBeanDefinitionException  
         */
        public static Class getType(String name)
                        throws NoSuchBeanDefinitionException {
                return applicationContext.getType(name);
        }
 
        /**  
         * 如果给定的bean名字在bean定义中有别名，则返回这些别名     
         * @param name  
         * @return  
         * @throws NoSuchBeanDefinitionException  
         */
        public static String[] getAliases(String name)
                        throws NoSuchBeanDefinitionException {
                return applicationContext.getAliases(name);
        }
} 
