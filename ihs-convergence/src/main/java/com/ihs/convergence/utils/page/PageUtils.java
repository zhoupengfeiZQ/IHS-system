package com.ihs.convergence.utils.page;

import com.github.pagehelper.PageHelper;

/**
 * 
 * 项目名 ihs 将分页信息转成我们需要的格式
 * 
 * @author pengfei.zhou
 * @date 2017年1月20日
 *
 */
public class PageUtils {

	public static void page(Page page) {
		PageHelper.startPage(page.getPageNo(), page.getPageSize());
	}

	public static void page(Page inputPage, SortTypes sortType) {
		PageHelper.startPage(inputPage.getPageNo(), inputPage.getPageSize(), sortType.toString());
	}

}
