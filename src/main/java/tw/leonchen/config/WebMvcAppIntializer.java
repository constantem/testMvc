package tw.leonchen.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//相當於web.xml的java程式
public class WebMvcAppIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	//設定設定相當於beans.config.xml(application.xml)的java程式組態
	@Override
	protected Class<?>[] getRootConfigClasses() {
		//return new Class[] {RootAppConfig.class};
		return null;
	}

	//設定設定相當於mvc-servlet.xml的java程式組態
	@Override
	protected Class<?>[] getServletConfigClasses() {
		//return new Class[] {WebMvcAppConfig.class};
		return null;
	}

	//設定url-pattern mapping路徑的位置
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter cef = new CharacterEncodingFilter();
		cef.setEncoding("UTF-8");
		cef.setForceEncoding(true);
		return new Filter[] {cef};
	}	

}
