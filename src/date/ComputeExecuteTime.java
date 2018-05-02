package date;

import java.util.Calendar;

public class ComputeExecuteTime {
 
 
    /*****************************************
     * 프로그램 실행시간 계산
     * @param args
     *****************************************/
    public static void main(String[] args) {
 
        // 시작 시간
        long startTime = System.currentTimeMillis();
 
        // 실행 시간 체크될 녀석들...
        for(int i=0; i<100000000; i++){
            ;
        }
         
        // 종료 시간
        long endTime = System.currentTimeMillis();
 
        // 시간 출력
        System.out.println("##  시작시간 : " + new ComputeExecuteTime().formatTime(startTime));
        System.out.println("##  종료시간 : " + new ComputeExecuteTime().formatTime(endTime));
        System.out.println("##  소요시간(초.0f) : " + ( endTime - startTime )/1000.0f +"초"); 
    }    // end main()
 
     
    /**************************************************************
     * <p>Description : 밀리초(ms)단위의 시간을 시분초로 포멧<p>
     *
     * @param     {long}    lTime 미리초단위 시간
     * @return     포매팅된 문자열
     * @throws 
     * @since     2008-09-22
     **************************************************************/
    public String formatTime(long lTime) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(lTime);
        return (c.get(Calendar.HOUR_OF_DAY) + "시 " + c.get(Calendar.MINUTE) + "분 " + c.get(Calendar.SECOND) + "." + c.get(Calendar.MILLISECOND) + "초");
    }    // end function formatTime()
 
}    // end class