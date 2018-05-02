package cast;

import java.util.HashSet;

public class ArrayToHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] temp = new String[]{
				"cp --parents src/main/webapp/resources/js/common/common-d3Chart.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/jsp/stt/analyzeFileInq.jsp /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/jsp/sysadm/trace.jsp /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/sysadm/trace.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/mybatis/mysql/sql-common-mapper.xml /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/common/web/CommonController.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/common/service/CommonService.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/common/serviceImpl/CommonServiceImpl.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/common/dao/CommonDao.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/common/daoImpl/CommonDaoImpl.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/common/vo/TraceVO.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/openApi/controller/OpenApiController.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/common/common-tooltip.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/common/intercepter/LoginInterceptor.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/common/util/StringUtil.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/cstcallas/controller/CstCallSrcController.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/groupManagement/controller/GroupManagementController.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/groupManagement/dao/GroupManagementDao.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/groupManagement/daoImpl/GroupManagementDaoImpl.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/groupManagement/service/GroupManagementService.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/groupManagement/serviceImpl/GroupManagementServiceImpl.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/login/controller/LoginController.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/mybatis/mysql/sql-group-mapper.xml /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/mybatis/mysql/sql-member-mapper.xml /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/css/common/kbCommon.css /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/comm/player/control.min.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/comm/dtlRpt.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/common/layout/updateGroupModalLayout.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/common/common.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/common/common-table.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/cstcall/cstCall.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/csttrnd/trndAnlsView.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/dashboard/dashBoard.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/groupManagement/group.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/login/join.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/viewGenerator/viewGenerator.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/libs/smartAdmin/css/smartadmin-production.min.css /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/jsp/comm/dtlRpt.jsp /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/jsp/common/include/jqueryTmpl.jspf /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/jsp/common/layout/updateGroupModalLayout.jsp /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/jsp/cstcall/cstCall.jsp /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/jsp/csttrnd/trndAnlsView.jsp /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/jsp/dashboard/dashBoard.jsp /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/vocanls/riptAnls.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/mybatis/mysql/sql-riptAnls-mapper.xml /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/common/common-table.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/jsp/common/include/jqueryTmpl.jspf /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/jsp/itemGroup/itemGroupDetail.jsp /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/jsp/itemGroup/itemGroupList.jsp /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/itemGroup/itemGroupDetail.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/itemGroup/itemGroupList.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/jsp/inspStnd/inspStndDetail.jsp /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/inspStnd/inspStndDetail.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/scriptManager/stndScriptManagerList.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/scriptManager/stndScriptManagerDetail.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/jsp/scriptManager/stndScriptManagerDetail.jsp /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/commas/controller/SmrClsRsltController.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/commas/serviceImpl/DtlRptServiceImpl.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/common/manager/CodeManager.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/common/common-chartJs.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/resources/js/common/common-d3Chart.js /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/commas/serviceImpl/KwdTrndAnlsServiceImpl.java /fshome/caf000/downloads/resource/deploy/TA_KB"
				,"cp --parents src/main/webapp/WEB-INF/java/com/kbstar/caf/as/csttrndas/serviceImpl/TrndAnlsServiceImpl.java /fshome/caf000/downloads/resource/deploy/TA_KB"
		};
		
		HashSet hs = new HashSet();
		for(String s : temp) {
			hs.add(s);
		}
		
		System.out.println(hs.size());
			
		
	}

}
