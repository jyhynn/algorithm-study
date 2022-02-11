import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    public int solution(int[] scoville, int K) {
        Arrays.sort(scoville);
		PriorityQueue<Integer> underK = new PriorityQueue<Integer>();
		
		// K ���� ���ҿ� K�������� ū ���� �켱����ť�� ����
		int sum = 0;
		for(int i=0; i<scoville.length; i++) {
			int val = scoville[i];
			if(val<=K) {
				underK.add(val);
				sum += val;
			}else {
				if(K > 0) sum += val;	
				underK.add(val);
				break;
			}
		}
			
		// ť�� ���� ���� ���� 0�� ��� {0,0,..,0}
		if(sum == 0) {
			if(K == 0) return 0;	//	K�� ���� ���� �����ϱ�...?
			else return -1;			//	0���δ� �ƹ��͵� �� �� ����...
		}
		if(underK.size() < 2) return -1;	// ť�� ���� ���� 0~1���� ��� ���� ����x
		
		int calCnt = 0;		// ��� Ƚ��
		int min = underK.poll();	// ���� ���� ����
		
		if(min == K) return 0;
		
		int highest = -1;			// �ʱ�ȭ
		while (!underK.isEmpty()) {
			highest = min + underK.poll()*2;
			calCnt++;
			if(highest>=K) {
				break;
			}else {
				underK.add(highest);	// �ٽ� ť�� ������ �ּҰ� ����
				min = underK.poll();
			}
		}
		
		if(highest < K) return -1;		// ���� K �̻��� �� ���� ���
		
        int answer = calCnt;
        return answer;
    }
}