package com.util;

public class MyPage {
	
	//��ü ������ ����
	
	public int getPageCount(int numPerPage,int dataCount) {
		
		
		int pageCount = 0;
		
		pageCount = dataCount/numPerPage;
		
		
		if(dataCount%numPerPage != 0) {
			
			pageCount++;
			
			
		}
		
		return pageCount;
		
	}
	
	//����¡ ó�� �޼ҵ�
	
	public String pageIndexList(int currentPage,int totalPage, String listUrl) {
		
		int numPerBlock = 5; //������6 7 8 9 10������
		
		int currentPageSetup;
		int page;
		
		StringBuffer sb = new StringBuffer();
		
		
		if(currentPage==0||totalPage==0) {
			return "";
		}
	
		//���ư��� �ּ�
		//list.jsp �⺻ ����Ʈ
		//list.jsp?searchKey=subject&searchValue=111
		
		
		
		if(listUrl.indexOf("?")!=-1) {
			listUrl = listUrl + "&";
			//list.jsp?searchKey=subject&searchValue=111&pageNum=3
		
		}else {
			listUrl = listUrl + "?";
			//list.jsp?pageNum=3
		}
		//1 2 3 4 5 ���� ��
		//�� ���� 6 7 8 9 10���� ��
		
		currentPageSetup = (currentPage/numPerBlock)*numPerBlock;
		
		if(currentPage % numPerBlock == 0) {
			currentPageSetup = currentPageSetup - numPerBlock;
		}
		
		//������
		if(totalPage>numPerBlock && currentPageSetup>0) {
			
			sb.append("<a href=\"" + listUrl + "pageNum="
					+ currentPageSetup + "\">������</a>&nbsp;");
			
			//<a href="list.jsp?pageNum=5">������</a>&nbsp;
		}
		
		
		//�ٷΰ��� ������
		
		page = currentPageSetup + 1;
		
		while(page<=totalPage && page <= (currentPageSetup + numPerBlock)) {
			
			if(page==currentPage) {
				sb.append("<font color=\"Fuchsia\">" + page + "</font>&nbsp;");
				//font color="Fuchsia">9</font>&nbsp;
				
			}else {
				
				
				sb.append("<a href=\"" + listUrl + "pageNum=" + page + "\">"
						+  page + "</a>&nbsp;");
				//<a href=list.jsp?pageNum=8">8</a>&nbsp;
				
			}
			
			page++;
			
			
		}
		
		
		//�� ���� 6 7 8 9 10 ���� ��
		//�� ���� 11 12
		
		if(totalPage-currentPageSetup>numPerBlock) {
			
			sb.append("<a href=\"" + listUrl + "pageNum=" + page +
					"\">������</a>&nbsp;");
			
			//<a href="list.jsp?pageNum=11"������</a>;
			
		}
		
		return sb.toString();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
