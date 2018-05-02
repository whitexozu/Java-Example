package streamExample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class dupCheckExam {

	// /fshome/caf000/stt/seoul/text/20180214/12/00020843_00161_20180214124522_20180214124629_0_01b202b47d9d88e3158401270.dat : [20180214_00161_01b202b47d9d88e3158401270, 00161, 158401270, 01b202b47d9d88e3, 20180214124832, E, 003, E0010, 08, AA50208, GT00002000, G, T0, 0002, 000, 23, , 01056682183,
	// 0, NO]
	// /fshome/caf000/stt/seoul/text/20180214/12/00021118_00161_20180214124832_20180214124855_0_01b202b47d9d88e3158401270.dat : [20180214_00161_01b202b47d9d88e3158401270, 00161, 158401270, 01b202b47d9d88e3, 20180214124832, E, 003, E0010, 08, AA50208, GT00002000, G, T0, 0002, 000, 23, , 01056682183,
	// 0, NO]

	public static List<String> fsArr = new ArrayList<String>();
	public static List<Sttta> dpFsArr = new ArrayList<Sttta>();

	public static void main(String[] args) {
		fsArr.add("/fshome/caf000/stt/seoul/text/20180214/12/00020843_00161_20180214124522_20180214124629_0_01b202b47d9d88e3158401270.dat");
		fsArr.add("/fshome/caf000/stt/seoul/text/20180214/12/00021118_00161_20180214124832_20180214124855_0_01b202b47d9d88e3158401270.dat");
		fsArr.add("/fshome/caf000/stt/seoul/text/20180214/12/00021118_00161_20180214124833_20180214124855_0_01b202b47d9d88e3158401270.dat");
		fsArr.add("/fshome/caf000/stt/seoul/text/20180214/12/00021118_00171_20180214124801_20180214124801_0_01b202b47d9d88e3158401271.dat");
		fsArr.add("/fshome/caf000/stt/seoul/text/20180214/12/00021118_00171_20180214124802_20180214124802_0_01b202b47d9d88e3158401271.dat");
		
		
		for(String s : fsArr) {
			String[] temp = s.split("_");
			String filePathStttaid = temp[2].substring(0, 8) + "_" + temp[1] + "_" + temp[5].substring(0, temp[5].lastIndexOf("."));
//			System.out.println(temp[2].substring(8, 14));
			dpFsArr.add(new Sttta(filePathStttaid, temp[2].substring(8, 14)));
		}
		
		
		Map<String, List<Sttta>> stttas = dpFsArr.stream().collect(Collectors.groupingBy(Sttta::getStttaid));
		Map<String, List<Sttta>> stttasForSort = new LinkedHashMap<String, List<Sttta>>(); 
		
		stttas.entrySet().stream().forEach(b -> {
			List<Sttta> tempList = new LinkedList<Sttta>(); 
			b.getValue().stream().sorted( Comparator.reverseOrder() )
				.forEach(s -> {
					tempList.add(new Sttta(s.getStttaid(), s.getRegTime()));
				});
			stttasForSort.put(b.getKey(), tempList);
		});
		
		for ( String key : stttasForSort.keySet() ) {
			int sortNum = 1;
			for ( Sttta s : stttasForSort.get(key) ) {
				s.setSortNum(sortNum++);
			}
		}
		
		stttasForSort.entrySet().stream().forEach(m -> {
			m.getValue().forEach(s -> System.out.println(s.getStttaid() + ":" + s.getRegTime() + ":" + s.getSortNum()));
		});
		
	}
}
