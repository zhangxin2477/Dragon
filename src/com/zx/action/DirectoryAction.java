package com.zx.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.zx.common.Page;
import com.zx.entity.SDirectory;
import com.zx.service.DirectoryServiceInterface;

public class DirectoryAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6814614859853635198L;
	private DirectoryServiceInterface directoryServiceInterface;
	private String result;
	private SDirectory sdirectory;
	private Page sdir_page;

	// 子菜单
	public String addSdir() {
		try {
			if (sdirectory != null) {
				if (directoryServiceInterface.addSDir(sdirectory)) {
					result = SUCCESS;
				} else {
					result = ERROR;
				}
			} else {
				result = NONE;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = e.getMessage();
		}
		return Action.SUCCESS;
	}

	public String deleteSdir() {
		try {
			if (sdirectory.getId() != null) {
				if (directoryServiceInterface.deleteSDir(sdirectory)) {
					result = SUCCESS;
				} else {
					result = ERROR;
				}
			} else {
				result = NONE;
			}
		} catch (Exception e) {
			System.out.println("error:" + e.getMessage());
			result = e.getMessage();
		}
		return Action.SUCCESS;
	}

	public String updateSdir() {
		try {
			if (sdirectory != null && sdirectory.getId() != null
					&& sdirectory.getName() != null) {
				if (directoryServiceInterface.updateSDir(sdirectory)) {
					result = SUCCESS;
				} else {
					result = ERROR;
				}
			} else {
				result = NONE;
			}
		} catch (Exception e) {
			System.out.println("error:" + e.getMessage());
			result = e.getMessage();
		}
		return Action.SUCCESS;
	}

	public String getSdir() {
		try {
			if (sdir_page != null) {
				sdir_page = directoryServiceInterface.getSDir(sdir_page
						.getPageNow());
			} else {
				System.out.println("page is null!");
			}
		} catch (Exception e) {
			System.out.println("exception:" + e.getMessage());
		}
		return Action.SUCCESS;
	}

	// 父菜单

	public DirectoryServiceInterface getDirectoryServiceInterface() {
		return directoryServiceInterface;
	}

	public void setDirectoryServiceInterface(
			DirectoryServiceInterface directoryServiceInterface) {
		this.directoryServiceInterface = directoryServiceInterface;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public SDirectory getSdirectory() {
		return sdirectory;
	}

	public void setSdirectory(SDirectory sdirectory) {
		this.sdirectory = sdirectory;
	}

	public Page getSdir_page() {
		return sdir_page;
	}

	public void setSdir_page(Page sdir_page) {
		this.sdir_page = sdir_page;
	}

}
