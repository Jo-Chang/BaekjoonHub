import java.io.*;
import java.util.*;

public class Main {

	static class StationInfo {
		double distance;
		boolean isEssential;
		String arrive, departure;

		public StationInfo(double distance, boolean isEssential) {
			this.distance = distance;
			this.isEssential = isEssential;
			this.arrive = this.departure = "-:-";
		}
	}

	static Map<String, StationInfo> MAP;

	static {
		MAP = new HashMap<>();
		MAP.put("Seoul", new StationInfo(0.0, true));
		MAP.put("Chupungnyeong", new StationInfo(234.7, false));
		MAP.put("Yeongdeungpo", new StationInfo(9.1, true));
		MAP.put("Gimcheon", new StationInfo(253.8, true));
		MAP.put("Anyang", new StationInfo(23.9, false));
		MAP.put("Gumi", new StationInfo(276.7, true));
		MAP.put("Suwon", new StationInfo(41.5, true));
		MAP.put("Sagok", new StationInfo(281.3, false));
		MAP.put("Osan", new StationInfo(56.5, false));
		MAP.put("Yangmok", new StationInfo(289.5, false));
		MAP.put("Seojeongri", new StationInfo(66.5, false));
		MAP.put("Waegwan", new StationInfo(296.0, true));
		MAP.put("Pyeongtaek", new StationInfo(75.0, true));
		MAP.put("Sindong", new StationInfo(305.9, false));
		MAP.put("Seonghwan", new StationInfo(84.4, false));
		MAP.put("Daegu", new StationInfo(323.1, true));
		MAP.put("Cheonan", new StationInfo(96.6, true));
		MAP.put("Dongdaegu", new StationInfo(326.3, true));
		MAP.put("Sojeongni", new StationInfo(107.4, false));
		MAP.put("Gyeongsan", new StationInfo(338.6, false));
		MAP.put("Jeonui", new StationInfo(114.9, false));
		MAP.put("Namseonghyeon", new StationInfo(353.1, false));
		MAP.put("Jochiwon", new StationInfo(129.3, true));
		MAP.put("Cheongdo", new StationInfo(361.8, false));
		MAP.put("Bugang", new StationInfo(139.8, false));
		MAP.put("Sangdong", new StationInfo(372.2, false));
		MAP.put("Sintanjin", new StationInfo(151.9, false));
		MAP.put("Miryang", new StationInfo(381.6, true));
		MAP.put("Daejeon", new StationInfo(166.3, true));
		MAP.put("Samnangjin", new StationInfo(394.1, false));
		MAP.put("Okcheon", new StationInfo(182.5, false));
		MAP.put("Wondong", new StationInfo(403.2, false));
		MAP.put("Iwon", new StationInfo(190.8, false));
		MAP.put("Mulgeum", new StationInfo(412.4, false));
		MAP.put("Jitan", new StationInfo(196.4, false));
		MAP.put("Hwamyeong", new StationInfo(421.8, false));
		MAP.put("Simcheon", new StationInfo(200.8, false));
		MAP.put("Gupo", new StationInfo(425.2, true));
		MAP.put("Gakgye", new StationInfo(204.6, false));
		MAP.put("Sasang", new StationInfo(430.3, false));
		MAP.put("Yeongdong", new StationInfo(211.6, true));
		MAP.put("Busan", new StationInfo(441.7, true));
		MAP.put("Hwanggan", new StationInfo(226.2, false));
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			String station = st.nextToken();
			MAP.get(station).arrive = st.nextToken();
			MAP.get(station).departure = st.nextToken();
		}

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());

			String departure = st.nextToken();
			String destination = st.nextToken();

			double time = getHours(MAP.get(departure).departure, MAP.get(destination).arrive);
			double distance = Math.abs(MAP.get(destination).distance - MAP.get(departure).distance);

			sb.append(distance / time).append("\n");
		}

		System.out.println(sb);
	}

	static double getHours(String time1, String time2) {
		if (time1.equals("-:-") || time2.equals("-:-"))
			return 0;

		int time = 0;
		String[] t1 = time1.split(":");
		String[] t2 = time2.split(":");

		int h1 = Integer.parseInt(t1[0]);
		int h2 = Integer.parseInt(t2[0]);
		if (h2 < h1)
			h2 += 24;

		int m1 = Integer.parseInt(t1[1]);
		int m2 = Integer.parseInt(t2[1]);

		return h2 - h1 + ((double) m2 - m1) / 60;
	}

}