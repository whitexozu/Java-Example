package algorithm;

import java.util.ArrayList;

public class ClusteringEngine implements Runnable {
	volatile Thread timer;
	public ArrayList<weight> dataSet;
	public ArrayList<KCluster> kSet;
	public int length;
	public double threshold = 0.005;

	public double err = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (timer == Thread.currentThread()) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			// running Method
			clustering();
			if (!rePosition())
				stop();
		}
	}

	public void start() {
		timer = new Thread(this);
		timer.start();
	}

	public void stop() {
		timer = null;
	}

	public ClusteringEngine(int length, int dataSize, int kSize) {
		dataSet = new ArrayList<weight>();
		kSet = new ArrayList<KCluster>();
		this.length = length;

		for (int i = 0; i < dataSize; i++) // initializing dataSet
			dataSet.add(new weight(length, true));

		for (int i = 0; i < kSize; i++) // initializing KClusterSet
			kSet.add(new KCluster(length, true, i));
	}

	public void clustering() {
		for (weight w : dataSet)
			w.setNumber(getBestClass(w));
	}

	public int getBestClass(weight w) { // 웨이트와 가장 가까운 k를 찾아 거기에 해당하는 넘버를 리턴
		KCluster min = kSet.get((int) (Math.random() * kSet.size()));
		for (KCluster k : kSet)
			if (!min.equals(k) && min.distance(w) > k.distance(w))
				min = k;
		return min.getNumber();
	}

	public boolean rePosition() {
		double avgDist = 0;
		for (int i = 0; i < kSet.size(); i++) {
			weight avgWeight = averaging(i);
			KCluster k = kSet.get(i);
			avgDist += avgWeight.distance(k);
			k.setWeight(avgWeight);
		}
		avgDist /= kSet.size();
		err = avgDist;
		if (avgDist > threshold)
			return true; // 재배치를 하였으면 true
		else
			return false; // 아니면 false
	}

	public weight averaging(int num) { // 클래스 넘버에 해당하는 데이터만 찾아서 평균위치를 찾음.
		weight avg = new weight(length, false);
		int count = 0;
		for (weight w : dataSet)
			if (num == w.getNumber()) {
				for (int i = 0; i < length; i++)
					avg.set(i, avg.get(i) + w.get(i));
				count++;
			}
		for (int i = 0; i < length; i++)
			avg.set(i, avg.get(i) / count);
		return avg;
	}

	public ArrayList<weight> getDataArray() {
		return dataSet;
	}

	public ArrayList<KCluster> getKArray() {
		return kSet;
	}
}