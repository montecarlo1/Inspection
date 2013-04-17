package com.bchd.inspection.ui;

/*
 * 自定义Activity基类要实现的接口，主要是因为有些Activity不是直接从Activity集成的，
 * 所以只能通过接口的方式来实现
 */
public interface IBaseActivity {
	
	/*
	 * 初始化时调用
	 */
	void Init();
	
	/*
	 * 析构时调用
	 */
	void Dispose();
}
