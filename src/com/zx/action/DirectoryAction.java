package com.zx.action;

import java.util.List;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.zx.common.Page;
import com.zx.entity.Directory;
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
	private Directory directory;
	private Page dir_page;
	private List<SDirectory> s_list;

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

	public String getSDirPage() {
		try {
			if (sdir_page != null) {
				sdir_page = directoryServiceInterface.getAllSDir(sdir_page
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
	public String addDir() {
		try {
			if (directory != null) {
				if (directoryServiceInterface.addDir(directory)) {
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

	public String deleteDir() {
		try {
			if (directory.getId() != null) {
				if (directoryServiceInterface.deleteDir(directory)) {
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

	public String updateDir() {
		try {
			if (directory != null && directory.getId() != null
					&& directory.getName() != null) {
				if (directoryServiceInterface.updateDir(directory)) {
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

	public String getDirPage() {
		try {
			if (dir_page != null) {
				dir_page = directoryServiceInterface.getAllDir(dir_page
						.getPageNow());
			} else {
				System.out.println("dir_page is null!");
			}
		} catch (Exception e) {
			System.out.println("exception:" + e.getMessage());
		}
		return Action.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String getSdirForDir() {
		try {
			s_list = (List<SDirectory>) directoryServiceInterface
					.findSdirList();
			result = SUCCESS;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			result = ERROR;
		}
		return SUCCESS;
	}

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

	public Directory getDirectory() {
		return directory;
	}

	public void setDirectory(Directory directory) {
		this.directory = directory;
	}

	public Page getDir_page() {
		return dir_page;
	}

	public void setDir_page(Page dir_page) {
		this.dir_page = dir_page;
	}

	public List<SDirectory> getS_list() {
		return s_list;
	}

	public void setS_list(List<SDirectory> s_list) {
		this.s_list = s_list;
	}

}
