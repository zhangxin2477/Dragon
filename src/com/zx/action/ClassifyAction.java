package com.zx.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.zx.common.Page;
import com.zx.entity.Classify;
import com.zx.service.ClassifyServiceInterface;

@SuppressWarnings("serial")
public class ClassifyAction extends ActionSupport {
	private ClassifyServiceInterface classifyServiceInterface;
	private String result;
	private Page pageList;
	private Classify classify;
	private List<Classify> classifyList;
	private String params;

	public String addClassify() {
		if (classify != null) {
			if (classifyServiceInterface.addClassify(classify))
				result = SUCCESS;
		}
		return SUCCESS;
	}

	public String deleteClassify() {
		if (classify != null && classify.getId() != null) {
			if (this.classifyServiceInterface.deleteClassify(classify))
				result = SUCCESS;
		}
		return SUCCESS;
	}

	public String updateClassify() {
		if (classify != null && classify.getId() != null) {
			if (this.classifyServiceInterface.updateClassify(classify))
				result = SUCCESS;
		}
		return SUCCESS;
	}

	public String getClassifyPage() {
		if (pageList != null) {
			pageList = this.classifyServiceInterface.getClassify(pageList
					.getPageNow());
		}
		return SUCCESS;
	}

	public String getCList() {
		if (params == null) {
			params = "";
		}else{
			System.out.println(params);
		}
		classifyList = this.classifyServiceInterface.getClassify(params);
		return SUCCESS;
	}

	public ClassifyServiceInterface getClassifyServiceInterface() {
		return classifyServiceInterface;
	}

	public void setClassifyServiceInterface(
			ClassifyServiceInterface classifyServiceInterface) {
		this.classifyServiceInterface = classifyServiceInterface;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Page getPageList() {
		return pageList;
	}

	public void setPageList(Page pageList) {
		this.pageList = pageList;
	}

	public Classify getClassify() {
		return classify;
	}

	public void setClassify(Classify classify) {
		this.classify = classify;
	}

	public List<Classify> getClassifyList() {
		return classifyList;
	}

	public void setClassifyList(List<Classify> classifyList) {
		this.classifyList = classifyList;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}
}
